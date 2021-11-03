package services.servicesImplementation;

       //import enums.BooksCollection;
import models.Books;
import models.Person;
import services.*;
//import services.LibrarianService;
      //import services.PersonService;
import java.util.*;

public class LibraryServiceImplementation implements LibraryService, PersonService {
    private final static Queue<Person> personQueue = new LinkedList<>();
    private final static Map<String, Integer> booksCatalogue = new HashMap<>();
    private final static Map<String, Enum> bookLenders = new HashMap<>();
    private final static Queue<Person> priorityQueue = new PriorityQueue<>(new Comparator<Person>() {

        @Override
    public int compare(Person person1, Person person2) {
        if (person1.getPriority() < person2.getPriority()) {
            return -1;
        } else if (person1.getPriority() > person2.getPriority()) {
            return -1;
        } else {
            return 0;
        }
    }

});

    public LibraryServiceImplementation() {
    }

    public Queue<Person> getPersonQueue(){ return personQueue; }

    public Queue<Person> getPriorityQueue() { return priorityQueue; }

    public Map<String, Enum> getBookLenders() { return bookLenders;}

    public Map<String, Integer> getBooksCatalogue() { return booksCatalogue; }

    @Override
    public void addBookToShelf(Books books, int noOfCopies) {
        if (this.getBooksCatalogue().containsKey(books.getBooksCollection().name())){
            this.getBooksCatalogue().put(books.getBooksCollection().name(),
                    this.getBooksCatalogue().get(books.getBooksCollection().name())+noOfCopies);
        } else {
            this.getBooksCatalogue().put(books.getBooksCollection().name(), noOfCopies);
        }

    }

    @Override
    public String giveBookToPerson() {
        final Person person = this.getPriorityQueue().remove();
        final Enum personValue = this.getBookLenders().get(person.getName());
        final int noOfCopies = this.getBooksCatalogue().get(personValue.toString());
        //TODO
        //check the copies of the book if 0 return book taken.
        //check the priority queue if empty return no request made.

        if (!priorityQueue.isEmpty() && noOfCopies > 0) {
            this.getBooksCatalogue().put(personValue.name(), noOfCopies - 1);
        } else {
            System.out.println("Book taken");
        }

        return null;
    }


    @Override
    public void requestForBook(Person person, Books books) {
        if(getBooksCatalogue().containsKey(books.getBooksCollection()
                .name()) && person != null && !this.getPersonQueue().contains(person)){
            this.getBookLenders().put(person.getName(), books.getBooksCollection());
            this.getPriorityQueue().add(person);
        }

    }

    @Override
    public void returnBook(Books books) {
        if (this.getBooksCatalogue().containsKey(books.getBooksCollection().name())){
            this.getBooksCatalogue().put(books.getBooksCollection().name(),
                    this.getBooksCatalogue().get(books.getBooksCollection().name())+1);
        } else{
            this.getBooksCatalogue().put(books.getBooksCollection().name(), 1);
        }

    }
}


