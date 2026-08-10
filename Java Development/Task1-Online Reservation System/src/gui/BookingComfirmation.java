
package za.ac.cput.onlinereservationsystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import javax.swing.SwingUtilities;

/**
 *
 * @Athini Ngquke
 */
public class BookingComfirmation extends JFrame{
    
    
    private JPanel formPanel;
    
    private JLabel lblPassengerName;
  
    
    private JLabel lblTrainNumber;
   
    
    private JLabel lblTrainName;
   
    
    private JLabel lblClassType;
   
    
    private JLabel lblDate;
  
    
    private JLabel lblSource;
   
    
    private JLabel lblDestination;
   
     
    private JPanel buttonPanel;
    private JButton btnCancel; 
    
    public BookingComfirmation(String customer, String trainNumber, String trainName,String type,String date,String source,String destination){
        super("Booking comfirmation");
       
        
        formPanel = new JPanel();
        
        lblPassengerName = new JLabel("Passenger name:"+customer);
        
        
        lblTrainNumber = new JLabel("Train number:"+trainNumber);
        
        
        lblTrainName = new JLabel("Train name:"+trainName);
        

        lblClassType = new JLabel("Class type"+type);
       
    
        lblDate = new JLabel("Date of journey:"+date);
        
        
        lblSource = new JLabel("Source station:"+source);
        
        
        lblDestination = new JLabel("Destination station:"+destination);
        buttonPanel = new JPanel();
        btnCancel = new JButton("CANCEL BOOKING");
        
        btnCancel.addActionListener(e->{
            
            
            new CancellationForm().setVisible(true);
            ((JFrame) SwingUtilities.getWindowAncestor(btnCancel)).dispose();
        });
        
       
       
        formPanel.setLayout(new GridLayout(7,2));
        buttonPanel.setLayout(new FlowLayout()); 

       
        formPanel.add(lblPassengerName);
        
        formPanel.add(lblTrainNumber);
      
        formPanel.add(lblTrainName);
      
        formPanel.add(lblClassType);
       
        formPanel.add(lblDate);
       
        formPanel.add(lblSource);
      
        formPanel.add(lblDestination);
        
        
        buttonPanel.add(btnCancel);
        
       add(formPanel, BorderLayout.NORTH);
        add(buttonPanel, BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000, 1000);
        setVisible(true);
        pack();
        
    }

    
    
}
