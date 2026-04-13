package entities;

import java.util.List;

public class ParkingLot {

    private final List<Floor> floors;

    public ParkingLot(List<Floor> floors) {
        this.floors = floors;
    }

    public List<Floor> getFloors() {
        return floors;
    }

}
