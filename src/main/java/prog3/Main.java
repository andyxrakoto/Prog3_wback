package prog3;

import CRUD.*;

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
        try (Connection connection = DriverManager.getConnection("JDBC_URL", "JDBC_USER",
                "JDBC_PASSWORD")) {

            BookCrudOperations bookCrudOperations = new BookCrudOperations(connection);
            List<Book> booksToSave = Arrays.asList(
                    new Book(123, "Title1", 1),
                    new Book(456, "Title2", 2)
            );


            bookCrudOperations.saveAll(booksToSave);


            List<Book> allBooks = bookCrudOperations.findAll();
            logger.info("All Books: {}", allBooks);


            Book updatedBook = new Book(123, "UpdatedTitle", 1);
            bookCrudOperations.save(updatedBook);


            List<Book> updatedBooks = bookCrudOperations.findAll();
            logger.info("Updated Books: {}", updatedBooks);


            bookCrudOperations.delete(updatedBook);


            List<Book> remainingBooks = bookCrudOperations.findAll();
            logger.info("Remaining Books: {}", remainingBooks);

        } catch (SQLException e) {
            logger.error("FETCHING ERROR", e);
        }
    }
}
