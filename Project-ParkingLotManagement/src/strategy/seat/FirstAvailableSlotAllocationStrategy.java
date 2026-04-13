package strategy.seat;

import entities.ParkingSlot;
import entities.type.VehicleType;

import java.util.List;

public class FirstAvailableSlotAllocationStrategy implements SlotAllocationStrategy{

    @Override
    public ParkingSlot getSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType) {
        for(ParkingSlot parkingSlot : parkingSlots){
            if(parkingSlot.isAvailable() && parkingSlot.getSlotType()==vehicleType){
                return parkingSlot;
            }
        }
        return null;
    }

}
