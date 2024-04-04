/*
 * Sebika Ban
 * 3466022
 */

public class Sensor {
    private String type;
    private double price;
    private double weight;
    private int quantity;

    public Sensor() {
        this.type = "";
        this.price = 0;
        this.weight = 0;
        this.quantity = 0;
    }

    public Sensor(String type, double price, double weight, int quantity) {
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public double getWeight() {
        return weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setType(String type) {
        this.type = type;
    }

}
