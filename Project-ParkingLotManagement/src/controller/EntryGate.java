package controller;

import entities.ParkingSlot;
import entities.Ticket;
import entities.Vehicle;
import manager.ParkingLotManager;
import manager.TicketManager;

public class EntryGate {

    private final ParkingLotManager parkingLotManager;
    private final TicketManager ticketManager;

    public EntryGate(ParkingLotManager parkingLotManager, TicketManager ticketManager) {
        this.parkingLotManager = parkingLotManager;
        this.ticketManager = ticketManager;
    }

    public Ticket processEntry(Vehicle vehicle){
        if(vehicle == null)
        {
            System.out.println("Vehicle is not Allowed!");
            return null;
        }

        ParkingSlot slot = parkingLotManager.parkVehicle(vehicle);

        if(slot==null) {
            System.out.println("Parking Full!");
            return null;
        }

        Ticket ticket = ticketManager.createTicket(vehicle,slot,slot.getFloorId());

        System.out.println("Parking Successful. Ticket ID: " + ticket.getTicketId());
        return ticket;
    }

}
