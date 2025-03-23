package syed.spring.app.spring6webapp.services;

import org.springframework.stereotype.Service;
import syed.spring.app.spring6webapp.domain.Author;
import syed.spring.app.spring6webapp.domain.Book;
import syed.spring.app.spring6webapp.repositories.AuthorRepository;
import syed.spring.app.spring6webapp.repositories.BookRepository;

@Service
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    public AuthorServiceImpl(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @Override
    public Iterable<Author> findAll() {
        return authorRepository.findAll();
    }
}
