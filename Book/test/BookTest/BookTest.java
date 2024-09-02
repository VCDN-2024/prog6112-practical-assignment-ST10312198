import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BookTest {

    private Book book;

    @BeforeEach
    void setUp() {
        book = new Book("The Hobbit", "J.R.R. Tolkien", 1937);
    }

    @Test
    void testGetTitle() {
        assertEquals("The Hobbit", book.getTitle());
    }

    @Test
    void testGetAuthor() {
        assertEquals("J.R.R. Tolkien", book.getAuthor());
    }

    @Test
    void testGetYear() {
        assertEquals(1937, book.getYear());
    }

    @Test
    void testDisplayBookInfo() {
        String info = book.displayBookInfo();

        assertTrue(info.contains("The Hobbit"));
        assertTrue(info.contains("J.R.R. Tolkien"));
        assertTrue(info.contains("1937"));
    }
}

