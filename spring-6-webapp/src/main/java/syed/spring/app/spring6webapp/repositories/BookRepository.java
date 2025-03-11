package syed.spring.app.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import syed.spring.app.spring6webapp.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
