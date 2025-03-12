package syed.spring.app.spring6webapp.services;

import syed.spring.app.spring6webapp.domain.Book;

public interface BookService {

    Iterable<Book> findAll();
}
