package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.Repositories.AuthorRepository;
import guru.springframework.spring5webapp.Repositories.BookRepository;
import guru.springframework.spring5webapp.Repositories.PublisherRepository;
import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent> {
    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;

    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    public void initData(){
            //Ibrahim
        Publisher publisher1 = new Publisher("Stuart Kime", "184 Clarewood Street");
        publisherRepository.save(publisher1);

        Author ibrahim = new Author("Ibrahim", "Elsanosi");
            Book java = new Book("Introduction to Java", "Spring", publisher1);
            ibrahim.getBooks().add(java);
            java.getAuthors().add(ibrahim);

            authorRepository.save(ibrahim);
            bookRepository.save(java);


        //Ibrahim
        Author aisha = new Author("Aisha", "Ahmed");
        Publisher publisher2 = new Publisher("Rob Coe", "94 Ancrum Street");
        Book python = new Book("Introduction to Python", "Newcastle University", publisher2);
        aisha.getBooks().add(python);
        python.getAuthors().add(aisha);

        publisherRepository.save(publisher2);
        authorRepository.save(aisha);
        bookRepository.save(python);

    }
}
