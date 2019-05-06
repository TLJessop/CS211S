package VideoCodeAlong;

public class ThreadDriver {

    public static void main(String[] args) {

        Thread printTread = new DatePrintThread(3000,5);
        printTread.start();
    }

}//ThreadDriver
