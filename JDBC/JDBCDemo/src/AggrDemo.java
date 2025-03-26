//Aggregate functions - JDBC
import java.sql.*;
public class AggrDemo {
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
        
        //4. Execute Query and Process the result
        String query = "select count(*), min(cgpa), max(cgpa), avg(cgpa), sum(cgpa) from student";
       
        ResultSet rs = st.executeQuery(query);
        
        while(rs.next()){
            System.out.println("Count of records:"+ rs.getInt(1));
            System.out.println("Min CGPA:"+rs.getDouble(2));
            System.out.println("Max CGPA:"+rs.getDouble(3));
            System.out.println("Avergae CGPA:"+rs.getDouble(4));
            System.out.println("Sum of all CGPAs:"+rs.getDouble(5));
        }
    }
}
