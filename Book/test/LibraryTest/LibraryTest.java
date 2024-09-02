import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

class LibraryTest {

    private Library library;

    @BeforeEach
    void setUp() {
        library = new Library();
    }

    @Test
    void testAddBook() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook(book);

        // Check if the book was added successfully
        ArrayList<Book> books = library.getBooks();
        assertEquals(1, books.size());
        assertEquals("The Hobbit", books.get(0).getTitle());
    }

    @Test
    void testSearchBookByTitleFound() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book2 = new Book("1984", "George Orwell", 1949);
        library.addBook(book1);
        library.addBook(book2);

        Book result = library.searchBookByTitle("1984");

        assertNotNull(result);
        assertEquals("1984", result.getTitle());
    }

    @Test
    void testSearchBookByTitleNotFound() {
        Book book = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        library.addBook(book);

        Book result = library.searchBookByTitle("Unknown Title");

        assertNull(result);
    }

    @Test
    void testDisplayAllBooks() {
        Book book1 = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
        Book book2 = new Book("1984", "George Orwell", 1949);
        library.addBook(book1);
        library.addBook(book2);

        // Assuming that the displayAllBooks() method returns a String for testing
        String report = library.displayAllBooks();

        assertTrue(report.contains("The Hobbit"));
        assertTrue(report.contains("1984"));
    }

    @Test
    void testDisplayAllBooksEmptyLibrary() {
        String report = library.displayAllBooks();

        assertEquals("No books available in the library.", report.trim());
    }
}
