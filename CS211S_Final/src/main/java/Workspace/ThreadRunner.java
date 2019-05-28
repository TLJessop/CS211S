package Workspace;

public class ThreadRunner {

    public static void main(String[] args) {
        Thread namePrint = new MessagePrinter("Thomas", 10);
        Thread summerPrint = new MessagePrinter("Summer", 100);
        namePrint.start();
        summerPrint.start();

    }

}//ThreadRunner
