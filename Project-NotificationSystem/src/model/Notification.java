package model;

import model.type.PriorityEnum;

public class Notification {
    private final String id;
    private final String message;
    private final PriorityEnum priority;
    private final String userId;

    public Notification(String id, PriorityEnum priority, String message, String userId) {
        this.id = id;
        this.priority = priority;
        this.message = message;
        this.userId = userId;
    }

    public String getUserId() {
        return userId;
    }

    public String getMessage() {
        return message;
    }
}
