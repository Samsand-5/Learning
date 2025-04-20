package Task27thMarch2ndOne;

public class University {
    private Person[] people;
    private int count = 0;

    public University(int size) {
        people = new Person[size];
    }

    public void addPerson(Person p) {
        if (count < people.length) {
            people[count++] = p;
        } else {
            System.out.println("University is full!");
        }
    }

    public void showPeople() {
        for (Person p : people) {
            if (p instanceof Student) {
                ((Student) p).displayStudentInfo();
            } else if (p instanceof Professor) {
                ((Professor) p).displayProfessorInfo();
            } else {
                p.displayInfo();
            }
            System.out.println();
        }
    }
}
