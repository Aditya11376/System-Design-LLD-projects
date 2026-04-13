package entities;

import entities.type.VehicleType;
import strategy.seat.SlotAllocationStrategy;

import java.util.List;

public class Floor {

    private final int floorId;
    private final List<ParkingSlot> slots;
    private final SlotAllocationStrategy slotAllocationStrategy;

    public Floor(int floorId, List<ParkingSlot> slots, SlotAllocationStrategy strategy) {
        this.floorId = floorId;
        this.slots = slots;
        this.slotAllocationStrategy = strategy;
    }

    public int getFloorId() {
        return floorId;
    }

    public List<ParkingSlot> getSlots() {
        return slots;
    }

    public int getAvailableSlots(VehicleType type){
        int count = 0;
        for(ParkingSlot slot : slots){
            if(type == slot.getSlotType() && slot.isAvailable()) count++;
        }
        return count;
    }

    public void freeSlot(ParkingSlot slot){
        if(slot!=null){
            slot.removeVehicle();
        }
    }

    public ParkingSlot allocateSlot(Vehicle vehicle){
        if(vehicle==null) return null;
        ParkingSlot parkingSlot = slotAllocationStrategy.getSlot(slots,vehicle.getVehicleType());
        if(parkingSlot!=null && parkingSlot.assignVehicle(vehicle)){
            return parkingSlot;
        }
        return null;
    }

}
