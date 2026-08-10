
package za.ac.cput.onlineexaminationsystem.gui;

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

/**
 *
 * @author PC
 */
public class LoginForm extends JFrame{
  
    
    private JPanel fieldPanel;
    
    private JLabel lblUsername;
    private JTextField txtUsername;
    
    private JLabel lblPassword;
    private JTextField txtPassword;
    
    private JPanel buttonPanel;
    private JButton btnLogin;
    
    
    public LoginForm(){
        super("Login");
        
       
        
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
                    
                    ProfileManagement profile = new ProfileManagement(username,password);
                    profile.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnLogin)).dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!Please try again");
                }
            
            
            }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Exception:"+ex.getMessage());
                    
            }
            
        });
          setLayout(new BorderLayout());
       
        fieldPanel.setLayout(new GridLayout(2,2));
        buttonPanel.setLayout(new FlowLayout()); 

       
        fieldPanel.add(lblUsername);
        fieldPanel.add(txtUsername);
        fieldPanel.add(lblPassword);
        fieldPanel.add(txtPassword);
        
        buttonPanel.add(btnLogin);
        
        add(fieldPanel,BorderLayout.NORTH);
        add( buttonPanel,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000,1000);
        setVisible(true);
        pack();
    }
       
       
    }

