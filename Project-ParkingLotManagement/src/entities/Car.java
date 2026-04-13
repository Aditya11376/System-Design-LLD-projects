package entities;

import entities.type.VehicleType;

public class Car extends Vehicle{
    public Car(String id) {
        super(id, VehicleType.CAR);
    }
}
