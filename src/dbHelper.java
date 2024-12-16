import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbHelper {
    private String userName = "root";
    private String password = "dikili138139";
    private String dbUrl = "jdbc:mysql://localhost:3306/test"; // Veri tabanı adınız "demo" olarak ayarlanmış

    // Bağlantı oluşturma metodu
    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(dbUrl, userName, password);
    }

    // Hata mesajı gösterme metodu
    public void showErrorMessage(SQLException exception) {
        System.out.println("Error: " + exception.getMessage());
        System.out.println("Error Code: " + exception.getErrorCode());
    }
}

