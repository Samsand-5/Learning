package ContactManagementSystem;

public class Contact {

    private String id;
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String id, String name, String phoneNumber, String email) {
        this.id = id;
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String setName(String name) {
        boolean isTrue=name.matches("^[a-zA-Z][a-zA-Z0-9]");
        if(isTrue) {
            this.name=name;
            return "Y";
        }
        else {
            System.out.println("Invalid Name");
            return "N";
        }

    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String setPhoneNumber(String phoneNumber) {
        boolean isTrue=phoneNumber.matches("[789]\\d{9}");
        if(isTrue) {
            this.phoneNumber=phoneNumber;
            return "Y";
        }
        else {
            System.out.println("Invalid phonenumber");
            return "N";
        }
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.id+" "+this.name+" "+this.phoneNumber+" "+this.email;
    }
}
