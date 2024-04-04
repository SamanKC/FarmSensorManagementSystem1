package newAssignment;

import javax.swing.JOptionPane;

/*
 * Author: Saman KC
 * Student ID: 3471694
 */

/**
 * The Interface class represents the user interface for the Farm Sensor
 * Management System.
 * It provides methods for displaying messages, getting user input, and running
 * the main program loop.
 */
public class Interface {
    private void messageDialog(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
    /**
     * Asks the user to enter a farm name or number and returns it as a String.
     * If the input is empty, it displays an error message and asks for input again.
     */
    private String askInputFromUser() {
        String farmNameOrNumber = JOptionPane.showInputDialog("Enter farm name or number:");
        if (farmNameOrNumber.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Farm name or number cannot be empty.");
            return askInputFromUser();
        }
        return farmNameOrNumber;
    }

    /**
     * Runs the Farm Sensor Management System.
     * This method displays a menu to the user and performs the corresponding
     * actions based on the user's choice.
     * The menu options include adding/removing farms, adding/removing sensors,
     * listing farms/sensors, querying sensor information, and exiting the program.
     */
    private void run() {
        int choice;
        Farm farm = new Farm();
        String askFarm;
        String message = "";
        double price;
        double weight;
        int quantity;
        do {
            String menu = "Welcome to the Farm Sensor Management System \n1. Add Farm\n2. Remove Farm\n3. Add Sensor\n4. Remove Sensor\n5. List Farms\n6. List Sensors at Farm\n7. Query Sensor at Farm\n8. Query Total Sensors Cost at Farm\n9. Exit";
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (choice) {
                case 1:
                    message = farm.addFarm(); // Add farm
                    messageDialog(message);
                    break;
                case 2:
                    String removeFarm = askInputFromUser();
                    message = farm.removeFarm(removeFarm); // Remove farm
                    messageDialog(message);
                    break;
                case 3:
                    askFarm = askInputFromUser();
                    Farm selectedFarm = farm.getFarmByNameOrNumber(askFarm);
                    if (selectedFarm == null) {
                        messageDialog("Error: farm" + askFarm + " does not exist.");
                        break;
                    }
                    String sensorName = askSensorType();
                    boolean sensorExists = farm.checkIfSensorExists(selectedFarm, sensorName);
                    if (sensorExists) {
                        boolean confirmSensorUpdate = confirmSensorUpdate(selectedFarm, sensorName);
                        if (confirmSensorUpdate) {
                            price = askPrice();
                            weight = askWeight();
                            quantity = askQuantity();
                            validateSensorDetails(price, weight, quantity);
                            selectedFarm.updateSensor(selectedFarm, sensorName, price, weight, quantity);
                            messageDialog("Sensor updated successfully.");
                        } else {
                            messageDialog("Sensor update cancelled.");
                            break;
                        }
                    } else {
                        price = askPrice();
                        weight = askWeight();
                        quantity = askQuantity();
                        validateSensorDetails(price, weight, quantity);
                        message = farm.addSensorToFarm(selectedFarm, sensorName, price, weight, quantity);
                        messageDialog(message);
                        break;
                    }
                case 4:
                    askFarm = askInputFromUser();
                    selectedFarm = farm.getFarmByNameOrNumber(askFarm);
                    String askSensorType = askSensorType();
                    String removeSensorMessage = farm.removeSensor(selectedFarm, askSensorType); // Remove sensor
                    messageDialog(removeSensorMessage);
                    break;
                case 5:
                    String listFarmMessage = farm.listFarms(); // List farms
                    messageDialog(listFarmMessage);
                    break;
                case 6:
                    askFarm = askInputFromUser();
                    selectedFarm = farm.getFarmByNameOrNumber(askFarm);
                    String listSensorsAtFarm = farm.listSensorsAtFarm(askFarm, selectedFarm); // List sensors at farm
                    messageDialog(listSensorsAtFarm);
                    break;
                case 7:
                    askFarm = askInputFromUser();
                    selectedFarm = farm.getFarmByNameOrNumber(askFarm);
                    askSensorType = askSensorType();
                    String querySensorMessage = farm.querySensorAtFarm(askFarm, selectedFarm, askSensorType);
                    messageDialog(querySensorMessage);
                    break;
                case 8:
                    askFarm = askInputFromUser();
                    selectedFarm = farm.getFarmByNameOrNumber(askFarm);
                    String queryTotalSensorsCost = farm.queryTotalSensorsCostAtFarm(askFarm, selectedFarm);
                    messageDialog(queryTotalSensorsCost);
                    break;
                case 9:
                    int userChoice = JOptionPane.showConfirmDialog(null, "Are you sure you want to exit?", "Exit",
                            JOptionPane.YES_NO_OPTION);
                    if (userChoice == JOptionPane.YES_OPTION) {
                        JOptionPane.showMessageDialog(null,
                                "Exiting the program. Thank you for using the Farm Sensor Management System.");
                        break;

                    } else {
                        run();
                    }

                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");

            }
        } while (choice != 9);
    }

    // Validate sensor details
    public void validateSensorDetails(double price, double weight, int quantity) {
        while (price <= 0 || weight <= 0 || quantity <= 0) {
            JOptionPane.showMessageDialog(null, "Price, weight and quantity should be greater than 0.");
            price = askPrice();
            weight = askWeight();
            quantity = askQuantity();
        }
    }

    // Confirm sensor update
    private boolean confirmSensorUpdate(Farm selectedFarm, String type) {
        int confirmation = JOptionPane.showConfirmDialog(null,
                type + " sensor already exists with price: $" + selectedFarm.getSensorPrice(selectedFarm, type)
                        + " and weight: " + selectedFarm.getSensorWeight(selectedFarm, type)
                        + "kg. Do you want to update the values?",
                "Sensor already exists", JOptionPane.YES_NO_OPTION);

        return confirmation == JOptionPane.YES_OPTION;
    }

    // Ask sensor type
    public String askSensorType() {
        String sensorName = "";
        int askType = Integer.parseInt(JOptionPane.showInputDialog(
                "Enter sensor type (1. Temperature / 2. Pressure / 3. Humidity / 4. Soil Temperature / 5. Soil Humidity / 6. Soil PH):"));

        switch (askType) {
            case 1:
                sensorName = "Temperature";
                break;
            case 2:
                sensorName = "Pressure";
                break;
            case 3:
                sensorName = "Humidity";
                break;
            case 4:
                sensorName = "Soil Temperature";
                break;
            case 5:
                sensorName = "Soil Humidity";
                break;
            case 6:
                sensorName = "Soil PH";
                break;
            default:
                JOptionPane.showMessageDialog(null, "Invalid sensor type. Please enter a valid option.");
                sensorName = askSensorType();
                break;
        }
        return sensorName;
    }

    private double askPrice() {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter price: "));
    }

    private double askWeight() {
        return Double.parseDouble(JOptionPane.showInputDialog("Enter weight: "));
    }

    private int askQuantity() {
        return Integer.parseInt(JOptionPane.showInputDialog("Enter quantity: "));
    }

    public static void main(String[] args) {
        Interface farmInterface = new Interface();
        farmInterface.run();
    }
}
