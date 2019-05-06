package Homework;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable{

    //Instance data
    List<Food> thingsToMake;
    BlockingQueue<Food> ready;

    //Constructor
    public CookThread(List<Food> thingsToMake, BlockingQueue<Food> ready){
        this.thingsToMake = new ArrayList<>(thingsToMake);
        this.ready = ready;
    }

    @Override
    public void run() {
        try {
            while (!thingsToMake.isEmpty()){
                if (ready.remainingCapacity() > 0)
                {
                    Food currentFood = thingsToMake.get(0);
                    System.out.println("Cook Ready");
                    System.out.println("Cook starting " + currentFood);
                    Thread.sleep(currentFood.getCookTime() * 1000);
                    System.out.println("Cook finishing " + currentFood);
                    ready.offer(currentFood);
                    thingsToMake.remove(currentFood);
                } else {
                    continue;
                }
            }
        } catch (InterruptedException e){
            System.out.println("Cook thread interrupted");
            return;
        }
    }

}//CookThread
