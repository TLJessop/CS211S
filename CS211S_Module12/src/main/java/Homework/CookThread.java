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
                Food currentFood = thingsToMake.get(0);
                //if (ready.offer(currentFood))
                if (true)
                {
                System.out.println("Cook starting " + currentFood);
                Thread.sleep(currentFood.getCookTime() * 1000);
                System.out.println("Cook finishing " + currentFood);

                    thingsToMake.remove(currentFood);
                } else {
                    System.out.println("waiting for window space");
                    continue;
                }
            }
        } catch (InterruptedException e){
            System.out.println("Cook thread interrupted");
            return;
        }
    }

}//CookThread
