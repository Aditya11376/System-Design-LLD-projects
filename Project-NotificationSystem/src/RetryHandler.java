public class RetryHandler {
    private static final int MAX_RETRY = 3;
    private DeadLetterQueue dlq;

    public RetryHandler(DeadLetterQueue dlq) {
        this.dlq = dlq;
    }

    public void handleRetry(NotificationTask task){
        if(task.getRetryCount()>=MAX_RETRY){
            dlq.add(task);
            System.out.println("Moved to DLQ");
        }else{
            task.incrementRetry();
            System.out.println("Retrying...");
        }
    }
}
