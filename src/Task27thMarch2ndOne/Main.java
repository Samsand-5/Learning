package Task27thMarch2ndOne;

public class Main {
    public static void main(String[] args) {
        University university = new University(6);

        Student s1 = new Student("Soumyodip", 22, 1);
        Student s2 = new Student("Shuvam", 22, 2);
        Student s3 = new Student("Samriddhi", 22, 3);
        Student s4 = new Student("Supriyo", 22, 4);
        Professor p1 = new Professor("Rohit Sir", 24, "Java");
        Professor p2 = new Professor("Naveen Sir", 21, "Java");

        university.addPerson(s1);
        university.addPerson(s2);
        university.addPerson(s3);
        university.addPerson(s4);
        university.addPerson(p1);
        university.addPerson(p2);

        university.showPeople();
    }
}
