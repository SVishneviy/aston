package org.example;

public class Car {

    private String name;

    private String color;

    private int numberOfDoors;

    private Integer numberOfGears;

    private double weight;

    private Double fuelConsumption;

    private boolean hasTinting;

    private Boolean hasAlarmSystem;

    private Engine engine;

    public Car() {
    }

    public Car(String name, String color, int numberOfDoors, Integer numberOfGears, double weight,
               Double fuelConsumption, boolean hasTinting, Boolean hasAlarmSystem, Engine engine) {
        this.name = name;
        this.color = color;
        this.numberOfDoors = numberOfDoors;
        this.numberOfGears = numberOfGears;
        this.weight = weight;
        this.fuelConsumption = fuelConsumption;
        this.hasTinting = hasTinting;
        this.hasAlarmSystem = hasAlarmSystem;
        this.engine = engine;
    }

    public String getName() {
        return name;
    }

    public Car setName(String name) {
        this.name = name;
        return this;
    }

    public String getColor() {
        return color;
    }

    public Car setColor(String color) {
        this.color = color;
        return this;
    }

    public int getNumberOfDoors() {
        return numberOfDoors;
    }

    public Car setNumberOfDoors(int numberOfDoors) {
        this.numberOfDoors = numberOfDoors;
        return this;
    }

    public Integer getNumberOfGears() {
        return numberOfGears;
    }

    public Car setNumberOfGears(Integer numberOfGears) {
        this.numberOfGears = numberOfGears;
        return this;
    }

    public double getWeight() {
        return weight;
    }

    public Car setWeight(double weight) {
        this.weight = weight;
        return this;
    }

    public Double getFuelConsumption() {
        return fuelConsumption;
    }

    public Car setFuelConsumption(Double fuelConsumption) {
        this.fuelConsumption = fuelConsumption;
        return this;
    }

    public boolean isHasTinting() {
        return hasTinting;
    }

    public Car setHasTinting(boolean hasTinting) {
        this.hasTinting = hasTinting;
        return this;
    }

    public Boolean getHasAlarmSystem() {
        return hasAlarmSystem;
    }

    public Car setHasAlarmSystem(Boolean hasAlarmSystem) {
        this.hasAlarmSystem = hasAlarmSystem;
        return this;
    }

    public Engine getEngine() {
        return engine;
    }

    public Car setEngine(Engine engine) {
        this.engine = engine;
        return this;
    }

    @Override
    public String toString() {
        return "Car{" +
                "name='" + name + '\'' +
                ", color='" + color + '\'' +
                ", numberOfDoors=" + numberOfDoors +
                ", numberOfGears=" + numberOfGears +
                ", weight=" + weight +
                ", fuelConsumption=" + fuelConsumption +
                ", hasTinting=" + hasTinting +
                ", hasAlarmSystem=" + hasAlarmSystem +
                ", engine=" + engine +
                '}';
    }

}
