package strategy;

import model.Notification;

public class PushNotificationChannel implements NotificationChannel{
    @Override
    public String getChannelType() {
        return "PUSH";
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("Push sent: " + notification.getMessage());
        return true;
    }
}
