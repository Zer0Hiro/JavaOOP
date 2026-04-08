package library;

public class Library {
    private Book[] books;

    public Library(int size) {
        this.books = new Book[size];
    }

    // create book and save to specific index
    public void setBook(int bookNum, String title, Author auth) {
        Book newBook = new Book(title, auth);
        books[bookNum] = newBook;
    }

    public Book getBook(int bookNum) {
        return books[bookNum];
    }

}
