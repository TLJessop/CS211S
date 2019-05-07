package Homework;

import java.util.concurrent.BlockingQueue;

public class ServeThread implements Runnable {

    //Instance data
    BlockingQueue<Food> ready;

    //Constructor
    public ServeThread(BlockingQueue<Food> ready){
        this.ready = ready;
    }

    @Override
    public void run(){

        try {
            while ( !ready.isEmpty() || Thread.activeCount() > 3){
                Food currentFood = ready.poll();
                if (currentFood != null) {
                    System.out.println("Server starting " + currentFood);
                    Thread.sleep(currentFood.getServeTime() * 1000);
                    System.out.println("Server done with " + currentFood);
                    System.out.println("Server ready");
                } else {
                    continue;
                }
            }
        } catch (InterruptedException e){
            System.out.println("Server thread interrupted");
            return;
        }

    }

}//ServeThread
