package net.hojnacki.bookstore.book;

public class Book {

    public String bookId;
    public String title;
    public String authorId;

    public Book(String bookId, String title, String authorId) {
        this.bookId = bookId;
        this.title = title;
        this.authorId = authorId;
    }

    public String getBookId() {
        return bookId;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthorId() {
        return authorId;
    }
}
