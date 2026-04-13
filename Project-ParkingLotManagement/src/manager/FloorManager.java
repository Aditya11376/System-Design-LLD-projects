package manager;

import entities.Floor;
import entities.ParkingSlot;
import entities.Vehicle;
import entities.type.VehicleType;

public class FloorManager {
    private final Floor floor;

    public FloorManager(Floor floor) {
        this.floor = floor;
    }

    public int getAvailableSlots(VehicleType type){
        return floor.getAvailableSlots(type);
    }

    public void freeSlot(ParkingSlot slot){
        if (slot != null && !slot.isAvailable()) {
            floor.freeSlot(slot);
        }
    }

    public ParkingSlot allocateSlot(Vehicle vehicle){
        if(vehicle==null) return null;
        return floor.allocateSlot(vehicle);
    }

    public int getFloorId(){
        return floor.getFloorId();
    }
}
