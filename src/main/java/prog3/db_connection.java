package prog3;

import java.sql.DriverManager;

public class db_connection {
    public static void main(String[] args) throws Exception {
        String jdbcUrl = System.getenv("JDBC_URL");
        String jdbcUser = System.getenv("JDBC_USER");
        String jdbcPassword = System.getenv("JDBC_PASSWORD");

        java.sql.Connection connection = DriverManager.getConnection(jdbcUrl, jdbcUser, jdbcPassword);

        if (!connection.isClosed()) {
            System.out.println("Connection established");
        } else {
            System.out.println("Connection denied");
        }
    }
}
