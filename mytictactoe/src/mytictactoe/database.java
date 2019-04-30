package projectwork;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
public class database {
    static boolean flag_delete;
    static boolean flag_update;
    public database()
    {
        /*try{
        String myUrl = "jdbc:derby://localhost:1527/Admin";
        Connection conn = DriverManager.getConnection(myUrl,"myra", "123");
        System.out.println("Connected database successfully...");
        }catch(SQLException se)
        {
             se.printStackTrace();
        }*/
    }
   public static void Insert(String First,String Last,String USer,String email,String pass)
   {
       
   try{
     Connection con=connect.getconnection();
      System.out.println("Inserting records into the table...");
      PreparedStatement st = con.prepareStatement("INSERT INTO SIGNUP(FIRSTNAME,LASTNAME,USERNAME,EMAIL,PASSWORD)VALUES('"+First+"','"+Last+"','"+USer+"','"+email+"','"+pass+"')");
      
      
      int a=st.executeUpdate();
      if(a>0)
      System.out.println("Inserted records into the table...");

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");

 
   }
   public static boolean CHECK(String USer,String pass)
   {
       Connection conn = null;
       PreparedStatement st = null;
       ResultSet rs;
   try{
       String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
        String sql = "Select USERNAME,PASSWORD FROM SIGNUP WHERE USERNAME='"+USer+"' and PASSWORD='"+pass+"'   ";
     
      System.out.println("SEARCHING record into the table...");
       st = conn.prepareStatement(sql);
      
      
      rs=st.executeQuery();
      int c=0;
      while(rs.next())
      {
          c=c+1;
      }
      if(c==1)
      {
        System.out.println(" record found in the table...");
        flag_delete= true;
      }
      else
      {
          System.out.println("record is not found!!");
         flag_delete= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_delete==true)
       return true;
       else
           return false;
   }

 public static void Insert1(String id,String name,String address,String founder,String date,String p,String project)
   {
       Connection con =null;
       PreparedStatement st =null;
   try{
        String myUrl = "jdbc:derby://localhost:1527/Admin";
        con = DriverManager.getConnection(myUrl,"myra", "123");
        System.out.println("Connected database successfully...");
        System.out.println("Inserting records into the table...");
        st = con.prepareStatement("INSERT INTO ORGANIZATION_TABLE(OID,NAME,ADDRESS,FOUNDER,FOUNDED_DATE,PHONE_NUMBER,NO_OF_PROJECTS)VALUES('"+id+"','"+name+"','"+address+"','"+founder+"','"+date+"','"+p+"','"+project+"')");     
          int a=st.executeUpdate();
        if(a>0)
        System.out.println("Inserted records into the table...");
        else
           System.out.println("records cannot be inserted into the table...");

     }catch(SQLException se){
        se.printStackTrace();
   }
   
      System.out.println("Goodbye!");
   }
 
 public static ResultSet Select() throws SQLException
   {
      Connection conn = null;
      Statement stmt = null;
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");

      System.out.println("Creating statement...");
      stmt = conn.createStatement();
      String sql;
      sql = "SELECT * FROM ORGANIZATION_TABLE";
      ResultSet rs = stmt.executeQuery(sql);

      return rs;
        
    }

public static boolean delete(String id){
      
       Connection conn = null;
       PreparedStatement st = null;
       
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql = "DELETE FROM ORGANIZATION_TABLE WHERE OID = '"+id+"' ";
     
      System.out.println("deleting records into the table...");
       st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("delete records into the table...");
      flag_delete= true;
      }
      else
      {
          System.out.println("record is not found!!");
         flag_delete= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_delete==true)
       return true;
       else
           return false;
   }
public static boolean update_adress(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET ADDRESS='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}
public static boolean update_date(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET FOUNDED_DATE='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}

public static boolean update_founder(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET FOUNDER='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}
public static boolean update_name(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET NAME='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}
public static boolean update_phone(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET PHONE_NUMBER='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}
public static boolean update_project(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/Admin";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      String sql ="UPDATE ORGANIZATION_TABLE SET NO_OF_PROJECTS='"+update+"' WHERE OID = '"+id+"'";
     
      System.out.println("updating records into the table...");
      st = conn.prepareStatement(sql);
      
      
      int a=st.executeUpdate();
      if(a>0)
      {
      System.out.println("update records into the table...");
      flag_update= true;
      }
      else
      {
          System.out.println("ID is not found!!");
         flag_update= false;
      }

   }catch(SQLException se){
      se.printStackTrace();
   }
   System.out.println("Goodbye!");
       if(flag_update==true)
       return true;
       else
           return false;
}
public void insertDonors(String a, long b, long c, String d){
        String name=a;
        long cnic=b;
        long contacNumber=c;
        String email=d;
        try {
           Connection con=connect.getconnection();
            PreparedStatement add=con.prepareStatement("insert into MYRA.DONORS values (?,?,?,?)");
            add.setString(1,name);
            add.setLong(2,cnic);
            add.setLong(3,contacNumber);
            add.setString(4,email);
            add.execute();
           
            
        } catch (SQLException ex) {
            Logger.getLogger(manageDonors.class.getName()).log(Level.SEVERE, null, ex);
        }




}
}

