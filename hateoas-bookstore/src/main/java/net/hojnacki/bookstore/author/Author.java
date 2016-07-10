package net.hojnacki.bookstore.author;

public class Author {

    public String authorId;
    public String firstName;
    public String secondName;


    public Author(String authorId, String firstName, String secondName) {
        this.authorId = authorId;
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public String getAuthorId() {
        return authorId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSecondName() {
        return secondName;
    }
}
