package syed.spring.app.spring6webapp.repositories;

import org.springframework.data.repository.CrudRepository;
import syed.spring.app.spring6webapp.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
