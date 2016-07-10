package net.hojnacki.bookstore.author;

import net.hojnacki.bookstore.author.web.AuthorController;
import net.hojnacki.bookstore.book.web.BookController;
import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@Service
public class AuthorResourceAssembler extends ResourceAssemblerSupport<Author, AuthorResource> {

    public AuthorResourceAssembler() {
        super(AuthorController.class, AuthorResource.class);
    }

    public AuthorResource toResource(Author author) {
        AuthorResource result = instantiateResource(author);
        result.setAuthorId(author.getAuthorId());
        result.setFirstName(author.getFirstName());
        result.setSecondName(author.getSecondName());
        result.add(linkTo(methodOn(AuthorController.class).getAuthor(author.getAuthorId())).withSelfRel());
        return result;
    }

}

