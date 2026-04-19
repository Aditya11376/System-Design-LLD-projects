import factory.ChannelFactory;
import strategy.NotificationChannel;

public class Worker {
    private Logger logger;
    private RetryHandler retryHandler;
    private NotificationQueue notificationQueue;

    public Worker(Logger logger, RetryHandler retryHandler, NotificationQueue notificationQueue) {
        this.logger = logger;
        this.retryHandler = retryHandler;
        this.notificationQueue = notificationQueue;
    }

    public void process(){
        while(true){
            NotificationTask task = notificationQueue.poll();
            if(task==null) break;
            NotificationChannel notificationChannel = ChannelFactory.getChannel(task.getChannelType());
            boolean status = notificationChannel.send(task.getNotification());
            if(status){
                logger.logSuccess(task);
            }else{
                logger.logFailure(task);
            }
        }
    }
}
