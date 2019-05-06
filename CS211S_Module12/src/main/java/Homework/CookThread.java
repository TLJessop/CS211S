package Homework;

import java.util.List;
import java.util.concurrent.BlockingQueue;

public class CookThread implements Runnable{

    //Instance data
    List<Food> thingsToMake;
    BlockingQueue<Food> ready;

    //Constructor
    public CookThread(List<Food> thingsToMake, BlockingQueue<Food> ready){
        this.thingsToMake = thingsToMake;
        this.ready = ready;
    }

    public void run() {

    }

}//CookThread
