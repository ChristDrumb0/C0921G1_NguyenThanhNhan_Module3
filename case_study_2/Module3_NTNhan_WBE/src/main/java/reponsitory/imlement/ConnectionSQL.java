package reponsitory.imlement;

import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQL {
    private String jdbcURL = "jdbc:mysql://localhost:3306/casestudy_2";
    private String jdbcUsername = "root";
    private String jdbcPassword = "NhanhoMn@ylaso1";
    private static java.sql.Connection connection;

    public ConnectionSQL() {

    }

    public java.sql.Connection getConnection() {
        connection = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static void close() {
        try {
            if (connection != null) {
                connection.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
