package org.example.patterns.adapter.convertmiles;

public class Miles implements Distance {
    private double distance;

    public Miles(double distance) {
        this.distance = distance;
    }

    @Override
    public double getValue() {
        return this.distance;
    }
}