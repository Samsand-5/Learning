package SwiggyFoodDeliverySystem;

@RoleCheck(role = "Manager")
public class Manager extends User{
    Manager(String id, String name) {
        super(id, name);
    }

    @Override
    public void showProfile() {
        System.out.println("Manager " + name);
    }
}
