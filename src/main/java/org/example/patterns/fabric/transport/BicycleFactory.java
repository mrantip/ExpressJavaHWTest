package org.example.patterns.fabric.transport;

public class BicycleFactory extends TransportFactory {
    @Override
    public Transport createTransport() {
        return new Bicycle();
    }
}