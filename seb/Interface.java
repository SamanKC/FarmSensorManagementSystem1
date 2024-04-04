/*
 * Sebika Ban
 * 3466022
 */

import javax.swing.JOptionPane;

public class Interface {

    private void run() {
        int choice;
        Farm farm = new Farm();

        double price;
        double weight;
        int quantity;

        JOptionPane.showMessageDialog(null, "Welcome to the Farm Sensor Management System");
        do {
            String menu = "Select one: \n1. Add Farm\n2. Remove Farm\n3. Add Sensor\n4. Remove Sensor\n5. List Farms\n6. List Sensors at Farm\n7. Query Sensor at Farm\n8. Query Total Sensors Cost at Farm\n9. Exit";
            choice = Integer.parseInt(JOptionPane.showInputDialog(menu));

            switch (choice) {
                case 1:
                    JOptionPane.showMessageDialog(null, farm.addFarm());

                    break;
                case 2:
                    String removeFarmName = JOptionPane.showInputDialog("Enter farm name:");
                    JOptionPane.showMessageDialog(null, farm.removeFarm(removeFarmName));

                    break;
                case 3:
                    String addFarmName = JOptionPane.showInputDialog("Enter farm name:");

                    Farm selected = farm.getFarmByName(farm.removeFarm(addFarmName));
                    if (selected == null) {
                        JOptionPane.showMessageDialog(null, "The farm does not exist.");
                        break;
                    }

                    String sensor = "";
                    int chooseType = Integer.parseInt(JOptionPane.showInputDialog(
                            "Select one: \n1. Temperature\n2. Pressure\n3. Humidity\n4. Soil Temperature\n5. Soil Humidity\n6. Soil PH"));

                    switch (chooseType) {
                        case 1:
                            sensor = "Temperature";
                            break;
                        case 2:
                            sensor = "Pressure";
                            break;
                        case 3:
                            sensor = "Humidity";
                            break;
                        case 4:
                            sensor = "Soil Temperature";
                            break;
                        case 5:
                            sensor = "Soil Humidity";
                            break;
                        case 6:
                            sensor = "Soil PH";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
                            break;
                    }

                    price = Double.parseDouble(JOptionPane.showInputDialog("Enter price: "));

                    weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight: "));

                    quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity: "));
                    while (price <= 0 || weight <= 0 || quantity <= 0) {
                        JOptionPane.showMessageDialog(null, "Enter details again: Less than 0!.");
                        price = Double.parseDouble(JOptionPane.showInputDialog("Enter price: "));
                        ;
                        weight = Double.parseDouble(JOptionPane.showInputDialog("Enter weight: "));
                        ;
                        quantity = Integer.parseInt(JOptionPane.showInputDialog("Enter quantity: "));
                        ;
                    }
                    JOptionPane.showMessageDialog(null,
                            farm.addSensorToFarm(selected, sensor, price, weight, quantity));

                    break;

                case 4:
                    String removeSFarmName = JOptionPane.showInputDialog("Enter farm name:");
                    Farm select = farm.getFarmByName(farm.removeFarm(removeSFarmName));
                    sensor = "";
                    chooseType = Integer.parseInt(JOptionPane.showInputDialog(
                            "Select one: \n1. Temperature\n2. Pressure\n3. Humidity\n4. Soil Temperature\n5. Soil Humidity\n6. Soil PH"));

                    switch (chooseType) {
                        case 1:
                            sensor = "Temperature";
                            break;
                        case 2:
                            sensor = "Pressure";
                            break;
                        case 3:
                            sensor = "Humidity";
                            break;
                        case 4:
                            sensor = "Soil Temperature";
                            break;
                        case 5:
                            sensor = "Soil Humidity";
                            break;
                        case 6:
                            sensor = "Soil PH";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
                            break;
                    }
                    JOptionPane.showMessageDialog(null, farm.removeSensor(select, removeSFarmName, sensor));

                    break;
                case 5:
                    JOptionPane.showMessageDialog(null, farm.listFarms());

                    break;
                case 6:
                    String listSensors = JOptionPane.showInputDialog("Enter farm name:");

                    Farm sel = farm.getFarmByName(listSensors);
                    JOptionPane.showMessageDialog(null, farm.listSensorsAtFarm(listSensors, sel));
                    break;
                case 7:
                    String querySensors = JOptionPane.showInputDialog("Enter farm name:");

                    Farm se = farm.getFarmByName(querySensors);

                    sensor = "";
                    chooseType = Integer.parseInt(JOptionPane.showInputDialog(
                            "Select one: \n1. Temperature\n2. Pressure\n3. Humidity\n4. Soil Temperature\n5. Soil Humidity\n6. Soil PH"));

                    switch (chooseType) {
                        case 1:
                            sensor = "Temperature";
                            break;
                        case 2:
                            sensor = "Pressure";
                            break;
                        case 3:
                            sensor = "Humidity";
                            break;
                        case 4:
                            sensor = "Soil Temperature";
                            break;
                        case 5:
                            sensor = "Soil Humidity";
                            break;
                        case 6:
                            sensor = "Soil PH";
                            break;
                        default:
                            JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
                            break;
                    }

                    JOptionPane.showMessageDialog(null, farm.querySensorAtFarm(querySensors, se, sensor));
                    break;
                case 8:
                    String querySensorsCost = JOptionPane.showInputDialog("Enter farm name:");

                    Farm fs = farm.getFarmByName(querySensorsCost);

                    JOptionPane.showMessageDialog(null, farm.queryTotalSensorsCostAtFarm(querySensorsCost, fs));
                    break;
                case 9:
                    JOptionPane.showMessageDialog(null, "Bye!");
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Invalid choice. Please enter a valid option.");
            }
        } while (choice != 9);

    }

    public static void main(String[] args) {
        Interface fI = new Interface();
        fI.run();
    }
}
