package Workspace;

public final class Worker {

    private final double salary;
    private final Manager boss;
    private final String name;

    public Worker(double salary, Manager boss, String name) {
        this.salary = salary;
        this.boss = new Manager(boss.getName(), boss.getSalary());
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public Manager getBoss() {
        return new Manager(boss.getName(), Double.valueOf(boss.getSalary()));
    }

    public String getName() {
        return name;
    }
}//Worker
