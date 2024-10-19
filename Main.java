import java.util.ArrayList;
import java.util.List;

public class Main {

    static class User {
        String name;
        String email;
        String role;

        User(String name, String email, String role) {
            this.name = name;
            this.email = email;
            this.role = role;
        }
    }

    static class UserManager {
        private List<User> users = new ArrayList<>();

        void addUser(String name, String email, String role) {
            users.add(new User(name, email, role));
        }

        void removeUser(String email) {
            users.removeIf(user -> user.email.equals(email));
        }

        void updateUser(String email, String newName, String newRole) {
            for (User user : users) {
                if (user.email.equals(email)) {
                    user.name = newName;
                    user.role = newRole;
                    break;
                }
            }
        }

        void displayUsers() {
            if (users.isEmpty()) {
                System.out.println("No users available.");
                return;
            }
            for (User user : users) {
                System.out.printf("Name: %s | Email: %s | Role: %s%n", user.name, user.email, user.role);
            }
        }
    }

    public static void main(String[] args) {
        UserManager userManager = new UserManager();

        userManager.addUser("Erko", "erko@gmail.com", "admin");
        userManager.addUser("Manat", "manat@mail.ru", "person");

        System.out.println("Current Users:");
        userManager.displayUsers();

        userManager.updateUser("erko@example.com", "Erkobalt", "admin+++");

        System.out.println("\nusers after upd ");
        userManager.displayUsers();

        userManager.removeUser("manat@mail.ru");

        System.out.println("\nusers after delete ");
        userManager.displayUsers();
    }
}
