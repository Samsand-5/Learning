package Task27thMarch2ndOne;

public class Professor extends Person {
    private String specialization;

    public Professor(String name, int age, String specialization) {
        super(name, age);
        this.specialization = specialization;
    }

    public void displayProfessorInfo() {
        super.displayInfo();
        System.out.println("Specialization: " + specialization);
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }
}
