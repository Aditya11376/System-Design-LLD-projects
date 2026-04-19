package model;

public class Event {
    private final String eventId;
    private final String eventType;

    public Event(String eventId, String eventType) {
        this.eventId = eventId;
        this.eventType = eventType;
    }

    public String getEventType() {
        return eventType;
    }
}
