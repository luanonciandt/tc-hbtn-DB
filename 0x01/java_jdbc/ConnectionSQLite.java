import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSQLite {

    static Connection connection;

    public static void main(String[] args) {
        initConnection();
    }

    public static void initConnection() {
        try {
            connection = DriverManager.getConnection("jdbc:sqlite:0x01/java_jdbc/sqlite_database_2022.db");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
