package net.hojnacki.bookstore.author.web;

import net.hojnacki.bookstore.author.AuthorRepository;
import net.hojnacki.bookstore.author.AuthorResource;
import net.hojnacki.bookstore.author.AuthorResourceAssembler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@CrossOrigin
public class AuthorController {

    @Autowired
    AuthorRepository authorRepository;

    @Autowired
    AuthorResourceAssembler authorResourceAssembler;

    @RequestMapping(value = "/authors", method = RequestMethod.GET)
    public HttpEntity<Collection<AuthorResource>> getAllAuthors() {
        Collection<AuthorResource> authorResources = authorResourceAssembler.toResources(authorRepository.getAll());
        return new ResponseEntity(authorResources, HttpStatus.OK);
    }

    @RequestMapping(value = "/authors/{id}", method = RequestMethod.GET)
    public HttpEntity<AuthorResource> getAuthor(@PathVariable String id) {
        AuthorResource bookResource = authorResourceAssembler.toResource(authorRepository.getAuthor(id));
        return new ResponseEntity (bookResource, HttpStatus.OK);
    }

}
