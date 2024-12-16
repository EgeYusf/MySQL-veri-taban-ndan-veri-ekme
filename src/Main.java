import java.sql.Connection;  // veri tabanına bağlanmaya yarar.
import java.sql.ResultSet;  // SQL sorgularının veritabanı ile yapılmış sorgulardan dönen sonuçlarını temsil eder.
import java.sql.SQLException;  // veritabanına bağlanma sırasında meydana gelen hataları fırlatmaya yarar.
import java.sql.Statement;  // SQL sorgularını kullanıp döndürmemize yarar.

public class Main {
    public static void main(String[] args) {
        Connection connection = null;  // daha bağlantı sağlanmadığından null atadık.
        dbHelper helper = new dbHelper();  // veri tabanına bağlanmak adına dbHelper adında nesne oluşturduk , bu nesne üzerinde veri tabanına bağlantı gerçekleştiriceğiz.
        Statement statement = null; // aynı şekilde burada ve altta da.
        ResultSet resultSet = null;

        try {
            // Veritabanı bağlantısı oluşturuluyor
            connection = helper.getConnection();  // Eğer başarılı bir şekilde bağlanırsa catche girmez ve hata fırlatmaz.
            statement = connection.createStatement();  // Connection nesnesi üzerinden statement oluşturuyoruz ki sql sorgusu yazabilelim.

            // SQL sorgusu çalıştırılıyor
            resultSet = statement.executeQuery("SELECT * FROM stok");  // resultSete atıyoruz

            // Sonuçlar işleniyor
            while (resultSet.next()) {
                System.out.println("Ürün Id: " + resultSet.getString("Urun_id"));
                System.out.println("Ürün Kategorisi: " + resultSet.getString("Urun_kategorisi"));
                System.out.println("Ürün Adı: " + resultSet.getString("Urun_adı"));
                System.out.println("Ürün Fiyatı: " + resultSet.getString("Urun_fiyatı"));
                System.out.println("Ürün Stoğu: " + resultSet.getString("Urun_stoku"));

            }
        } catch (SQLException e) {
            // Hata mesajları işleniyor
            helper.showErrorMessage(e);
        } finally {
            // Kaynakların kapatılması
            try {
                if (resultSet != null) resultSet.close();
                if (statement != null) statement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                System.out.println("Kaynakları kapatma hatası: " + e.getMessage());
            }
        }
    }
}

