package prog3;

import java.sql.Connection;
import java.sql.DriverManager;

public class Main {
    public static void main(String[] args) throws Exception {
        String jdbcUrl = System.getenv("JDBC_URL");
        String jdbcUser = System.getenv("JDBC_USER");
        String jdbcPassword = System.getenv("JDBC_PASSWORD");

        Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        if (!connection.isClosed()) {
            System.out.println("Connection established");
        } else {
            System.out.println("Connection denied");
        }
    }
}
