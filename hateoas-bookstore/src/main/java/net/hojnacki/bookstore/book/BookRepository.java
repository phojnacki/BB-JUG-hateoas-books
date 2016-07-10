package net.hojnacki.bookstore.book;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class BookRepository {

    private static Map<String, Book> books = new HashMap<>();

    public BookRepository() {
        Book cleanCodeBook = new Book("1", "Clean Code", "1");
        Book buildingMicroServicesBook = new Book("2", "Building Microservices", "2");
        books.put(cleanCodeBook.getBookId(), cleanCodeBook);
        books.put(buildingMicroServicesBook.getBookId(), buildingMicroServicesBook);
    }

    public Collection<Book> getAll() {
        return books.values();
    }

    public Book getBook(String id) {
        return books.get(id);
    }
}
