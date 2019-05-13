package VideoCodeAlong;

import java.util.Comparator;
import java.util.Objects;


public abstract class Employee implements Comparable<Employee> {

    //Instance variables
    private int employeeId;
    private Payer payer;
    private String name;
    //End of instance variables

    private static int numberOfEmployees = 0;

    public final static Comparator NAME_COMPARATOR = new EmployeeNameComparator();

    public final static Comparator NAME_ID_COMPARATOR = new EmployeeNameThenIdComparator();

    private static class EmployeeNameComparator implements Comparator<Employee> {

        @Override
        public int compare(Employee e1, Employee e2) {
            return e1.name.compareToIgnoreCase(e2.name);
        }
    }

    private static class EmployeeNameThenIdComparator implements Comparator<Employee>{
        @Override
        public int compare(Employee e1, Employee e2) {
            if (e1.name.compareToIgnoreCase(e2.name) != 0){
                return e1.name.compareToIgnoreCase(e2.name);
            }else {
                return Integer.compare(e1.employeeId, e2.employeeId);
            }
        }
    }


    //Constructor
    public Employee(String name, int employeeId, Payer payer) {
        this.name = name;
        this.employeeId=employeeId;
        this.payer = payer;
        numberOfEmployees++;
    }

    //Getters

    public int getEmployeeId() {
        return employeeId;
    }

    public static int getNumberOfEmployees() {
        return numberOfEmployees;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // End of Getters

    @Override
    public String toString() {
        return  this.getClass().getName() + " {" +
                           ", employeeId=" + employeeId +
                '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee employee = (Employee) obj;
        return getEmployeeId() == employee.getEmployeeId();
    }

    @Override
    public int hashCode() {
        return Objects.hash( getEmployeeId());
    }

    @Override
    public int compareTo(Employee otherEmployee){
        return Integer.compare(this.employeeId, otherEmployee.employeeId);
    }

    public void pay(){
        payer.pay();
    }

    public abstract void benefits();

    public abstract void timeOff();

    public abstract void process();
}// class