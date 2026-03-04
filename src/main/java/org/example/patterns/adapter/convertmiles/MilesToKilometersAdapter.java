package org.example.patterns.adapter.convertmiles;

public class MilesToKilometersAdapter {
    private Miles miles;
    private static final double MILES_TO_KM = 1.60934;

    public MilesToKilometersAdapter(Miles miles) {
        this.miles = miles;
    }

    public double convertMilesToKilometers() {
        return miles.getValue() * MILES_TO_KM;
    }
}