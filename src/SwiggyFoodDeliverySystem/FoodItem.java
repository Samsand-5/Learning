package SwiggyFoodDeliverySystem;

import java.util.Objects;

public class FoodItem {
    private String name;
    private double price;
    private int quantity;

    public FoodItem(String name,double price,int quantity) {
        this.name = name;
        this.price = price;
        this.quantity=quantity;
    }

    public String getName() {
        return name;
    }
    public double getPrice() {
        return price;
    }

    public int getQuantity(){
        return quantity;
    }

    void reduceQuantity(int amount) throws InvalidOrderException{
        if (amount>quantity) {
            throw new InvalidOrderException("stock not available.");
        }
        quantity-=amount;
    }

    public void addQuantity(int amount) {
        quantity+=amount;
    }

    @Override
    public String toString() {
        return "FoodItem{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        FoodItem foodItem = (FoodItem) o;
        return Double.compare(price, foodItem.price) == 0 && Objects.equals(name, foodItem.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, price);
    }
}
