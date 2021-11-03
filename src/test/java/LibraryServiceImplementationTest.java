import enums.BooksCollection;
import enums.PersonStatus;
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
    LibraryServiceImplementation lib;
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
        lib = new LibraryServiceImplementation();
    }

    @Test
    void addBookToShelf() {
        libraryService.addBookToShelf(books, 3);

        booksCatalogue = libraryService.getBooksCatalogue();

        assertNotNull(booksCatalogue);

        assertEquals(3, booksCatalogue.get(books.getBooksCollection().name()));

    }


    @Test
    void giveBookToPerson() {
        Person juniorStudent3 = new Person("Francis", "89574", PersonStatus.JUNIOR_STUDENT);
        Person teacher1 = new Person("Daro", "67480", PersonStatus.TEACHER);
        lib.getPriorityQueue().add(juniorStudent3);
        lib.getPriorityQueue().add(teacher1);
        assertEquals(teacher1.getName(), lib.getPriorityQueue().remove().getName());
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
