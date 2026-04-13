package strategy.seat;

import entities.ParkingSlot;
import entities.type.VehicleType;

import java.util.List;

public interface SlotAllocationStrategy {
    ParkingSlot getSlot(List<ParkingSlot> parkingSlots, VehicleType vehicleType);
}
