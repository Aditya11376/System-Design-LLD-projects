package model;

import java.util.List;

public class UserPreference {
    private String userId;
    private List<String> channels;

    public UserPreference(String userId, List<String> channels) {
        this.userId = userId;
        this.channels = channels;
    }

    public List<String> getChannels() {
        return channels;
    }
}
