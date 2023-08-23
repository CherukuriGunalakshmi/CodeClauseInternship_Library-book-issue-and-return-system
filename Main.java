import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void displayBooks(List<Book> books) {
        System.out.println("Available Books:");
        for (Book book : books) {
            System.out.println(book);
        }
    }

    public static void main(String[] args) {
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Introduction to Java", "John Smith"));
        books.add(new Book(2, "Data Structures and Algorithms", "Jane Doe"));
        books.add(new Book(3, "Java Programming Basics", "Alice Johnson"));

        List<User> users = new ArrayList<>();
        users.add(new User(101, "User1"));
        users.add(new User(102, "User2"));

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nLibrary Management System");
            System.out.println("1. Display Available Books");
            System.out.println("2. Issue Book");
            System.out.println("3. Return Book");
            System.out.println("4. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    displayBooks(books);
                    break;
                case 2:
                    displayBooks(books);
                    System.out.print("Enter User ID: ");
                    int userId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    int bookId = scanner.nextInt();

                    User user = users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
                    Book book = books.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);

                    if (user != null && book != null) {
                        if (user.issueBook(book)) {
                            System.out.println(book.getTitle() + " has been issued to " + user.getName());
                        } else {
                            System.out.println("Book is already issued.");
                        }
                    } else {
                        System.out.println("Invalid User ID or Book ID.");
                    }
                    break;
                case 3:
                    System.out.print("Enter User ID: ");
                    userId = scanner.nextInt();
                    System.out.print("Enter Book ID: ");
                    bookId = scanner.nextInt();

                    user = users.stream().filter(u -> u.getUserId() == userId).findFirst().orElse(null);
                    book = books.stream().filter(b -> b.getBookId() == bookId).findFirst().orElse(null);

                    if (user != null && book != null) {
                        if (user.returnBook(book)) {
                            System.out.println(book.getTitle() + " has been returned by " + user.getName());
                        } else {
                            System.out.println("Book is not issued to this user.");
                        }
                    } else {
                        System.out.println("Invalid User ID or Book ID.");
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please select a valid option.");
                    break;
            }
        }
    }
}
