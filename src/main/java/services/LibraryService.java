package services;

import models.Books;

public interface LibraryService {

    void addBookToShelf(Books books, int noOfCopies);
    String giveBookToPerson();


}
