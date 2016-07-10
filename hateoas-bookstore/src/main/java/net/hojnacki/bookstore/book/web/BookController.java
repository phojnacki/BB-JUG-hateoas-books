package net.hojnacki.bookstore.book.web;

import net.hojnacki.bookstore.book.BookRepository;
import net.hojnacki.bookstore.book.BookResource;
import net.hojnacki.bookstore.book.BookResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
public class BookController {

    @Autowired
    BookRepository bookRepository;

    @Autowired
    BookResourceAssembler bookResourceAssembeler;

    @RequestMapping(value = "/books", method = RequestMethod.GET)
    public HttpEntity<Collection<BookResource>> getAllBooks() {
        Collection<BookResource> bookResources = bookResourceAssembeler.toResources(bookRepository.getAll());
        return new ResponseEntity(bookResources, HttpStatus.OK);
    }

    @RequestMapping(value = "/books/{id}", method = RequestMethod.GET)
    public HttpEntity<BookResource> getBook(@PathVariable String id) {
        BookResource bookResource = bookResourceAssembeler.toResource(bookRepository.getBook(id));
        return new ResponseEntity (bookResource, HttpStatus.OK);
    }

}
