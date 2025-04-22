package Task27thMarch1stOne;

public class PartTimeEmployee extends Employee{

    private int workingHours;

    public PartTimeEmployee(String name, double salary, int workingHours) {
        super(name, salary);
        this.workingHours=workingHours;
    }

    public void PartTimeEmployeeInfo(){
        employeeInfo();
        System.out.print(" "+this.workingHours);
    }
}
