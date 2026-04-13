package entities;

import java.time.Duration;
import java.time.LocalDateTime;

public class Ticket {

    private String ticketId;
    private Vehicle vehicle;
    private ParkingSlot slot;
    private int floorId;
    private LocalDateTime entryTime;
    private LocalDateTime exitTime;

    public Ticket(String ticketId, Vehicle vehicle, ParkingSlot slot, int floorId) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.slot = slot;
        this.floorId = floorId;
        this.entryTime = LocalDateTime.now();
    }

    public void markExit() {
        this.exitTime = LocalDateTime.now();
    }

    public long getParkingDurationInHours() {
        if (exitTime == null) return 0;

        return Duration.between(entryTime, exitTime).toHours();
    }

    public String getTicketId() {
        return ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSlot getSlot() {
        return slot;
    }

    public int getFloorId() {
        return floorId;
    }

    public LocalDateTime getExitTime() {
        return exitTime;
    }

    public LocalDateTime getEntryTime() {
        return entryTime;
    }
}
