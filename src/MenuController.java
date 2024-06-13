import java.util.Scanner;

public class MenuController {
    private MenuService menuService = new MenuService();
    private Scanner scanner = new Scanner(System.in);

    public void start() {
        while (true) {
            System.out.println("1. Add Menu");
            System.out.println("2. View Menu");
            System.out.println("3. View All Menus");
            System.out.println("4. Update Menu");
            System.out.println("5. Delete Menu");
            System.out.println("6. Add User Preference");
            System.out.println("7. Recommend Menus");
            System.out.println("0. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    viewMenu();
                    break;
                case 3:
                    viewAllMenus();
                    break;
                case 4:
                    updateMenu();
                    break;
                case 5:
                    deleteMenu();
                    break;
                case 6:
                    addUserPreference();
                    break;
                case 7:
                    recommendMenus();
                    break;
                case 0:
                    System.exit(0);
                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    private void addMenu() {
        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        Menu menu = new Menu(0, name, description, category, price, rating);
        menuService.addMenu(menu);
        System.out.println("Menu added successfully.");
    }

    private void viewMenu() {
        System.out.println("Enter menu ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        Menu menu = menuService.getMenu(id);
        if (menu != null) {
            System.out.println("ID: " + menu.getId());
            System.out.println("Name: " + menu.getName());
            System.out.println("Description: " + menu.getDescription());
            System.out.println("Category: " + menu.getCategory());
            System.out.println("Price: " + menu.getPrice());
            System.out.println("Rating: " + menu.getRating());
        } else {
            System.out.println("Menu not found.");
        }
    }

    private void viewAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        for (Menu menu : menus) {
            System.out.println("ID: " + menu.getId());
            System.out.println("Name: " + menu.getName());
            System.out.println("Description: " + menu.getDescription());
            System.out.println("Category: " + menu.getCategory());
            System.out.println("Price: " + menu.getPrice());
            System.out.println("Rating: " + menu.getRating());
            System.out.println("------------");
        }
    }

    private void updateMenu() {
        System.out.println("Enter menu ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter name:");
        String name = scanner.nextLine();
        System.out.println("Enter description:");
        String description = scanner.nextLine();
        System.out.println("Enter category:");
        String category = scanner.nextLine();
        System.out.println("Enter price:");
        double price = scanner.nextDouble();
        System.out.println("Enter rating:");
        double rating = scanner.nextDouble();
        scanner.nextLine();

        Menu menu = new Menu(id, name, description, category, price, rating);
        menuService.updateMenu(menu);
        System.out.println("Menu updated successfully.");
    }

    private void deleteMenu() {
        System.out.println("Enter menu ID:");
        int id = scanner.nextInt();
        scanner.nextLine();

        menuService.deleteMenu(id);
        System.out.println("Menu deleted successfully.");
    }

    private void addUserPreference() {
        System.out.println("Enter user ID:");
        int userId = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Enter preferred category:");
        String preferredCategory = scanner.nextLine();
        System.out.println("Enter preferred price:");
        double preferredPrice = scanner.nextDouble();
        System.out.println("Enter preferred rating:");
        double preferredRating = scanner.nextDouble();
        scanner.nextLine();

        UserPreference preference = new UserPreference(userId, preferredCategory, preferredPrice, preferredRating);
        menuService.addUserPreference(preference);
        System.out.println("User preference added successfully.");
    }

    private void recommendMenus() {
        System.out.println("Enter user ID:");
        int userId = scanner.nextInt();
        scanner.nextLine();

        List<Menu> recommendedMenus = menuService.recommendMenus(userId);
        for (Menu menu : recommendedMenus) {
            System.out.println("ID: " + menu.getId());
            System.out.println("Name: " + menu.getName());
            System.out.println("Description: " + menu.getDescription());
            System.out.println("Category: " + menu.getCategory());
            System.out.println("Price: " + menu.getPrice());
            System.out.println("Rating: " + menu.getRating());
            System.out.println("------------");
        }
    }
}
