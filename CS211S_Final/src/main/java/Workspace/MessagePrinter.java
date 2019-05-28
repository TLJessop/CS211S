package Workspace;

public class MessagePrinter extends Thread {

    private String message = null;
    private int numberPrints = 0;

    public MessagePrinter(String message, int numberPrints) {
        this.message = message;
        this.numberPrints = numberPrints;
    }

    @Override
    public void run() {
        for (int i = 0; i <= numberPrints ; i++) {
            System.out.println(message);
        }
    }
}//MessagePrinter
