
package za.ac.cput.onlinereservationsystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import za.ac.cput.onlinereservationsystem.dao.TrainDAO;

/**
 *
 * @author PC
 */
public class LoginForm extends JFrame{
    private JFrame mainFrame;
    
    private JPanel fieldPanel;
    
    private JLabel lblUsername;
    private JTextField txtUsername;
    
    private JLabel lblPassword;
    private JTextField txtPassword;
    
    private JPanel buttonPanel;
    private JButton btnLogin;
    
    
    public LoginForm(){
        super("Login");
        
        mainFrame = new JFrame();
        
        fieldPanel = new JPanel();
        
        lblUsername = new JLabel("Username:");
        txtUsername = new JTextField(2);
        
        lblPassword = new JLabel("Password:");
        txtPassword = new JTextField(2);
        
        buttonPanel = new JPanel();
        btnLogin = new JButton("LOGIN");
        
        btnLogin.addActionListener(e->{
          try{
                String username = txtUsername.getText().trim();
                String password = txtPassword.getText().trim();
        
                if(!username.isEmpty()&& !password.isEmpty()  ){
                    JOptionPane.showMessageDialog(null, "Login Successful!");
                    
                    ReservationForm reservation = new ReservationForm();
                    reservation.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnLogin)).dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!Please try again");
                }
            
            
            }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Exception:"+ex.getMessage());
                    
            }
            
        });
          mainFrame.setLayout(new BorderLayout());
       
        fieldPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setLayout(new FlowLayout()); 

       
        fieldPanel.add(lblUsername);
        fieldPanel.add(txtUsername);
        fieldPanel.add(lblPassword);
        fieldPanel.add(txtPassword);
        
        buttonPanel.add(btnLogin);
        
        mainFrame.add(fieldPanel,BorderLayout.NORTH);
        mainFrame.add( buttonPanel,BorderLayout.SOUTH);
        
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setSize(1000,1000);
        mainFrame.setVisible(true);
        mainFrame.pack();
    }
        public static void main(String []args){
            new LoginForm();
           
        }
       
    }

