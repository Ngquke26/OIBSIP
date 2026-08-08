
package za.ac.cput.onlinereservationsystem.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import za.ac.cput.onlinereservationsystem.domain.PassengerReservation;
import za.ac.cput.onlinereservationsystem.domain.TrainDomain;

/**
 *
 * @author PC
 */
public class ReservationDAO {
    private Connection con;
    
    public ReservationDAO() {
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
    public void createReservation(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "CREATE TABLE Reservation (PNR INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,PASSENGERNAME VARCHAR(40),TRAINNUMBER VARCHAR(10), TRAINNAME VARCHAR(40), CLASSTYPE VARCHAR(2),DATE VARCHAR(10),SOURCE VARCHAR(40), DESTINATION VARCHAR(40) )";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
          pstmt.executeUpdate();
      }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error creating table"+ex.getMessage());  
      }
    }
   
  public int insertReservation(String passengerName, String trainNumber, String trainName,
                             String classType, String date, String source, String destination) {
    int pnr = -1;
    String sql = "INSERT INTO Reservation (PASSENGERNAME, TRAINNUMBER, TRAINNAME,CLASSTYPE, DATE, SOURCE, DESTINATION) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, passengerName);
        pstmt.setString(2, trainNumber);
        pstmt.setString(3, trainName);
        pstmt.setString(4, classType);
        pstmt.setString(5, date);
        pstmt.setString(6, source);
        pstmt.setString(7, destination);

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            pnr = rs.getInt(1); // Derby-generated PNR
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error saving reservation: " + ex.getMessage());
    }
    return pnr;
} 
  public PassengerReservation retrieveReservationByPassengerName(String passengerName) throws SQLException {
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Database connection not established");
        return null;
    }

    String sql = "SELECT TRAINNUMBER, TRAINNAME, CLASSTYPE, DATE, SOURCE, DESTINATION " +
                 "FROM Reservation WHERE PASSENGERNAME = ?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, passengerName);  // use setString for names

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Build a Reservation object with the data
            PassengerReservation res = new PassengerReservation(
                passengerName,                        // include the passenger name
                rs.getString("TRAINNUMBER"),
                rs.getString("TRAINNAME"),
                rs.getString("CLASSTYPE"),
                rs.getString("DATE"),
                rs.getString("SOURCE"),
                rs.getString("DESTINATION")
            );
            return res;
        }
    }
    return null; // not found
}
  
  public boolean deleteReservationByPassengerName(String passengerName) throws SQLException {
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Database connection not established");
        return false;
    }

    String sql = "DELETE FROM Reservation WHERE PASSENGERNAME = ?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, passengerName);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; // true if a record was deleted
    }
}
  public void insertValues(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "Insert into Train (TRAINNAME,TRAINNUMBER) values(?,?)";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
            
            pstmt.setString(1,"9000");
            pstmt.setString(2,"Metrorail");
            
            pstmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Information saved successfully");
        }catch(SQLException ex){
             JOptionPane.showMessageDialog(null,"Error saving setup"+ex.getMessage());
        }
   } 
  public TrainDomain retrieveTrainNameByTrainNumber(String trainNumber) throws SQLException {
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Database connection not established");
        return null;
    }

    String sql = "SELECT TRAINNAME FROM Train WHERE TrainNumber = ?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setString(1, trainNumber);  // use setString for names

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Build a Reservation object with the data
            TrainDomain in = new TrainDomain(
                trainNumber,                        // include the passenger name
                rs.getString("TRAINNAME") 
            );
            return in;
        }
    }
    return null;
  }
    /*
  //new changes
     public void createReservation(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "Create table Reservationss (Pnr INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY,Passenger_name, VARCHAR(40),Train_Number VARCHAR(8),Train_Number VARCHAR(20),Class_type VARCHAR(40),Journey_date VARCHAR(10), Source VARCHAR(40),Destination VARCHAR(40))";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
          pstmt.executeUpdate();
      }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error creating table"+ex.getMessage());  
      }
    }
     /*
public void createReservation(){
      if(con == null){
             JOptionPane.showMessageDialog(null,"Database Connection not established"); 
           return;
        }
      String sql = "CREATE TABLE Reservationss ("+"PNR INT PRIMARY KEY GENERATED ALWAYS AS IDENTITY ,"+"PASSENGERNAME VARCHAR(40),"+"TRAINNUMBER VARCHAR(10),"+" TRAINNAME VARCHAR(40),"+" CLASSTYPE VARCHAR(2),"+"JOURNEYDATE VARCHAR(10),"+"SOURCE VARCHAR(40),"+" DESTINATION VARCHAR(40) )";
      try(
              PreparedStatement pstmt = con.prepareStatement(sql)){
          pstmt.executeUpdate();
      }catch(SQLException ex){
        JOptionPane.showMessageDialog(null,"Error creating table"+ex.getMessage());  
      }
    }
public int insertReservation(String passengerName, String trainNumber, String trainName,
                             String classType, String date, String source, String destination) {
    int pnr = 0;
    String sql = "INSERT INTO Reservationss (PASSENGERNAME, TRAINNUMBER, TRAINNAME,CLASSTYPE, JOURNEYDATE, SOURCE, DESTINATION) VALUES (?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement pstmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
        pstmt.setString(1, passengerName);
        pstmt.setString(2, trainNumber);
        pstmt.setString(3, trainName);
        pstmt.setString(4, classType);
        pstmt.setString(5, date);
        pstmt.setString(6, source);
        pstmt.setString(7, destination);

        pstmt.executeUpdate();

        ResultSet rs = pstmt.getGeneratedKeys();
        if (rs.next()) {
            pnr = rs.getInt(1); // Derby-generated PNR
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error saving reservation: " + ex.getMessage());
    }
    return pnr;
}
public PassengerReservation retrieveReservationByPNR(int pnr) throws SQLException {
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Database connection not established");
        return null;
    }

    String sql = "SELECT PASSENGERNAME, TRAINNUMBER, TRAINNAME, CLASSTYPE,JOURNEYDATE, SOURCE, DESTINATION " +
                 "FROM Reservationss WHERE PNR = ?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setInt(1, pnr);  // use setString for names

        ResultSet rs = pstmt.executeQuery();
        if (rs.next()) {
            // Build a Reservation object with the data
            return new PassengerReservation(
                rs.getString("PASSENGERNAME"),                        // include the passenger name
                rs.getString("TRAINNUMBER"),
                rs.getString("TRAINNAME"),
                rs.getString("CLASSTYPE"),
                rs.getString("JOURNEYDATE"),
                rs.getString("SOURCE"),
                rs.getString("DESTINATION")
            );
           
        }
    }
    return null; // not found
}
public boolean deleteReservationByPNR(int pnr) throws SQLException {
    if (con == null) {
        JOptionPane.showMessageDialog(null, "Database connection not established");
        return false;
    }

    String sql = "DELETE FROM Reservationss WHERE PNR = ?";
    try (PreparedStatement pstmt = con.prepareStatement(sql)) {
        pstmt.setInt(1, pnr);
        int rowsAffected = pstmt.executeUpdate();
        return rowsAffected > 0; // true if a record was deleted
    }
}*/
public static void main(String[]args){
    ReservationDAO dao = new ReservationDAO();
    dao.createReservation();
    dao.insertValues();
}
}
