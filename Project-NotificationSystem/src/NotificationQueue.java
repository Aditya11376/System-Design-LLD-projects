import java.util.LinkedList;
import java.util.Queue;

public class NotificationQueue {
    private Queue<NotificationTask> queue = new LinkedList<>();

    public void add(NotificationTask task){
        queue.offer(task);
    }

    public NotificationTask poll(){
        return queue.poll();
    }
}
