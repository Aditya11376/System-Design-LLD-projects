import model.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        NotificationQueue queue = new NotificationQueue();
        DeadLetterQueue dlq = new DeadLetterQueue();

        Logger logger = new Logger();
        RetryHandler retryHandler = new RetryHandler(dlq);
        Worker worker = new Worker(logger, retryHandler, queue);

        List<Subscription> subscriptions = new ArrayList<>();
        subscriptions.add(new Subscription("user1", "ORDER_PLACED"));
        subscriptions.add(new Subscription("user2", "ORDER_PLACED"));

        Map<String, UserPreference> preferences = new HashMap<>();

        preferences.put("user1", new UserPreference(
                "user1",
                Arrays.asList("EMAIL", "SMS")
        ));

        preferences.put("user2", new UserPreference(
                "user2",
                Arrays.asList("PUSH")
        ));

        NotificationService notificationService =
                new NotificationService(queue, preferences, subscriptions);

        Event event = new Event("1", "ORDER_PLACED");

        System.out.println("---- Triggering Event ----");
        notificationService.processEvent(event);

        System.out.println("---- Worker Processing ----");
        worker.process();

        System.out.println("---- Done ----");
    }
}