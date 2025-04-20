package Task27thMarch;

public class FullTimeEmployee extends Employee{

    private int bonus;

    public FullTimeEmployee(String name, double salary, int bonus) {
        super(name, salary);
        this.bonus=bonus;
    }

    public void FullTimeEmployeeInfo(){
        employeeIngo();
        System.out.println(this.bonus);
    }
}
