import java.util.List;
import java.util.stream.Collectors;

public class MenuService {
    private MenuRepository menuRepository = new MenuRepository();
    private UserPreferenceRepository userPreferenceRepository = new UserPreferenceRepository();

    public void addMenu(Menu menu) {
        menuRepository.addMenu(menu);
    }

    public Menu getMenu(int id) {
        return menuRepository.getMenu(id);
    }

    public List<Menu> getAllMenus() {
        return menuRepository.getAllMenus();
    }

    public void updateMenu(Menu menu) {
        menuRepository.updateMenu(menu);
    }

    public void deleteMenu(int id) {
        menuRepository.deleteMenu(id);
    }

    public void addUserPreference(UserPreference preference) {
        userPreferenceRepository.addUserPreference(preference);
    }

    public UserPreference getUserPreference(int userId) {
        return userPreferenceRepository.getUserPreference(userId);
    }

    public List<Menu> recommendMenus(int userId) {
        UserPreference preference = userPreferenceRepository.getUserPreference(userId);
        if (preference == null) {
            return getAllMenus();
        }
        return menuRepository.getAllMenus().stream()
                .filter(menu -> menu.getCategory().equals(preference.getPreferredCategory()))
                .filter(menu -> menu.getPrice() <= preference.getPreferredPrice())
                .filter(menu -> menu.getRating() >= preference.getPreferredRating())
                .collect(Collectors.toList());
    }
}
