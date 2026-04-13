package entities;

import entities.type.VehicleType;

public class Bike extends Vehicle{
    public Bike(String id) {
        super(id, VehicleType.BIKE);
    }
}
