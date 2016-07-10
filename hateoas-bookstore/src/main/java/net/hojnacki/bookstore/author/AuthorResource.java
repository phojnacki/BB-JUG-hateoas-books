package net.hojnacki.bookstore.author;

import org.springframework.hateoas.ResourceSupport;

public class AuthorResource extends ResourceSupport {

    public String authorId;
    public String firstName;
    public String secondName;

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
}
