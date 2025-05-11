package PolyMorphismExample;

public class Student extends Person{
    private int studentId;

    Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId=studentId;
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.print(" "+this.studentId);
    }
}
