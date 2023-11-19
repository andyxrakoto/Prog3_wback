package CRUD;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AuthorCrudOperations implements CrudOperations<Author> {
    private final Connection connection;

    public AuthorCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Author> findAll() {
        List<Author> authors = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM author")) {

            while (resultSet.next()) {
                String authorName = resultSet.getString("author_name");

                Author author = new Author(authorName);
                authors.add(author);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return authors;
    }

    @Override
    public List<Author> saveAll(List<Author> toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author VALUES (?)")) {

            for (Author author : toSave) {
                preparedStatement.setString(1, author.getAuthorName());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toSave;
    }

    @Override
    public Author save(Author toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO author VALUES (?)")) {
            preparedStatement.setString(1, toSave.getAuthorName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toSave;
    }

    @Override
    public Author delete(Author toDelete) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM author WHERE name = ?")) {
            preparedStatement.setString(1, toDelete.getAuthorName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toDelete;
    }
}
