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

    }

}//ServeThread
