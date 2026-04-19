package factory;

import strategy.EmailNotificationChannel;
import strategy.NotificationChannel;
import strategy.PushNotificationChannel;
import strategy.SMSNotificationChannel;

public class ChannelFactory {
    public static NotificationChannel getChannel(String type){
        switch (type){
            case "EMAIL" : return new EmailNotificationChannel();
            case "SMS" : return new SMSNotificationChannel();
            case "PUSH" : return new PushNotificationChannel();
            default : throw new IllegalArgumentException("INVALID CHANNEL!");
        }
    }
}
