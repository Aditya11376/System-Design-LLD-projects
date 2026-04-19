public class Logger {
    public void logSuccess(NotificationTask notificationTask){
        System.out.println("SUCCESS : "+notificationTask.getNotification().getMessage());
    }
    public void logFailure(NotificationTask notificationTask){
        System.out.println("FAIL : "+notificationTask.getNotification().getMessage());
    }
}
