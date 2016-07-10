package net.hojnacki.bookstore.author;

import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class AuthorRepository {

    private static Map<String, Author> authors = new HashMap<>();

    public AuthorRepository() {
        Author uncleBob = new Author("1", "Uncle", "Bob");
        Author samNewman = new Author("2", "Sam", "Newman");
        authors.put(uncleBob.getAuthorId(), uncleBob);
        authors.put(samNewman.getAuthorId(), samNewman);
    }

    public Collection<Author> getAll() {
        return authors.values();
    }

    public Author getAuthor(String id) {
        return authors.get(id);
    }
}
