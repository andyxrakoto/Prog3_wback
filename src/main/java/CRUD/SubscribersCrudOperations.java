package CRUD;

import Model.Subscribers;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SubscribersCrudOperations implements CrudOperations<Subscribers> {
    private final Connection connection;

    public SubscribersCrudOperations(Connection connection) {
        this.connection = connection;
    }

    @Override
    public List<Subscribers> findAll() {
        List<Subscribers> subscribersList = new ArrayList<>();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM subscribers")) {

            while (resultSet.next()) {
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                Subscribers subscriber = new Subscribers(name, email);
                subscribersList.add(subscriber);
            }
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return subscribersList;
    }

    @Override
    public List<Subscribers> saveAll(List<Subscribers> toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subscribers VALUES (?, ?)")) {

            for (Subscribers subscriber : toSave) {
                preparedStatement.setString(1, subscriber.getName());
                preparedStatement.setString(2, subscriber.getEmail());
                preparedStatement.addBatch();
            }

            preparedStatement.executeBatch();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toSave;
    }

    @Override
    public Subscribers save(Subscribers toSave) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO subscribers VALUES (?, ?)")) {
            preparedStatement.setString(1, toSave.getName());
            preparedStatement.setString(2, toSave.getEmail());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toSave;
    }

    @Override
    public Subscribers delete(Subscribers toDelete) {
        try (PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM subscribers WHERE name = ?")) {
            preparedStatement.setString(1, toDelete.getName());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("ERROR");
        }

        return toDelete;
    }
}
