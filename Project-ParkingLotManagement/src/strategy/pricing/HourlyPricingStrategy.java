package strategy.pricing;

import entities.Ticket;
import entities.type.VehicleType;

public class HourlyPricingStrategy implements PricingStrategy{
    @Override
    public double calculatePrice(Ticket ticket) {
        if(ticket==null|| ticket.getVehicle() == null) return 0.0;

        long hours = ticket.getParkingDurationInHours();

        if(hours==0) hours=1;

        if(ticket.getVehicle().getVehicleType()== VehicleType.CAR){
            return hours*20;
        }else if(ticket.getVehicle().getVehicleType()== VehicleType.BIKE){
            return hours*10;
        }else if(ticket.getVehicle().getVehicleType()== VehicleType.AUTO) {
            return hours * 15;
        }
        return 0;
    }
}
