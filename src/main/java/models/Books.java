package models;
import enums.BooksCollection;


public class Books {
    private BooksCollection booksCollection;

    public Books(BooksCollection booksCollection) {
        this.booksCollection = booksCollection;
    }

    public BooksCollection getBooksCollection() {
        return booksCollection;
    }
}



