
package za.ac.cput.onlinereservationsystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import za.ac.cput.onlinereservationsystem.dao.TrainDAO;
import za.ac.cput.onlinereservationsystem.domain.TrainDomain;

/**
 *
 * @Athini Ngquke
 */
public class ReservationForm extends JFrame{
    private JFrame secondFrame;
    
    
    
    private JPanel formPanel;
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
     
    private JPanel buttonPanel;
    private JButton btnBook; 
    
    
    public ReservationForm(){
        super("Reservation Form");
        secondFrame = new JFrame();
        
        formPanel = new JPanel();
        
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
        
        buttonPanel = new JPanel();
        btnBook = new JButton("BOOK");
        
        
        txtTrainNumber.addActionListener(e -> {
            try {
                ReservationDAO in = new ReservationDAO();
                String trainNumber = txtTrainNumber.getText();
                TrainDomain train = in.retrieveTrainNameByTrainNumber(trainNumber);
                if(train != null){
                    txtTrainName.setText(train.getTrainName());
                }else{
                    
                }txtTrainName.setText("MetroRail");
               // txtTrainName.setText(trainName != null ? trainName : "Not found");
            
            
        }   catch (SQLException ex) {
                Logger.getLogger(ReservationForm.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        
         btnBook.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String customer = txtPassengerName.getText().trim();
                String trainNumber = txtTrainNumber.getText().trim();
                String trainName = txtTrainName.getText().trim();//automatic population
                String type = txtClassType.getText().trim();
                String date = txtDate.getText().trim();
                String source = txtSource.getText().trim();
                String destination = txtDestination.getText().trim();
                
                
        
                if(!customer.isEmpty() && !trainNumber.isEmpty() && !trainName.isEmpty()&& !type.isEmpty() && !date.isEmpty()&&!source.isEmpty()&& !destination.isEmpty() ){
                   
                    
                 ReservationDAO reservation = new ReservationDAO();
                 int pnr = reservation.insertReservation(customer, trainNumber, trainName, type, date, source, destination);
                 JOptionPane.showMessageDialog(null, "PNR:"+pnr);
                 
                    BookingComfirmation booking =  new BookingComfirmation(customer, trainNumber, trainName, type, date, source, destination);
                    booking.setVisible(true);
                    secondFrame.dispose();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid !Please fill all the details");
                }
            }
        });
         secondFrame.setLayout(new BorderLayout());
       
        formPanel.setLayout(new GridLayout(7,2));
        buttonPanel.setLayout(new FlowLayout()); 

       
        formPanel.add(lblPassengerName);
        formPanel.add(txtPassengerName);
        formPanel.add(lblTrainNumber);
        formPanel.add(txtTrainNumber);
        formPanel.add(lblTrainName);
        formPanel.add(txtTrainName);
        formPanel.add(lblClassType);
        formPanel.add(txtClassType);
        formPanel.add(lblDate);
        formPanel.add(txtDate);
        formPanel.add(lblSource);
        formPanel.add(txtSource);
        formPanel.add(lblDestination);
        formPanel.add(txtDestination);
        
        buttonPanel.add(btnBook);
        
        secondFrame.add(formPanel,BorderLayout.NORTH);
       secondFrame.add( buttonPanel,BorderLayout.SOUTH);
        
        secondFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        secondFrame.setLocationRelativeTo(null);
       secondFrame.setSize(1000,1000);
        secondFrame.setVisible(true);
        secondFrame.pack();
       
    }
    
   
}
