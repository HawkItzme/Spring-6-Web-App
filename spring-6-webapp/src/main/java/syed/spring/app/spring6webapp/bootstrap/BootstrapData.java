package syed.spring.app.spring6webapp.bootstrap;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import syed.spring.app.spring6webapp.domain.Author;
import syed.spring.app.spring6webapp.domain.Book;
import syed.spring.app.spring6webapp.domain.Publisher;
import syed.spring.app.spring6webapp.repositories.AuthorRepository;
import syed.spring.app.spring6webapp.repositories.BookRepository;
import syed.spring.app.spring6webapp.repositories.PublisherRepository;

@Component
public class BootstrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootstrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Author john = new Author();
        john.setFirstName("John");
        john.setLastName("Smith");
        Author johnSaved = authorRepository.save(john);

        Book abc = new Book();
        abc.setTitle("Abc");
        abc.setIsbn("12345");
        Book abcSaved = bookRepository.save(abc);

        Author don = new Author();
        john.setFirstName("Don");
        john.setLastName("Mark");
        Author donSaved = authorRepository.save(don);

        Book xyz = new Book();
        abc.setTitle("Xyz");
        abc.setIsbn("6789");
        Book xyzSaved = bookRepository.save(xyz);

        johnSaved.getBooks().add(abcSaved);
        donSaved.getBooks().add(xyzSaved);

        Publisher spingy = new Publisher();
        spingy.setAddress("Da Vinci Town");
        spingy.setCity("Grapevine");
        spingy.setState("Texas");
        spingy.setZip("777");
        Publisher spingySaved = publisherRepository.save(spingy);

        abcSaved.setPublisher(spingySaved);
        xyzSaved.setPublisher(spingySaved);

        authorRepository.save(johnSaved);
        authorRepository.save(donSaved);
        bookRepository.save(abcSaved);
        bookRepository.save(xyzSaved);


        System.out.println("In Bootstrap : ");
        System.out.println("Author Count: " + authorRepository.count());
        System.out.println("Book Count: " + bookRepository.count());
        System.out.println("Publisher Count: " + publisherRepository.count());

    }
}
