package services;

import models.Books;
import models.Person;

public interface PersonService {

    void requestForBook(Person person, Books books);
    void returnBook(Books books);



}
