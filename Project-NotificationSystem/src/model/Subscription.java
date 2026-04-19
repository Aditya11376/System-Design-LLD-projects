package model;

public class Subscription {
    private final String userId;
    private final String eventType;

    public Subscription(String userId, String eventType) {
        this.userId = userId;
        this.eventType = eventType;
    }

    public String getUserId() {
        return userId;
    }

    public String getEventType() {
        return eventType;
    }
}
