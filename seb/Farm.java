/*
 * Sebika Ban
 * 3466022
 */
public class Farm {

  private String farmName;
  private Sensor sensor1, sensor2, sensor3;
  private Farm farm1, farm2;

  public Farm() {
    farmName = "";
  }

  public Farm(String farmName1) {
    farmName = farmName1;
  }

  public String getFarmName() {
    return farmName;
  }

  public void setFarmName(String farmName1) {
    farmName = farmName1;
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

  public void setSensor1(Sensor sensor11) {
    sensor1 = sensor11;
  }

  public void setSensor2(Sensor sensor21) {
    sensor2 = sensor21;
  }

  public void setSensor3(Sensor sensor31) {
    sensor3 = sensor31;
  }

  public String addFarm() {
    if (farm1 == null) {
      farm1 = new Farm();
      farm1.setFarmName("farm1Ban");
      return farm1.getFarmName() + " added.";

    } else if (farm2 == null) {
      farm2 = new Farm();
      farm2.setFarmName("farm2Ban");
      return farm2.getFarmName() + " added.";

    } else {
      return "Invalid";
    }
  }

  public String removeFarm(String farm) {
    if (farm == "") {
      return "Do not leave empty.";
    } else if (farm1 == null && farm2 == null) {
      return "No farm exist.";
    } else if (farm1 == null) {
      return "The farm does not exist.";
    } else if (farm2 == null) {
      return "The farm does not exist";
    } else if (farm1.getFarmName().equals(farm) && farm1 != null) {
      farm1 = null;
      return farm1.getFarmName() + " removed.";
    } else if (farm2.getFarmName().equals(farm) && farm2 != null) {
      farm2 = null;
      return farm2.getFarmName() + " removed.";
    } else {
      return "The farm does not exist.";
    }

  }

  public Farm getFarmByName(String farmName) {
    if (farm1 != null && farm1.getFarmName().equals(farmName)) {
      return farm1;
    } else if (farm2 != null && farm2.getFarmName().equals(farmName)) {
      return farm2;
    } else
      return null;
  }

  public Sensor createSensor(String type, double price, double weight, int quantity) {
    Sensor s = new Sensor();
    s.setPrice(price);
    s.setWeight(weight);
    s.setType(type);
    s.setQuantity(quantity);
    return s;

  }

  public String addSensorToFarm(Farm farm, String type, double price, double weight, int quantity) {
    Sensor newSensor = farm.createSensor(type, price, weight, quantity);
    if (farm.getSensor1() == null) {
      farm.setSensor1(newSensor);
    } else if (farm.getSensor2() == null) {
      farm.setSensor2(newSensor);
    } else if (farm.getSensor3() == null) {
      farm.setSensor3(newSensor);
    } else {
      return "Only three sensors can be added to a farm.";
    }

    return "One " + type + " sensor added to " + farm.getFarmName();
  }

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

  public String removeSensor(Farm selectedFarm, String type, String sensorType) {

    if (selectedFarm == null) {
      return "The farm does not exist.";
    } else {
      Sensor remSensor = null;
      boolean s;
      if (selectedFarm.getSensor1() != null && selectedFarm.getSensor1().getType().equalsIgnoreCase(sensorType)) {
        remSensor = selectedFarm.getSensor1();
      } else if (selectedFarm.getSensor2() != null && selectedFarm.getSensor2().getType().equalsIgnoreCase(
          sensorType)) {
        remSensor = selectedFarm.getSensor2();
      } else if (selectedFarm.getSensor3() != null && selectedFarm.getSensor3().getType().equalsIgnoreCase(
          sensorType)) {
        remSensor = selectedFarm.getSensor3();
      }
      if (remSensor != null) {
        s = true;
      } else {
        s = false;
      }
      if (s) {
        return "One " + sensorType + " sensor removed from " + selectedFarm.getFarmName();
      } else {
        return "The sensor does not exist at " + selectedFarm.getFarmName();
      }
    }
  }

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

  public String listSensorsAtFarm(String farmName, Farm farm) {
    if (farm == null) {
      return "Error: The farm '" + farmName + "' does not exist.";
    }

    String sensor = "";
    if (farm.getSensor1() != null) {
      sensor += farm.sensor1.getType() + " sensor has price $" + farm.sensor1.getPrice() +
          ", weight " + farm.sensor1.getWeight() + "kg, and quantity " + farm.sensor1.getQuantity() + "\n";
    }
    if (farm.getSensor2() != null) {
      sensor += farm.sensor2.getType() + " sensor has price $" + farm.sensor2.getPrice() +
          ", weight " + farm.sensor2.getWeight() + "kg, and quantity " + farm.sensor2.getQuantity() + "\n";
    }
    if (farm.getSensor3() != null) {
      sensor += farm.sensor3.getType() + " sensor has price $" + farm.sensor3.getPrice() +
          ", weight " + farm.sensor3.getWeight() + "kg, and quantity " + farm.sensor3.getQuantity() + "\n";
    }

    return sensor;
  }

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

  public String querySensorAtFarm(String farmName, Farm farm, String sensorType) {

    if (farm == null) {
      return "Farm '" + farmName + "' does not exist.";
    }

    String s = "";

    if (farm.getSensor1() != null && farm.getSensor1().getType().equalsIgnoreCase(sensorType)
        || farm.getSensor2() != null && farm.getSensor2().getType().equalsIgnoreCase(sensorType)
        || farm.getSensor3() != null && farm.getSensor3().getType().equalsIgnoreCase(sensorType)) {
      s = sensorType + " sensor is at " + farm.getFarmName() + " with quantity "
          + getSensorQuantity(farm, sensorType);
    } else {

      return "Sensor '" + sensorType + "' does not exist at farm '" + farmName + "'.";
    }
    return s;
  }

  public String queryTotalSensorsCostAtFarm(String farmName, Farm farm) {

    if (farm == null) {
      return "The farm does not exist.";
    }

    int totalQuantity = getTotalSensorsQuantity(farm);
    double totalCost = getTotalSensorsCost(farm);

    return farm.getFarmName() + " has " + totalQuantity + " sensors of value $" + totalCost;
  }

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
