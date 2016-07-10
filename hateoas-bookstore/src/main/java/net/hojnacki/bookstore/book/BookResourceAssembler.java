package net.hojnacki.bookstore.book;

import net.hojnacki.bookstore.author.web.AuthorController;
import net.hojnacki.bookstore.book.web.BookController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.hateoas.*;
import org.springframework.hateoas.mvc.BasicLinkBuilder;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import static org.springframework.web.util.UriComponentsBuilder.fromUriString;

@Service
public class BookResourceAssembler extends ResourceAssemblerSupport<Book, BookResource> {

    @Autowired
    private DiscoveryClient discoveryClient;

    public BookResourceAssembler() {
        super(BookController.class, BookResource.class);
    }

    public BookResource toResource(Book book) {
        BookResource result = instantiateResource(book);
        result.setBookId(book.getBookId());
        result.setAuthorId(book.getAuthorId());
        result.setTitle(book.getTitle());

        // {"self": {"href" : "http://localhost:8080/books/1"}}
        result.add(linkTo(methodOn(BookController.class).getBook(book.getBookId())).withSelfRel());

        // {"author": {"href" : "http://localhost:8080/authors/1"}}
        result.add(linkTo(methodOn(AuthorController.class).getAuthor(book.getAuthorId())).withRel("author"));

        // {"order": {"href" : "http://przemeck:9090/books/1/order"}}
        URI orderServiceUrl = discoveryClient.getInstances("OrderService").get(0).getUri();
        result.add(new Link(orderServiceUrl + "/books/"+book.getBookId()+"/order", "order"));
        return result;
    }

}

