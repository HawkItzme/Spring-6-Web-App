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

        Book abc = new Book();
        abc.setTitle("Abc");
        abc.setIsbn("12345");

        Author johnSaved = authorRepository.save(john);
        Book abcSaved = bookRepository.save(abc);

        Author don = new Author();
        don.setFirstName("Don");
        don.setLastName("Mark");

        Book xyz = new Book();
        xyz.setTitle("Xyz");
        xyz.setIsbn("6789");

        Author donSaved = authorRepository.save(don);
        Book xyzSaved = bookRepository.save(xyz);

        johnSaved.getBooks().add(abcSaved);
        donSaved.getBooks().add(xyzSaved);
        abcSaved.getAuthors().add(johnSaved);
        xyzSaved.getAuthors().add(donSaved);

        Publisher spingy = new Publisher();
        spingy.setAddress("Da Vinci Town");
        spingy.setCity("Grapevine");
        spingy.setState("Texas");
        spingy.setZip("777");
        spingy.setPublisherName("Spinach");
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
