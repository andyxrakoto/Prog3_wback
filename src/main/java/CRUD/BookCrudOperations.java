package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookCrudOperations implements CrudOperations<Book> {
    private final Connection connection;

    public BookCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM book")) {

            while (resultSet.next()) {
                int isbn = resultSet.getInt("isbn");
                String title = resultSet.getString("title");
                String author = resultSet.getString("author");

                Book book = new Book(isbn, title, author);
                books.add(book);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return books;
    }

    @Override
    public List<Book> saveAll(List<Book> toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?)")) {

            for (Book book : toSave) {
                preparedStatement.setInt(1, book.getIsbn());
                preparedStatement.setString(2, book.getTitle());
                preparedStatement.setString(3, book.getAuthor());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            throw new RuntimeException("ERROR WHILE EXECUTING THE SQL COMMAND", e);
        }

        return toSave;
    }

    @Override
    public Book save(Book toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO book VALUES (?, ?, ?)")) {
            preparedStatement.setInt(1, toSave.getIsbn());
            preparedStatement.setString(2, toSave.getTitle());
            preparedStatement.setString(3, toSave.getAuthor());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toSave;
    }

    @Override
    public Book delete(Book toDelete) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM book WHERE id = ?")) {
            preparedStatement.setInt(1, toDelete.getIsbn());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toDelete;
    }
}
