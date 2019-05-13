package VideoCodeAlong;

public class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, int employeeId, Payer payer) {
        super(name, employeeId, payer);
    }



    @Override
    public void benefits() {
        System.out.println(" no benefits");
    }

    @Override
    public void timeOff() {
        System.out.println(" no time off");
    }

    @Override
    public void process() {
        System.out.println("processing");
    }

}//Class PartTimeEmployee
