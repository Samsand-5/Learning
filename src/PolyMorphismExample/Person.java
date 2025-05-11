package PolyMorphismExample;

public class Person {
    private String name;
    private int age;

    Person(String name,int age){
        this.name=name;
        this.age=age;
    }

    public void displayInfo() {
        System.out.print(this.name+" "+this.age);
    }
}