package org.example.patterns.adapter.convertmiles;

public class Kilometers implements Distance {
    private double distance;

    public Kilometers(double distance) {
        this.distance = distance;
    }

    @Override
    public double getValue() {
        return this.distance;
    }
}