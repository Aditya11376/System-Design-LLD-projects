package manager;

import entities.*;

import java.util.List;

public class ParkingLotManager {

    private static  ParkingLotManager instance;
    private final ParkingLot parkingLot;

    private ParkingLotManager(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
    }

    public static ParkingLotManager getInstance(ParkingLot parkingLot) {
        if (instance == null) {
            synchronized (ParkingLotManager.class) {
                if (instance == null) {
                    instance = new ParkingLotManager(parkingLot);
                }
            }
        }
        return instance;
    }

    public ParkingSlot parkVehicle(Vehicle vehicle){
        if(vehicle==null) return null;

        List<Floor> floors = parkingLot.getFloors();

        for(Floor floor : floors){

            FloorManager floorManager = new FloorManager(floor);

            ParkingSlot parkingSlot = floorManager.allocateSlot(vehicle);

            if(parkingSlot!=null){
                return parkingSlot;
            }
        }
        System.out.println("Parking Full!");
        return null;
    }

    public void unparkVehicle(Ticket ticket){
        if(ticket==null) return;

        List<Floor> floors = parkingLot.getFloors();

        for(Floor floor : floors){
            if(floor.getFloorId()==ticket.getFloorId()){

                FloorManager floorManager = new FloorManager(parkingLot.getFloors().get(ticket.getFloorId() - 1));
                floorManager.freeSlot(ticket.getSlot());
                break;

            }
        }
    }

}
