package projectwork;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 *
 * @author Dell
 */
public class connect {
    public static Connection getconnection(){
        Connection con = null ;
       try{
        String myUrl = "jdbc:derby://localhost:1527/record";
      con = DriverManager.getConnection(myUrl,"", "");
      System.out.println("Connected database successfully...");
       }catch(Exception se)
       {
           System.out.println(se);
       }
       return con;
    }
}
