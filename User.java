import java.util.ArrayList;
import java.util.List;

public class User {
    private int userId;
    private String name;
    private List<Book> issuedBooks;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
        this.issuedBooks = new ArrayList<>();
    }

    public int getUserId() {
        return userId;
    }

    public String getName() {
        return name;
    }

    public boolean issueBook(Book book) {
        if (!book.isIssued()) {
            book.setIssued(true);
            issuedBooks.add(book);
            return true;
        }
        return false;
    }

    public boolean returnBook(Book book) {
        if (issuedBooks.contains(book)) {
            book.setIssued(false);
            issuedBooks.remove(book);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "User ID: " + userId + ", Name: " + name;
    }
}
