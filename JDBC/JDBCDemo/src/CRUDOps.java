import java.sql.*;

public class CRUDOps {
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
        
        //4. create table
        //String cq = "create table student(sid int primary key, sname varchar(20), cgpa float)";
        //int x = st.executeUpdate(cq); //returns 0 if succcess
        //if(x >= 0){
        //    System.out.println("Table Created");
        //}else{
        //    System.out.println("Table Not Created Due To Technical Issue");
        //}
        
        //4. CRUD Operations
        //insert
        String ig = "insert into student values(1, 'Siddhi', 9.20),(2, 'Kavya', 9.8),(3, 'Khushboo', 9.8)";
        int x = st.executeUpdate(ig);
        if(x > 0){
            System.out.println(x + " record(s) inserted");
        }
        //update
        String uq ="update student set sname ='Jeni' where sid = 2";
        int y = st.executeUpdate(uq);
        if(y > 0){
            System.out.println(y + " record(s) updated");
        }
        
        //delete
        String dq = "delete from student where sid = 3";
        int z = st.executeUpdate(dq);
        if(z > 0){
            System.out.println(z + " record(s) deleted");
        }
        //retrive/read
        ResultSet rs = st.executeQuery("select * from student");
        System.out.println("Student details");

        while(rs.next()){
            System.out.println(rs.getInt("sid") + " " + rs.getString("sname") + " " + rs.getDouble(3));
        }
        //5. close connection
        con.close();
    }
}
