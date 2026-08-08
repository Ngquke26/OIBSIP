
package za.ac.cput.onlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author PC
 */
public class TrainDAO {
    private Connection con;
    
    public TrainDAO(){
         try{
             
        String dURL = "jdbc:derby://localhost:1527/TrainReservation;create=true";
        String username = "athiningquke";
        String password = "passwordAN";
            
         con = DriverManager.getConnection(dURL, username, password);
         
        }catch(SQLException ex){
            JOptionPane.showMessageDialog(null,"Connection failed!"+ex.getMessage());
        return ; 
        }
    }
    public void createTrain(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "CREATE TABLE Train (TRAINNUMBER VARCHAR(10) PRIMARY KEY,TRAINNAME VARCHAR(40))";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
          pstmt.executeUpdate();
      }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error creating table"+ex.getMessage());  
      }
    }
   
    public void insertTrain(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "INSERT INTO Train (TRAINNUMBER, TRAINNAME) VALUES (?,?)";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1,"12345");
            pstmt.setString(2,"Gau Train");
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Information saved successfully");
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error saving setup"+ex.getMessage());
        }
   }
    public String getTrainNameByNumber(String trainNumber) {
    String trainName = null;
    String sql = "SELECT TRAINNAME FROM Train WHERE TRAINNUMBER = ?";
    try (
         PreparedStatement ps = con.prepareStatement(sql)){
        ps.setString(1, trainNumber);
        ResultSet rs = ps.executeQuery();
        if (rs.next()) {
            trainName = rs.getString("TRAINNAME");
        }
    } catch (SQLException ex) {
        ex.printStackTrace();
    }
    return trainName;
}
    
}
