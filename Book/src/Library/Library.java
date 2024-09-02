import java.util.ArrayList;

public class Library {
    private ArrayList<Book> books;

    // Constructor
    public Library() {
        books = new ArrayList<>();
    }

    // Method to add a book to the library
    public void addBook(Book book) {
        books.add(book);
        System.out.println("Book added successfully!");
    }

    // Method to display all books in the library
    public void displayAllBooks() {
        if (books.isEmpty()) {
            System.out.println("No books available in the library.");
        } else {
            System.out.println("Books in the Library:");
            System.out.println("-------------------------------------");
            for (Book book : books) {
                book.displayBookInfo();
            }
        }
    }

    // Method to search for a book by title
    public void searchBookByTitle(String title) {
        boolean found = false;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                System.out.println("Book found:");
                book.displayBookInfo();
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found.");
        }
    }
}

