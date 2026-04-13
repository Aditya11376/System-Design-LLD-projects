import controller.EntryGate;
import controller.ExitGate;
import entities.*;
import entities.type.VehicleType;
import manager.ParkingLotManager;
import manager.TicketManager;
import strategy.pricing.HourlyPricingStrategy;
import strategy.pricing.PricingStrategy;
import strategy.seat.FirstAvailableSlotAllocationStrategy;
import strategy.seat.SlotAllocationStrategy;

import java.util.ArrayList;
import java.util.List;

public class MallParkingLotManagementSystem {

    public static void main(String[] args) {
        PricingStrategy pricingStrategy = new HourlyPricingStrategy();
        SlotAllocationStrategy slotStrategy = new FirstAvailableSlotAllocationStrategy();
        Vehicle car1 = new Car("CAR123");
        Vehicle bike1 = new Bike("BIKE123");
        List<Floor> floors = new ArrayList<>();

        for (int i = 1; i <= 2; i++) {
            List<ParkingSlot> slots = new ArrayList<>();

            for (int j = 1; j <= 3; j++) {
                slots.add(new ParkingSlot(i, "C" + j, VehicleType.CAR));
            }
            for (int j = 1; j <= 2; j++) {
                slots.add(new ParkingSlot(i, "B" + j, VehicleType.BIKE));
            }
            floors.add(new Floor(i, slots, slotStrategy));
        }

        ParkingLot parkingLot = new ParkingLot(floors);

        ParkingLotManager parkingLotManager = ParkingLotManager.getInstance(parkingLot);
        TicketManager ticketManager = TicketManager.getInstance();

        EntryGate entryGate = new EntryGate(parkingLotManager, ticketManager);
        ExitGate exitGate = new ExitGate(ticketManager, parkingLotManager, pricingStrategy);

        Ticket ticket1 = entryGate.processEntry(car1);
        Ticket ticket2 = entryGate.processEntry(bike1);

        try {
            Thread.sleep(10000); // 2 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (ticket1 != null)
            exitGate.processExit(ticket1.getTicketId());

        if (ticket2 != null)
            exitGate.processExit(ticket2.getTicketId());
    }
}