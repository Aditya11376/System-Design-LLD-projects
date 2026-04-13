package strategy.pricing;

import entities.Ticket;

public interface PricingStrategy {
    double calculatePrice(Ticket ticket);
}
