package entities;

import entities.type.VehicleType;

public class ParkingSlot {
    private final String slotId;
    private boolean isOccupied;
    private final VehicleType slotType;
    private Vehicle vehicle;
    private final int floorId;

    public ParkingSlot(int floorId,String slotId,VehicleType slotType){
        this.isOccupied=false;
        this.slotId=slotId;
        this.slotType=slotType;
        this.floorId=floorId;
    }

    public boolean assignVehicle(Vehicle vehicle){
        if (vehicle == null) return false;
        if(isAvailable() && vehicle.getVehicleType()==this.slotType){
            this.vehicle = vehicle;
            this.isOccupied=true;
            return true;
        }
        return false;
    }

    public void removeVehicle(){
        this.isOccupied=false;
        this.vehicle=null;
    }

    public boolean isAvailable(){
        return !isOccupied;
    }

    public String getSlotId() {
        return slotId;
    }

    public VehicleType getSlotType() {
        return slotType;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public int getFloorId() {
        return floorId;
    }
}
