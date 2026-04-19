import model.Notification;

public class NotificationTask {

    private String channelType;
    private Notification notification;
    private int retryCount;

    public NotificationTask(String channelType, Notification notification) {
        this.channelType = channelType;
        this.notification = notification;
        this.retryCount =0;
    }

    public void incrementRetry(){
        retryCount++;
    }

    public String getChannelType() {
        return channelType;
    }

    public Notification getNotification() {
        return notification;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
