package prog3;

import org.springframework.context.annotation.Configuration;

import java.sql.Connection;
import java.sql.DriverManager;

@Configuration
public class Main {
    public static void main(String[] args) throws Exception {

        System.setProperty("JDBC_URL", "jdbc:postgresql://localhost:5432/library_management");
        System.setProperty("JDBC_USER", "prog_admin");
        System.setProperty("JDBC_PASSWORD", "123456");

        Connection connection = DriverManager.getConnection(
                System.getProperty("JDBC_URL"),
                System.getProperty("JDBC_USER"),
                System.getProperty("JDBC_PASSWORD")
        );

        if (!connection.isClosed()) {
            System.out.println("Connection established");
        } else {
            System.out.println("Connection denied");
        }
    }
}
