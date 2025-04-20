package Task27thMarch;

public class Employee {

    private String name;
    private double salary;

    public Employee(String name, double salary) {
        this.name = name;
        this.salary = salary;
    }

    public void employeeIngo(){
        System.out.print(this.name+" "+this.salary);
    }
}
