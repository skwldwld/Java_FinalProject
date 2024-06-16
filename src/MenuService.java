import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class MenuService {
    private MenuRepository menuRepository = new MenuRepository();
    private UserPreferenceRepository userPreferenceRepository = new UserPreferenceRepository();
    private Random random = new Random();

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

    public UserPreference getUserPreference(String userName) {
        return userPreferenceRepository.getUserPreference(userName);
    }

    public Menu recommendMenu(String userName) {
        UserPreference preference = userPreferenceRepository.getUserPreference(userName);
        List<Menu> filteredMenus;

        if (preference == null) {
            filteredMenus = getAllMenus();
        } else {
            filteredMenus = menuRepository.getAllMenus().stream()
                    .filter(menu -> menu.getCategory().equals(preference.getPreferredCategory()))
                    .filter(menu -> menu.getPrice() <= preference.getPreferredPrice())
                    .filter(menu -> menu.getRating() >= preference.getPreferredRating())
                    .collect(Collectors.toList());
        }

        if (filteredMenus.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(filteredMenus.size());
        return filteredMenus.get(randomIndex);
    }
}
