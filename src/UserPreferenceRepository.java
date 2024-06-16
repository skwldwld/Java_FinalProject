import java.util.HashMap;
import java.util.Map;

public class UserPreferenceRepository {
    private Map<String, UserPreference> preferences = new HashMap<>();

    public void addUserPreference(UserPreference preference) {
        preferences.put(preference.getUserName(), preference);
    }

    public UserPreference getUserPreference(String userName) {
        return preferences.get(userName);
    }

    public void updateUserPreference(UserPreference preference) {
        preferences.put(preference.getUserName(), preference);
    }

    public void deleteUserPreference(String userName) {
        preferences.remove(userName);
    }
}
