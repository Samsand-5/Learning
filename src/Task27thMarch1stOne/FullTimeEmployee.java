package Task27thMarch1stOne;

public class FullTimeEmployee extends Employee{

    private int bonus;

    public FullTimeEmployee(String name, double salary, int bonus) {
        super(name, salary);
        this.bonus=bonus;
    }

    public void FullTimeEmployeeInfo(){
        employeeInfo();
        System.out.print(" "+this.bonus);
    }
}
