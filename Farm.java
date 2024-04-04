package newAssignment;
/*
 * Author: Saman KC
 * Student ID: 3471694
 */
/**
 * The Farm class represents a farm in the system.
 * Farms can be added, removed, and sensors can be added or removed from a farm.
 */
public class Farm {
    private int farmNumber;
    private String farmName;
    private Sensor sensor1, sensor2, sensor3;
    private Farm farm1, farm2;
    String customMessage;

    public Farm() {
        this.farmNumber = 0;
        this.farmName = "";
    }

    public Farm(int farmNumber, String farmName) {
        this.farmNumber = farmNumber;
        this.farmName = farmName;
    }

    public int getFarmNumber() {
        return farmNumber;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmNumber(int farmNumber) {
        this.farmNumber = farmNumber;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Sensor getSensor1() {
        return sensor1;
    }

    public Sensor getSensor2() {
        return sensor2;
    }

    public Sensor getSensor3() {
        return sensor3;
    }

    public void setSensor1(Sensor sensor1) {
        this.sensor1 = sensor1;
    }

    public void setSensor2(Sensor sensor2) {
        this.sensor2 = sensor2;
    }

    public void setSensor3(Sensor sensor3) {
        this.sensor3 = sensor3;
    }

    /**
     */
    public String addFarm() {
        String userLastName = "KC";
        if (farm1 == null) {
            farm1 = new Farm();
            farm1.setFarmNumber(1);
            farm1.setFarmName("farm1" + userLastName);
            customMessage = farm1.getFarmName() + " added successfully.";

        } else if (farm2 == null) {
            farm2 = new Farm();
            farm2.setFarmNumber(2);
            farm2.setFarmName("farm2" + userLastName);
            customMessage = farm2.getFarmName() + " added successfully.";

        } else {
            customMessage = "Error: Only 2 farms are allowed.";

        }
        return customMessage;
    }

    /**
     * Removes a farm based on the given farm number or name.
     */
    public String removeFarm(String farm) {
        if (farm == "") {
            customMessage = "Error: Invalid farm number/name. Please enter a valid option.";
        } else if (farm1 == null && farm2 == null) {
            customMessage = "Error: No farm exist.";
        } else if (farm1 == null) {
            customMessage = "Error: farm" + farm + " does not exist.";
        } else if (farm2 == null) {
            customMessage = "Error: farm" + farm + " does not exist.";
        } else if ((farm.equals("1") || farm1.getFarmName().equals(farm)) && farm1 != null) {
            customMessage = farm1.getFarmName() + " removed successfully.";
            farm1 = null;
        } else if ((farm.equals("2") || farm2.getFarmName().equals(farm)) && farm2 != null) {
            customMessage = farm2.getFarmName() + " removed successfully.";
            farm2 = null;
        } else {
            customMessage = "Error: farm" + farm + " does not exist.";
        }
        return customMessage;
    }

    public Farm getFarmByNameOrNumber(String farmName) {
        if (farm1 != null && (farm1.getFarmNumber() == 1 || farm1.getFarmName().equals(farmName))) {
            return farm1;
        } else if (farm2 != null && (farm2.getFarmNumber() == 2 || farm2.getFarmName().equals(farmName))) {
            return farm2;
        } else
            return null;
    }

    /**
     * Checks if the farm is full by checking if all three sensors are present.
     */
    private boolean checkIfFarmFull(Farm farm) {
        boolean sensor1Exists = farm.getSensor1() != null;
        boolean sensor2Exists = farm.getSensor2() != null;
        boolean sensor3Exists = farm.getSensor3() != null;
        return sensor1Exists && sensor2Exists && sensor3Exists;
    }

    public Sensor createSensor(String type, double price, double weight, int quantity) {
        Sensor sensor = new Sensor();
        sensor.setPrice(price);
        sensor.setWeight(weight);
        sensor.setType(type);
        sensor.setQuantity(quantity);
        return sensor;

    }

    /**
     * Adds a sensor to the specified farm.
     * farm: The farm to add the sensor to.
     * type: The type of the sensor.
     * price: The price of the sensor.
     * weight: The weight of the sensor.
     * quantity: The quantity of the sensor.
     */
    public String addSensorToFarm(Farm farm, String type, double price, double weight, int quantity) {
        Sensor newSensor = farm.createSensor(type, price, weight, quantity);
        if (farm.getSensor1() == null) {
            farm.setSensor1(newSensor);
        } else if (farm.getSensor2() == null) {
            farm.setSensor2(newSensor);
        } else if (farm.getSensor3() == null) {
            farm.setSensor3(newSensor);
        } else {
            return "Error: Only 3 sensors are allowed at " + farm.getFarmName();
        }

        return "One " + type + " sensor added to " + farm.getFarmName();
    }

    /**
     * Updates the sensor information for a farm.
     */
    public String updateSensor(Farm farm, String type, double price, double weight, int quantity) {
        boolean farmFull = checkIfFarmFull(farm);
        if (farmFull) {
            return "Error: " + farm.getFarmName() + " already holds sensors of three different types.";
        } else
            return addSensorToFarm(farm, type, price, weight, quantity);
    }

    /**
     * Checks if a sensor of the specified type exists in the given farm.
     */
    public boolean checkIfSensorExists(Farm farm, String type) {
        return farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(type)
                || farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(type)
                || farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(type);
    }

    /**
     * Calculates the price of a sensor of the specified type in the given farm.
     */
    public double getSensorPrice(Farm farm, String type) {
        if (farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(type)) {
            return farm.getSensor1().getPrice();
        } else if (farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(type)) {
            return farm.getSensor2().getPrice();
        } else if (farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(type)) {
            return farm.getSensor3().getPrice();
        }
        return 0;
    }

    /**
     * Returns the weight of a sensor of the specified type in the given farm.
     * 
     * farm the farm object to retrieve the sensor weight from
     * type the type of sensor to retrieve the weight for
     * return the weight of the sensor, or 0 if no sensor of the specified type is
     * found
     */
    public double getSensorWeight(Farm farm, String type) {
        if (farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(type)) {
            return farm.getSensor1().getWeight();
        } else if (farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(type)) {
            return farm.getSensor2().getWeight();
        } else if (farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(type)) {
            return farm.getSensor3().getWeight();
        }
        return 0;
    }

    /**
     * Removes a sensor of the specified type from the selected farm.
     *
     * selectedFarm The farm from which the sensor should be removed.
     * type The type of sensor to be removed.
     * 
     * return A message indicating the result of the removal operation.
     * 
     */
    public String removeSensor(Farm selectedFarm, String askSensorType) {
        if (selectedFarm == null) {
            return "Error: " + farmName + " does not exist.";
        } else {
            if (removeSensorFromFarm(selectedFarm, askSensorType)) {
                return "One " + askSensorType + " sensor removed from " + selectedFarm.getFarmName();
            } else {
                return "Error: Sensor '" + askSensorType + "' does not exist in farm '" + selectedFarm.getFarmName()
                        + "'.";
            }
        }
    }

    /**
     * Removes a sensor of the specified type from the farm.
     */
    public boolean removeSensorFromFarm(Farm farm, String sensorType) {
        Sensor sensorToRemove = null;
        if (farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(sensorType)) {
            sensorToRemove = farm.getSensor1();
        } else if (farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(sensorType)) {
            sensorToRemove = farm.getSensor2();
        } else if (farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(sensorType)) {
            sensorToRemove = farm.getSensor3();
        }
        if (sensorToRemove == null) {
            return false;
        } else {
            shiftSensors(farm, sensorToRemove);
            return true;
        }
    }

    /**
     * Shifts the sensors in the farm by removing the specified sensor.
     * If the specified sensor is found in the farm, it is removed and the remaining
     * sensors are shifted accordingly.
     */
    private void shiftSensors(Farm farm, Sensor sensorToRemove) {
        if (farm.getSensor1() == sensorToRemove) {
            if (farm.getSensor2() != null) {
                farm.setSensor1(farm.getSensor2());
                farm.setSensor2(farm.getSensor3());
                farm.setSensor3(null);
            } else if (farm.getSensor3() != null) {
                farm.setSensor1(farm.getSensor3());
                farm.setSensor3(null);
            } else {
                farm.setSensor1(null);
            }
        } else if (farm.getSensor2() == sensorToRemove) {
            if (farm.getSensor3() != null) {
                farm.setSensor2(farm.getSensor3());
                farm.setSensor3(null);
            } else {
                farm.setSensor2(null);
            }
        } else if (farm.getSensor3() == sensorToRemove) {
            farm.setSensor3(null);
        }
    }

    /**
     * Calculates the total quantity of sensors in the given farm.
     */
    public int getTotalSensorsQuantity(Farm farm) {
        int totalQuantity = 0;
        if (farm.getSensor1() != null) {
            totalQuantity += farm.getSensor1().getQuantity();
        }
        if (farm.getSensor2() != null) {
            totalQuantity += farm.getSensor2().getQuantity();
        }
        if (farm.getSensor3() != null) {
            totalQuantity += farm.getSensor3().getQuantity();
        }
        return totalQuantity;
    }

    /**
     * Returns a string containing information about the sensors at a farm.
     */
    public String listSensorsAtFarm(String farmName, Farm farm) {

        if (farm == null) {
            return "Error: The farm '" + farmName + "' does not exist.";
        }

        String sensorInfo = "";
        if (farm.getSensor1() != null) {
            sensorInfo += formatSensorInfo(farm.getSensor1()) + "\n";
        }
        if (farm.getSensor2() != null) {
            sensorInfo += formatSensorInfo(farm.getSensor2()) + "\n";
        }
        if (farm.getSensor3() != null) {
            sensorInfo += formatSensorInfo(farm.getSensor3()) + "\n";
        }

        return sensorInfo;
    }

    public String formatSensorInfo(Sensor sensor) {
        return sensor.getType() + " sensor has price $" + sensor.getPrice() +
                ", weight " + sensor.getWeight() + "kg, and quantity " + sensor.getQuantity();
    }

    /**
     * Returns a string representation of the farms and their sensor quantities.
     * If no farms exist, it returns "No farm exist".
     * Otherwise, it returns a string containing the farm names and their respective
     * sensor quantities.
     */
    public String listFarms() {
        if (farm1 == null && farm2 == null) {
            return "No farm exist";
        } else {
            String output = "";
            if (farm1 != null) {
                output += farm1.getFarmName() + " has " + getTotalSensorsQuantity(farm1) + " sensors\n";
            }
            if (farm2 != null) {
                output += farm2.getFarmName() + " has " + getTotalSensorsQuantity(farm2) + " sensors\n";
            }
            return output;
        }
    }

    /**
     * Returns the quantity of a specific sensor type in the given farm.
     */
    private int getSensorQuantity(Farm farm, String sensorType) {
        if (farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(sensorType)) {
            return farm.getSensor1().getQuantity();
        } else if (farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(sensorType)) {
            return farm.getSensor2().getQuantity();
        } else if (farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(sensorType)) {
            return farm.getSensor3().getQuantity();
        }
        return 0;
    }

    /**
     * Queries the sensor at a specific farm and returns information about it.
     */
    public String querySensorAtFarm(String farmName, Farm farm, String sensorType) {

        if (farm == null) {
            return "Error: The farm '" + farmName + "' does not exist.";
        }

        String output = "";

        if (farmHasSensor(farm, sensorType)) {
            output = sensorType + " sensor is at " + farm.getFarmName() + " with quantity "
                    + getSensorQuantity(farm, sensorType);
        } else {

            return "Error: Sensor '" + sensorType + "' does not exist at farm '" + farmName + "'.";
        }
        return output;
    }

    /**
     * Checks if the specified farm has a sensor of the given sensor type.
     */
    private boolean farmHasSensor(Farm farm, String sensorType) {
        return farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(sensorType)
                || farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(sensorType)
                || farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(sensorType);
    }

    /**
     * Returns a string representation of the total sensors cost at a farm.
     */
    public String queryTotalSensorsCostAtFarm(String farmName, Farm farm) {

        if (farm == null) {
            return "Error: farm" + farmName + " does not exist.";
        }

        int totalQuantity = getTotalSensorsQuantity(farm);
        double totalCost = getTotalSensorsCost(farm);

        return farm.getFarmName() + " has " + totalQuantity + " sensors of value $" + totalCost;
    }

    /**
     * Calculates the total cost of all sensors in the farm.
     */
    private double getTotalSensorsCost(Farm farm) {
        double totalCost = 0;
        if (farm.getSensor1() != null) {
            totalCost += farm.getSensor1().getPrice() * farm.getSensor1().getQuantity();
        }
        if (farm.getSensor2() != null) {
            totalCost += farm.getSensor2().getPrice() * farm.getSensor2().getQuantity();
        }
        if (farm.getSensor3() != null) {
            totalCost += farm.getSensor3().getPrice() * farm.getSensor3().getQuantity();
        }
        return totalCost;
    }

}
