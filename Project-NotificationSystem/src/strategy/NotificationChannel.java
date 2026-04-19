package strategy;

import model.Notification;

public interface NotificationChannel {
    String getChannelType();
    boolean send(Notification notification);
}
