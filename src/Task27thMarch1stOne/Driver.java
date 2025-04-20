package Task27thMarch1stOne;

public class Driver {
    public static void main(String[] args) {
        FullTimeEmployee emp=new FullTimeEmployee("Soumyodip",50000.00,1000);
        emp.FullTimeEmployeeInfo();

        System.out.println();

        PartTimeEmployee emp1=new PartTimeEmployee("Shuvam",50000.00,70);
        emp1.PartTimeEmployeeInfo();
    }
}
