package net.hojnacki.bookstore.book;

import lombok.Data;
import org.springframework.hateoas.ResourceSupport;

@Data
public class BookResource extends ResourceSupport {

    private String bookId;
    private String title;
    private String authorId;

}
