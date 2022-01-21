package services;

import models.Books;

import java.util.Map;

public interface LibraryService {

    void addBookToShelf(Books books, int noOfCopies);
    String giveBookToPerson();


    Map<String, Integer> getBooksCatalogue();

}
