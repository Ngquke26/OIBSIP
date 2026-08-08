
package za.ac.cput.onlinereservationsystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import za.ac.cput.onlinereservationsystem.dao.ReservationDAO;
import za.ac.cput.onlinereservationsystem.domain.PassengerReservation;

/**
 *
 * @Athini Ngquke
 */
public class CancellationForm extends JFrame{
    private JFrame fourthFrame;
    
    private JPanel searchPanel;
    
    private JLabel lblPNR;
    private JTextField txtPNR;
    private JButton btnFetch;
    
    private JPanel retrievePanel;
    private JLabel lblPassengerName;
    private JTextField txtPassengerName;
    
    private JLabel lblTrainNumber;
    private JTextField txtTrainNumber;
    
    private JLabel lblTrainName;
    private JTextField txtTrainName;
    
    private JLabel lblClassType;
    private JTextField txtClassType;
    
    private JLabel lblDate;
    private JTextField txtDate;
    
    private JLabel lblSource;
    private JTextField txtSource;
    
    private JLabel lblDestination;
    private JTextField txtDestination;
    
    private JPanel questionPanel;
    private JButton btnQuestion;
    
    public CancellationForm(){
        super("Cancellation form");
        
        fourthFrame = new JFrame();
        
        searchPanel = new JPanel();
        
        lblPNR = new JLabel("Enter PNR number:");
        txtPNR = new JTextField(2);
       btnFetch = new JButton("FETCH");
       
       retrievePanel = new JPanel();
        lblPassengerName = new JLabel("Passenger name:");
        txtPassengerName = new JTextField(2);
        
        lblTrainNumber = new JLabel("Train number:");
        txtTrainNumber = new JTextField(2);
        
        lblTrainName = new JLabel("Train name:");
        txtTrainName = new JTextField(2);

        lblClassType = new JLabel("Class type");
        txtClassType = new JTextField(2);
    
        lblDate = new JLabel("Date of journey:");
        txtDate = new JTextField(2);
        
        lblSource = new JLabel("Source station:");
        txtSource = new JTextField(2);
        
        lblDestination = new JLabel("Destination station:");
        txtDestination = new JTextField(2);
        
        questionPanel = new JPanel();
        btnQuestion = new JButton("ARE YOU SURE?");
        
        btnFetch.addActionListener(e -> {
            try {
               String passengerName = txtPassengerName.getText().trim();
                if (passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter pnr to search.");
                    return;
                }
                 //int pnr = Integer.parseInt(pnrText);
                 
                ReservationDAO dao = new ReservationDAO();
                PassengerReservation res = dao.retrieveReservationByPassengerName(passengerName);
                
                if (res != null) {
                    //txtPassengerName.setText(res.getPassengerName());
                    txtTrainNumber.setText(res.getTrainNumber());
                    txtTrainName.setText(res.getTrainName());
                    txtClassType.setText(res.getClassType());
                    txtDate.setText(res.getJourneyDate());
                    txtSource.setText(res.getSource());
                    txtDestination.setText(res.getDestination());
                } else {
                    JOptionPane.showMessageDialog(null, "No reservation found for PNR " + passengerName);
                }
             
            } catch(SQLException ex) {
               // Logger.getLogger(CancellationForm.class.getName()).log(Level.SEVERE, null, ex);
                  JOptionPane.showMessageDialog(null, "Error fetching the reservation " +ex.getMessage());
            }
        });
        
        btnQuestion.addActionListener(e -> {
            try {
               String passengerName = txtPassengerName.getText().trim();
                if (passengerName.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Enter pnr to search.");
                    return;
                }
               
    
        ReservationDAO dao = new ReservationDAO();
        boolean deleted = dao.deleteReservationByPassengerName(passengerName);

        if (deleted) {
            JOptionPane.showMessageDialog(null, "Reservation for " + passengerName + " removed!");
          
            txtPNR.setText("");
            txtPassengerName.setText("");
            txtTrainNumber.setText("");
            txtTrainName.setText("");
            txtClassType.setText("");
            txtDate.setText("");
            txtSource.setText("");
            txtDestination.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "No reservation found for " + passengerName);
        }
    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Error cancelling reservation: " + ex.getMessage());
    }
});
         fourthFrame.setLayout(new BorderLayout());
       
        searchPanel.setLayout(new GridLayout(1,3));
        retrievePanel.setLayout(new GridLayout(7,2));
        questionPanel.setLayout(new FlowLayout()); 

        searchPanel.add(lblPNR);
        searchPanel.add(txtPNR);
        searchPanel.add(btnFetch);
       
        retrievePanel.add(lblPassengerName);
        retrievePanel.add(txtPassengerName);
        retrievePanel.add(lblTrainNumber);
        retrievePanel.add(txtTrainNumber);
        retrievePanel.add(lblTrainName);
        retrievePanel.add(txtTrainName);
        retrievePanel.add(lblClassType);
        retrievePanel.add(txtClassType);
        retrievePanel.add(lblDate);
        retrievePanel.add(txtDate);
        retrievePanel.add(lblSource);
        retrievePanel.add(txtSource);
        retrievePanel.add(lblDestination);
        retrievePanel.add(txtDestination);
        
        
        questionPanel.add(btnQuestion);
        
        fourthFrame.add(searchPanel, BorderLayout.NORTH);
        fourthFrame.add(questionPanel, BorderLayout.SOUTH);
        fourthFrame.add(retrievePanel, BorderLayout.CENTER);

        fourthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        fourthFrame.setLocationRelativeTo(null);
        fourthFrame.setSize(1000, 1000);
        fourthFrame.setVisible(true);
        fourthFrame.pack();
        
}
   
    }
        
