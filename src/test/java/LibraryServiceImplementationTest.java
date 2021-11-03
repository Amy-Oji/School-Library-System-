import enums.BooksCollection;
import models.Books;
import models.Person;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import services.LibraryService;
import services.PersonService;
import services.servicesImplementation.LibraryServiceImplementation;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class LibraryServiceImplementationTest {
    private Books books;
    private Person person;
    private LibraryService libraryService;
    private PersonService personServices;
    private Map<String, Integer> booksCatalogue;

    @BeforeEach
    void setUp() {
        books = new Books(BooksCollection.JAVA_FOR_DUMMIES);
        libraryService = new LibraryServiceImplementation();
        personServices = new LibraryServiceImplementation();
        booksCatalogue = new HashMap<>();
    }

    @Test
    void addBookToShelf() {

    }


    @Test
    void giveBookToPerson() {
    }

    @Test
    void requestForBook() {
        libraryService.getBooksCatalogue().put(books.getBooksCollection().name(), 1);
        personServices.requestForBook(person, books);

        booksCatalogue = libraryService.getBooksCatalogue();

        assertTrue(booksCatalogue.containsKey(books.getBooksCollection().name()));
    }


    @Test
    void returnBook() {
        personServices.returnBook(books);

        booksCatalogue = libraryService.getBooksCatalogue();

        assertNotNull(booksCatalogue);

        assertEquals(1, booksCatalogue.get(books.getBooksCollection().name()));
    }

}
