package VideoCodeAlong;

public class NotPaidPayer implements Payer {
    @Override
    public void pay(){
        System.out.println("Receives no pay");
    }

}//Class NotPaidPayer
