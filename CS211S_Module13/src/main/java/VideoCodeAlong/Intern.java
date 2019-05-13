package VideoCodeAlong;

public class Intern extends Employee {

    public Intern(String name, int employeeId) {
        super(name, employeeId, new NotPaidPayer());
    }

    @Override
    public void benefits() {
        System.out.println("Interns recive the benefit of exp gain");
    }

    @Override
    public void timeOff() {
        System.out.println("Interns do not get time off");
    }

    @Override
    public void process() {
        System.out.println("What does " + getEmployeeId() + " even do here?");
    }
}//Class Intern
