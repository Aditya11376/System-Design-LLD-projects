import model.Event;
import model.Notification;
import model.Subscription;
import model.UserPreference;
import model.type.PriorityEnum;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public class NotificationService {
    private NotificationQueue queue;
    private List<Subscription> subscriptions;
    private Map<String, UserPreference> preferences;

    public NotificationService(NotificationQueue queue, Map<String, UserPreference> preferences, List<Subscription> subscriptions) {
        this.queue = queue;
        this.preferences = preferences;
        this.subscriptions = subscriptions;
    }

    public void processEvent(Event event){
        for(Subscription sub : subscriptions){
            if(sub.getEventType().equals(event.getEventType())){
                UserPreference pref = preferences.get(sub.getUserId());
                for(String channel : pref.getChannels()){
                    Notification notification = new Notification(
                            UUID.randomUUID().toString(),
                            PriorityEnum.HIGH,
                            "Event triggered : "+event.getEventType(),
                            sub.getUserId()
                    );
                    NotificationTask task = new NotificationTask(channel,notification);
                    queue.add(task);
                }
            }
        }
    }
}
