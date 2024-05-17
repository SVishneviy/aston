package org.example;

public class Engine {

    private int housePower;

    private Double volume;

    private boolean hasTurbocharger;

    public Engine() {
    }

    public Engine(int housePower, Double volume, boolean hasTurbocharger) {
        this.housePower = housePower;
        this.volume = volume;
        this.hasTurbocharger = hasTurbocharger;
    }

    public int getHousePower() {
        return housePower;
    }

    public Engine setHousePower(int housePower) {
        this.housePower = housePower;
        return this;
    }

    public Double getVolume() {
        return volume;
    }

    public Engine setVolume(Double volume) {
        this.volume = volume;
        return this;
    }

    public boolean isHasTurbocharger() {
        return hasTurbocharger;
    }

    public Engine setHasTurbocharger(boolean hasTurbocharger) {
        this.hasTurbocharger = hasTurbocharger;
        return this;
    }

    @Override
    public String toString() {
        return "Engine{" +
                "housePower=" + housePower +
                ", volume=" + volume +
                ", hasTurbocharger=" + hasTurbocharger +
                '}';
    }

}
