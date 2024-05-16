package org.example;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;

public class Main {

    public static void main(String[] args) throws IllegalAccessException, IOException,
            InvocationTargetException, NoSuchMethodException, InstantiationException {
        Engine engine = new Engine().setVolume(3.5)
                .setHousePower(250)
                .setHasTurbocharger(true);

        Car car = new Car().setName("Audi")
                .setColor("black")
                .setNumberOfDoors(5)
                .setNumberOfGears(7)
                .setWeight(1700.0)
                .setFuelConsumption(6.5)
                .setHasTinting(false)
                .setHasAlarmSystem(true)
                .setEngine(engine);

        YamlMapper.serializeToFile(new File("output/car.yml"), car);

        Car car1 = YamlMapper.deserializeFromFile("output/car.yml", Car.class);
        System.out.println(car1);
    }

}