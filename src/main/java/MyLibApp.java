import enums.BooksCollection;
import enums.PersonStatus;
import models.Books;
import services.servicesImplementation.LibraryServiceImplementation;
import models.Person;

public class MyLibApp {
    public static void main(String[] args) {

        LibraryServiceImplementation library = new LibraryServiceImplementation();

        Books JavaForDummies = new Books(BooksCollection.JAVA_FOR_DUMMIES);
        Books IntroToPrograming = new Books(BooksCollection.INTRO_TO_PROGRAMING);
        Books IntoToOop = new Books(BooksCollection.INTRODUCTION_TO_OOP);
        Books Algorithms = new Books(BooksCollection.ALGORITHMS);
        Books FrontEndForBeginners = new Books(BooksCollection.FRONTEND_FOR_BEGINNERS);
        Books IntroToComputerScience = new Books(BooksCollection.INTRO_TO_COMPUTER_SCIENCE);

        Person juniorStudent3 = new Person("Francis", "89574", PersonStatus.JUNIOR_STUDENT);
        Person teacher1 = new Person("Taya", "67480", PersonStatus.TEACHER);
        Person teacher2 = new Person("Emeka", "78498", PersonStatus.TEACHER);
        Person teacher3 = new Person ("Tosin", "75860", PersonStatus.TEACHER);
        Person juniorStudent2 = new Person("Daro", "8862", PersonStatus.JUNIOR_STUDENT);
        Person seniorStudent2 = new Person("Nebe","78566", PersonStatus.SENIOR_STUDENT);
        Person juniorStudent = new Person("Ken", "937846", PersonStatus.JUNIOR_STUDENT);



        library.addBookToShelf(JavaForDummies, 6);
        library.addBookToShelf(IntoToOop,2);
        library.addBookToShelf(FrontEndForBeginners, 3);
        library.addBookToShelf(IntroToComputerScience, 1);
        library.addBookToShelf(Algorithms, 9);
        library.addBookToShelf(IntroToPrograming, 7);

        System.out.println(library.getBooksCatalogue());



        //library.requestForBook(teacher3, Algorithms);
        library.requestForBook(teacher1, IntoToOop);
        //library.requestForBook(teacher, IntoToOop);
        library.requestForBook(teacher3, IntoToOop);
        library.requestForBook(teacher2, JavaForDummies);
//        library.requestForBook(juniorStudent2, FrontEndForBeginners);
//        library.requestForBook(juniorStudent3, IntoToOop);



        System.out.println(library.giveBookToPerson());
        System.out.println(library.giveBookToPerson());
        System.out.println(library.giveBookToPerson());
       // System.out.println(library.giveBookToPerson());
        //System.out.println(library.giveBookToPerson());

        System.out.println(library.getBooksCatalogue());


    }
}