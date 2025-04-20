package Task27thMarch;

public class PartTimeEmployee extends Employee{

    private int workingHours;

    public PartTimeEmployee(String name, double salary, int workingHours) {
        super(name, salary);
        this.workingHours=workingHours;
    }

    public void PartTimeEmployeeInfo(){
        employeeIngo();
        System.out.print(" "+this.workingHours);
    }
}
