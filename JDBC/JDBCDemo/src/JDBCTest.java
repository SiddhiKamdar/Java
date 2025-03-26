//JDBC API
//java.sql and/or javax.sql;
import java.sql.*;

public class JDBCTest {
    public static void main(String[] args) throws Exception {
        //1. loading drivers
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        //2. establising the connection
        String url = "jdbc:mysql://localhost:3306/sampledb";
        String uname = "root";
        String pwd = "";
        
        Connection con = DriverManager.getConnection(url, uname, pwd);
        
        if(con != null){
             System.out.println("Connection Established");
        }else{
             System.out.println("Connection Failed ._.");
        }
               
        //3. Create Statement
        Statement st = con.createStatement();
        
        //4. executing queries
        String query = "select * from account";
        ResultSet rs = st.executeQuery(query);
        
        //process result 
        while(rs.next()){
            System.out.println(rs.getInt(1)+ " " + rs.getDouble(2) + " " + rs.getString(3));
        }
        
        //5. close connection
        con.close();
    }
}
