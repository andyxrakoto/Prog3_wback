package prog3;
import CRUD.*;

import Model.Subscribers;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class Main {
    private static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection("jdbc:postgresql://localhost:5432/library_management", "prog_admin", "123456")) {
            // Test de BookCrudOperations
            BookCrudOperations bookCrudOperations = new BookCrudOperations(connection);
            List<Book> booksToSave = Arrays.asList(
                    new Book(12, "Title1", "Author1"),
                    new Book(15, "Title2", "Author2")
            );

            bookCrudOperations.saveAll(booksToSave);

            List<Book> allBooks = bookCrudOperations.findAll();
            logger.info("All Books: {}", allBooks);


            Book updatedBook = new Book(123, "UpdatedTitle", "UpdatedAuthor");
            bookCrudOperations.save(updatedBook);


            List<Book> updatedBooks = bookCrudOperations.findAll();
            logger.info("Updated Books: {}", updatedBooks);

            // Delete a book
            bookCrudOperations.delete(updatedBook);


            List<Book> remainingBooks = bookCrudOperations.findAll();
            logger.info("Remaining Books: {}", remainingBooks);


            AuthorCrudOperations authorCrudOperations = new AuthorCrudOperations(connection);
            List<Author> authorsToSave = Arrays.asList(
                    new Author("Author1"),
                    new Author("Author2")
            );


            authorCrudOperations.saveAll(authorsToSave);


            List<Author> allAuthors = authorCrudOperations.findAll();
            logger.info("All Authors: {}", allAuthors);


            Author updatedAuthor = new Author("Author1Updated");
            authorCrudOperations.save(updatedAuthor);


            List<Author> updatedAuthors = authorCrudOperations.findAll();
            logger.info("Updated Authors: {}", updatedAuthors);


            authorCrudOperations.delete(updatedAuthor);


            List<Author> remainingAuthors = authorCrudOperations.findAll();
            logger.info("Remaining Authors: {}", remainingAuthors);

            // Test de SubscribersCrudOperations
            SubscribersCrudOperations subscribersCrudOperations = new SubscribersCrudOperations(connection);
            List<Subscribers> subscribersToSave = Arrays.asList(
                    new Subscribers("Subscriber1", "subscriber1@example.com"),
                    new Subscribers("Subscriber2", "subscriber2@example.com")
            );


            subscribersCrudOperations.saveAll(subscribersToSave);


            List<Subscribers> allSubscribers = subscribersCrudOperations.findAll();
            logger.info("All Subscribers: {}", allSubscribers);


            Subscribers updatedSubscriber = new Subscribers("Subscriber1Updated", "subscriber1updated@example.com");
            subscribersCrudOperations.save(updatedSubscriber);


            List<Subscribers> updatedSubscribers = subscribersCrudOperations.findAll();
            logger.info("Updated Subscribers: {}", updatedSubscribers);


            subscribersCrudOperations.delete(updatedSubscriber);


            List<Subscribers> remainingSubscribers = subscribersCrudOperations.findAll();
            logger.info("Remaining Subscribers: {}", remainingSubscribers);

        } catch (SQLException e) {
            logger.error("ERROR WHILE FETCHING", e);
        }
    }
}
