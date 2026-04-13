package entities;

import entities.type.VehicleType;

public abstract class Vehicle {

    private final String vehicleId;
    private final VehicleType vehicleType;

    public Vehicle(String id, VehicleType type){
        this.vehicleType = type;
        this.vehicleId = id;
    }

    public String getVehicleId(){
        return this.vehicleId;
    }
    public VehicleType getVehicleType(){
        return this.vehicleType;
    }

}
