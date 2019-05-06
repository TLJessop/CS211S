package VideoCodeAlong;

import java.time.LocalDateTime;

public class DatePrintThread extends Thread {

    //Instance data
    private int delay, times;

    //Constructor
    public DatePrintThread(int delay, int times){
        super("Date Print Thread");
        this.delay = delay;
        this.times = times;
    }

    @Override
    public void run(){
        for (int i = 0; i <= times; i++) {
            try {
                System.out.println(getName() + "    " + LocalDateTime.now());
                Thread.sleep(delay);
            } catch (InterruptedException e){
                System.out.println("Interrupted");
                return;
            }
        }
    }

}//DatePrintThread
