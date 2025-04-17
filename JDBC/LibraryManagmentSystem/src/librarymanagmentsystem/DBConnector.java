package librarymanagmentsystem;
import java.sql.*;

public class DBConnector {
    private Connection connection ;
    public DBConnector(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/sampledb";
            String uname = "root";
            String pwd = ""; 
            connection = DriverManager.getConnection(url, uname, pwd);
        }catch(ClassNotFoundException |SQLException e){
            e.printStackTrace();
        }
    }
    public Connection getConnection(){
        return connection;
    }
    public void closeConnection(){
        try{
            if(connection != null && !connection.isClosed()){
                connection.close();
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
