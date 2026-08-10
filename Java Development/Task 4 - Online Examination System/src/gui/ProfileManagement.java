/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
public class ProfileManagement extends JFrame {
    private JPanel fieldPanel;
    
    private JLabel oldUsername;
    private JTextField txtOld;
    
    private JLabel newUsername;
    private JTextField txtNew;
   
    private JLabel oldPassword;
    private JTextField txtOldPassword;
    
    private JLabel newPassword;
    private JTextField txtNewPassword;
    
    private JPanel btnPanel;
    private JButton btnChange;
    
    public ProfileManagement(String username, String password){
        super("Profile");
        
        fieldPanel = new JPanel();
        oldUsername = new JLabel("Old username:");
        txtOld = new JTextField(username);
                
        newUsername = new JLabel("New username:");
        txtNew = new JTextField(2);
        
        oldPassword = new JLabel("Old password:");
        txtOldPassword = new JTextField(password);
        
        newPassword = new JLabel("New password:");
        txtNewPassword = new JTextField(2);
        
        btnPanel = new JPanel();
        btnChange = new JButton("Change");
        
        btnChange.addActionListener(e->{
            try{
                String newUsername = txtNew.getText().trim();
                String newPassword = txtNewPassword.getText().trim();
        
                if(!newUsername.isEmpty()&& !newPassword.isEmpty()  ){
                    JOptionPane.showMessageDialog(null, "Profile updated Successful!");
                    
                    Question1 one = new Question1();
                    one.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnChange)).dispose();
                    
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid credentials!Please try again");
                }
            
            
            }catch(Exception ex){
               JOptionPane.showMessageDialog(null,"Exception:"+ex.getMessage());
                    
            }
            
           
        });
        
        setLayout(new BorderLayout());
        fieldPanel.setLayout(new GridLayout(4,2));
        btnPanel.setLayout(new FlowLayout());
        
        fieldPanel.add(oldUsername);
        fieldPanel.add(txtOld);
        
        fieldPanel.add(newUsername);
        fieldPanel.add(txtNew);
        
        fieldPanel.add(oldPassword);
        fieldPanel.add(txtOldPassword);
        
        fieldPanel.add(newPassword);
        fieldPanel.add(txtNewPassword);
        
        btnPanel.add(btnChange);
        
        add(fieldPanel,BorderLayout.NORTH);
        add(btnPanel,BorderLayout.SOUTH);
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setSize(1000,1000);
        setVisible(true);
        pack();
        
        
                
    
    }   
    
}
