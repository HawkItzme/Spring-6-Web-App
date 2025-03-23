package syed.spring.app.spring6webapp.services;

import syed.spring.app.spring6webapp.domain.Author;
import syed.spring.app.spring6webapp.domain.Book;

public interface AuthorService {

    Iterable<Author> findAll();
}
