
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory{
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            DriverManager.getConnection("jdbc:mysql://localhost/amigo", "root", "");
			
        } catch (SQLException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        return null;
    }
}