package VideoCodeAlong;

public class CommissionPayer implements Payer {
    @Override
    public void pay(){
        System.out.println("Paying based on commission");
    }

}//Class CommissionPayer
