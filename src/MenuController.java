import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class MenuController {
    private MenuService menuService = new MenuService();

    public void start() {
        JFrame frame = new JFrame("Food Menu Recommendation");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(0, 1));

        JButton addMenuButton = new JButton("Add Menu");
        JButton viewAllMenusButton = new JButton("View All Menus");
        JButton updateMenuButton = new JButton("Update Menu");
        JButton deleteMenuButton = new JButton("Delete Menu");
        JButton addUserPreferenceButton = new JButton("Add User Preference");
        JButton recommendMenusButton = new JButton("Recommend Menus");

        panel.add(addMenuButton);
        panel.add(viewAllMenusButton);
        panel.add(updateMenuButton);
        panel.add(deleteMenuButton);
        panel.add(addUserPreferenceButton);
        panel.add(recommendMenusButton);

        frame.getContentPane().add(BorderLayout.CENTER, panel);

        addMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addMenu();
            }
        });

        viewAllMenusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                viewAllMenus();
            }
        });

        updateMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateMenu();
            }
        });

        deleteMenuButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteMenu();
            }
        });

        addUserPreferenceButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addUserPreference();
            }
        });

        recommendMenusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                recommendMenu();
            }
        });

        frame.setVisible(true);
    }

    private void addMenu() {
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField ratingField = new JTextField();

        JPanel panel = new JPanel(new GridLayout(0, 2));
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Rating:"));
        panel.add(ratingField);

        int option = JOptionPane.showConfirmDialog(null, panel, "Add Menu", JOptionPane.OK_CANCEL_OPTION);

        if (option == JOptionPane.OK_OPTION) {
            String name = nameField.getText();
            String description = descriptionField.getText();
            String category = categoryField.getText();
            int price = Integer.parseInt(priceField.getText());
            double rating = Double.parseDouble(ratingField.getText());

            Menu menu = new Menu(0, name, description, category, price, rating);
            menuService.addMenu(menu);
            JOptionPane.showMessageDialog(null, "Menu added successfully.");
        }
    }

    private void viewAllMenus() {
        List<Menu> menus = menuService.getAllMenus();
        StringBuilder message = new StringBuilder();
        for (Menu menu : menus) {
            message.append("ID: ").append(menu.getId())
                    .append("\nName: ").append(menu.getName())
                    .append("\nDescription: ").append(menu.getDescription())
                    .append("\nCategory: ").append(menu.getCategory())
                    .append("\nPrice: ").append(menu.getPrice())
                    .append("\nRating: ").append(menu.getRating())
                    .append("\n------------\n");
        }
        JOptionPane.showMessageDialog(null, message.toString());
    }

    private void updateMenu() {
        JTextField idField = new JTextField();
        JTextField nameField = new JTextField();
        JTextField descriptionField = new JTextField();
        JTextField categoryField = new JTextField();
        JTextField priceField = new JTextField();
        JTextField ratingField = new JTextField();

        Object[] message = {
                "ID:", idField,
                "Name:", nameField,
                "Description:", descriptionField,
                "Category:", categoryField,
                "Price:", priceField,
                "Rating:", ratingField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Update Menu", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            String description = descriptionField.getText();
            String category = categoryField.getText();
            int price = Integer.parseInt(priceField.getText());
            double rating = Double.parseDouble(ratingField.getText());

            Menu menu = new Menu(id, name, description, category, price, rating);
            menuService.updateMenu(menu);
            JOptionPane.showMessageDialog(null, "Menu updated successfully.");
        }
    }

    private void deleteMenu() {
        String idString = JOptionPane.showInputDialog("Enter menu ID:");
        int id = Integer.parseInt(idString);

        menuService.deleteMenu(id);
        JOptionPane.showMessageDialog(null, "Menu deleted successfully.");
    }

    private void addUserPreference() {
        JTextField userNameField = new JTextField();
        JTextField preferredCategoryField = new JTextField();
        JTextField preferredPriceField = new JTextField();
        JTextField preferredRatingField = new JTextField();

        Object[] message = {
                "User Name:", userNameField,
                "Preferred Category:", preferredCategoryField,
                "Preferred Price:", preferredPriceField,
                "Preferred Rating:", preferredRatingField
        };

        int option = JOptionPane.showConfirmDialog(null, message, "Add User Preference", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION) {
            String userName = userNameField.getText();
            String preferredCategory = preferredCategoryField.getText();
            int preferredPrice = Integer.parseInt(preferredPriceField.getText());
            double preferredRating = Double.parseDouble(preferredRatingField.getText());

            UserPreference preference = new UserPreference(userName, preferredCategory, preferredPrice, preferredRating);
            menuService.addUserPreference(preference);
            JOptionPane.showMessageDialog(null, "User preference added successfully.");
        }
    }

    private void recommendMenu() {
        String userNameString = JOptionPane.showInputDialog("Enter user Name:");
        String userName = userNameString;

        Menu recommendedMenu = menuService.recommendMenu(userName);
        if (recommendedMenu != null) {
            String message = "ID: " + recommendedMenu.getId() +
                    "\nName: " + recommendedMenu.getName() +
                    "\nDescription: " + recommendedMenu.getDescription() +
                    "\nCategory: " + recommendedMenu.getCategory() +
                    "\nPrice: " + recommendedMenu.getPrice() +
                    "\nRating: " + recommendedMenu.getRating();
            JOptionPane.showMessageDialog(null, message);
        } else {
            JOptionPane.showMessageDialog(null, "No menu found for the given preferences.");
        }
    }

    public static void main(String[] args) {
        MenuController menuController = new MenuController();
        menuController.start();
    }
}
