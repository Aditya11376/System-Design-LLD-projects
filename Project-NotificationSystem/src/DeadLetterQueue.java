import java.util.LinkedList;
import java.util.Queue;

public class DeadLetterQueue {
    Queue<NotificationTask> dlq = new LinkedList<>();

    public void add(NotificationTask task){
        dlq.offer(task);
    }
}
