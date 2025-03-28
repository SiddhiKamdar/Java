import java.sql.*;
import java.util.Scanner;
public class CSTDemo {
    public static void main(String[] args) throws Exception { 
        Scanner in = new Scanner(System.in);
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/sampledb";
        String uname ="root";
        String pwd ="";
        Connection con = DriverManager.getConnection(url,uname,pwd);
        if(con != null){
            System.out.println("Connection established!");
        }
        else{
            System.out.println("Connection Failed");
        }

        // String query = "{call first_proc1(?,?)}"; // calling sp
        
        //Calling sf
        String query = "{? = call add_ab(?,?)}";
        CallableStatement cst = con.prepareCall(query);
        
        System.out.println("Enter two input values");
        System.out.println("First input value");
        int a = in.nextInt();
        System.out.println("Second input value");
        int b = in.nextInt();
        
        cst.setInt(2,a); 
        cst.setInt(3,b); 
        cst.registerOutParameter(1, Types.INTEGER);
        
        cst.execute(); // executing the sf/sp
        
        int result = cst.getInt(1); // 
        System.out.println("Sum : "+result);
       
}
}

/* Stored Procedure
DELIMITER $$

CREATE PROCEDURE first_pro(IN a INT, OUT b INT)
BEGIN
    SET b = a * a;
END $$

DELIMITER ;
*/

/*   Stored Function
DELIMITER $$

CREATE FUNCTION add_ab(a INT, b INT) 
RETURNS INT DETERMINISTIC
BEGIN
    DECLARE c INT;
    SET c = a + b;
    RETURN c;
END $$

DELIMITER ;
*/
