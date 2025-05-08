package SwiggyFoodDeliverySystem;

public abstract class User {
    protected String id;
    protected String name;

    User(String id,String name){
        this.id=id;
        this.name=name;
    }

    public abstract void showProfile();

}
