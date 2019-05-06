package VideoCodeAlong;

import java.time.LocalDateTime;

public class DatePrintRunnable implements  Runnable{

    //Instance data
    private int delay, times;

    //Constructor
    public DatePrintRunnable(int delay, int times){
        this.delay = delay;
        this.times = times;
    }

    //Overridden method
    @Override
    public void run(){
        for (int i = 0; i <= times; i++) {
            try {
                System.out.println(LocalDateTime.now());
                Thread.sleep(delay);
            } catch (InterruptedException e){
                System.out.println("Interrupted");
                return;
            }
        }
    }
}//DatePrintRunnable
