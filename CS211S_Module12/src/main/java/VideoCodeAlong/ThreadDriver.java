package VideoCodeAlong;

public class ThreadDriver {

    public static void main(String[] args) {

        Thread printTread = new DatePrintThread(3000,5);
        printTread.start();

        Thread datePrintRunnable = new Thread(new DatePrintRunnable(2000,5));
        datePrintRunnable.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e){
            e.printStackTrace();
        }

        datePrintRunnable.interrupt();

    }

}//ThreadDriver
