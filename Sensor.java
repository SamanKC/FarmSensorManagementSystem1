
package newAssignment;
/*
 * Author: Saman KC
 * Student ID: 3471694
 */
/**
 * The Sensor class represents a sensor object.
 * It contains information about the type, price, weight, and quantity of the
 * sensor.
 */
public class Sensor {
    private String type;
    private double price;
    private double weight;
    private int quantity;

    /**
     * Constructs a new Sensor object with default values.
     */
    public Sensor() {
        this.type = "";
        this.price = 0;
        this.weight = 0;
        this.quantity = 0;
    }

    /**
     * Constructs a new Sensor object with the specified values.
     * type the type of the sensor
     * price the price of the sensor
     * weight the weight of the sensor
     * quantity the quantity of the sensor
     */
    public Sensor(String type, double price, double weight, int quantity) {
        this.type = type;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }

    /**
     * Returns the type of the sensor.
     * return the type of the sensor
     */
    public String getType() {
        return type;
    }

    /**
     * Returns the price of the sensor.
     * return the price of the sensor
     */
    public double getPrice() {
        return price;
    }

    /**
     * Returns the weight of the sensor.
     * return the weight of the sensor
     */
    public double getWeight() {
        return weight;
    }

    /**
     * Returns the quantity of the sensor.
     * return the quantity of the sensor
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Sets the quantity of the sensor.
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * Sets the weight of the sensor.
     */
    public void setWeight(double weight) {
        this.weight = weight;
    }

    /**
     * Sets the price of the sensor.
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * Sets the type of the sensor.
     */
    public void setType(String type) {
        this.type = type;
    }

}
