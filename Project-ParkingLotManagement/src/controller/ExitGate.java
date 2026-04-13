package controller;

import entities.Ticket;
import manager.ParkingLotManager;
import manager.TicketManager;
import strategy.pricing.PricingStrategy;

public class ExitGate {
    private TicketManager ticketManager;
    private ParkingLotManager parkingLotManager;
    private PricingStrategy pricingStrategy;

    public ExitGate(TicketManager ticketManager,
                    ParkingLotManager parkingLotManager,
                    PricingStrategy pricingStrategy) {
        this.ticketManager = ticketManager;
        this.parkingLotManager = parkingLotManager;
        this.pricingStrategy = pricingStrategy;
    }

    public void processExit(String ticketId){
        Ticket ticket = ticketManager.getTicket(ticketId);
        if(ticket==null){
            System.out.println("Invalid Ticket");
            return;
        }

        ticket.markExit();
        double amount = pricingStrategy.calculatePrice(ticket);
        System.out.println("Amount "+ amount+"Payment completed!");

        parkingLotManager.unparkVehicle(ticket);
        ticketManager.closeTicket(ticketId);
        System.out.println("Exit Successful");
    }
}
