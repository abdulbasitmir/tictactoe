/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mytictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import static mytictactoe.database.flag_update;

/**
 *
 * @author Dell
 */
public class controller {
    int playerWin;
    int x,y;
    void setposition(int a, int b){
         Model obj=new Model();
         obj.updateboard(x, y);
    
    
    }
    
    void setPlayerWin(int a){
        playerWin=a;
    
    }
    
    
    public static boolean update_adress(String id,String update){   
       Connection conn = null;
       PreparedStatement st = null;
   try{
      String myUrl = "jdbc:derby://localhost:1527/record";
      conn = DriverManager.getConnection(myUrl,"myra", "123");
      System.out.println("Connected database successfully...");
      
      
      String sql = "Select Player 1 wins FROM record WHERE userId= '"+playerWin+"'";
       st = conn.prepareStatement(sql);
       
       if(playerwin==1){
       st.(player_1_wins)++;
     
       String sql ="UPDATE record SET playe 2 wins='"+update+"' WHERE UserId = '"+playerWin+"'";
       }
       else{
           st = conn.prepareStatement(sql);
       
       if(playerwin==1){
       st.(player_2_wins)++;
     
       String sql ="UPDATE record SET playe 2 wins='"+update+"' WHERE UserId = '"+playerWin+"'";
       
       }
  
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
    public static void main(String[] args) {
        
    }
   
    
    
}
