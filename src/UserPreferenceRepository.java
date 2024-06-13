import java.util.HashMap;
import java.util.Map;

public class UserPreferenceRepository {
    private Map<Integer, UserPreference> preferences = new HashMap<>();

    public void addUserPreference(UserPreference preference) {
        preferences.put(preference.getUserId(), preference);
    }

    public UserPreference getUserPreference(int userId) {
        return preferences.get(userId);
    }

    public void updateUserPreference(UserPreference preference) {
        preferences.put(preference.getUserId(), preference);
    }

    public void deleteUserPreference(int userId) {
        preferences.remove(userId);
    }
}
