package strategy;

import model.Notification;

public class EmailNotificationChannel implements NotificationChannel{
    @Override
    public String getChannelType() {
        return "EMAIL";
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("Email sent: " + notification.getMessage());
        return true;
    }
}
