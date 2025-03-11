package syed.spring.app.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import syed.spring.app.spring6webapp.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
