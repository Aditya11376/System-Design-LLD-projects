package manager;

import entities.ParkingSlot;
import entities.Ticket;
import entities.Vehicle;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class TicketManager {

    private static final TicketManager INSTANCE = new TicketManager();
    private final Map<String, Ticket> tickets = new ConcurrentHashMap<>();

    private TicketManager(){}

    public static TicketManager getInstance(){
        return INSTANCE;
    }

    public Ticket createTicket(Vehicle vehicle, ParkingSlot slot, int floorId){
        String ticketId = UUID.randomUUID().toString();
        Ticket ticket = new Ticket(ticketId, vehicle, slot, floorId);
        tickets.put(ticketId, ticket);
        return ticket;
    }

    public void closeTicket(String ticketId){
        tickets.remove(ticketId);
    }

    public Ticket getTicket(String ticketId){
        return tickets.get(ticketId);
    }

}
