import java.util.ArrayList;
import java.util.List;

public class MenuRepository {
    private List<Menu> menus = new ArrayList<>();
    private int nextId = 1;

    public void addMenu(Menu menu) {
        menu.setId(nextId++);
        menus.add(menu);
    }

    public Menu getMenu(int id) {
        return menus.stream().filter(menu -> menu.getId() == id).findFirst().orElse(null);
    }

    public List<Menu> getAllMenus() {
        return new ArrayList<>(menus);
    }

    public void updateMenu(Menu updatedMenu) {
        Menu menu = getMenu(updatedMenu.getId());
        if (menu != null) {
            menu.setName(updatedMenu.getName());
            menu.setDescription(updatedMenu.getDescription());
            menu.setCategory(updatedMenu.getCategory());
            menu.setPrice(updatedMenu.getPrice());
            menu.setRating(updatedMenu.getRating());
        }
    }

    public void deleteMenu(int id) {
        menus.removeIf(menu -> menu.getId() == id);
    }
}
