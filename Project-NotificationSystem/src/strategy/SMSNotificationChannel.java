package strategy;

import model.Notification;

public class SMSNotificationChannel implements NotificationChannel{
    @Override
    public String getChannelType() {
        return "SMS";
    }

    @Override
    public boolean send(Notification notification) {
        System.out.println("SMS sent: "+notification.getMessage());
        return true;
    }
}
