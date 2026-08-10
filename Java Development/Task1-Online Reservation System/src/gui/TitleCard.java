/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author PC
 */
public class TitleCard extends JFrame{
    private JFrame titleFrame;
    
    private JPanel panelFields;
    
    private JLabel lblName;
    private JLabel txtName;
    
    private JLabel lblTrack;
    private JLabel txtTrack;
    
    private JLabel lblTask;
     private JLabel txtTask;
     
    private JPanel panelButton;
    private JButton btnStart;
    
    public TitleCard(){
        super("Title Card");
        
        titleFrame = new JFrame();
        
        panelFields = new JPanel();
        
        lblName = new JLabel("FULL NAME:");
        txtName = new JLabel("ATHINI NGQUKE");
        
        lblTrack = new JLabel ("ASSIGNED TRACK:");
        txtTrack = new JLabel("JAVA DEVELOPMENT");
        
        lblTask = new JLabel ("TASK NAME:");
        txtTask = new JLabel ("TASK 1- ONLINE RESERVATION SYSTEM");
        
        panelButton = new JPanel();
        btnStart = new JButton("START");
        
        btnStart.addActionListener(e->{
             LoginForm form = new LoginForm();
                    form.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnStart)).dispose();
        });
        
    titleFrame.setLayout(new BorderLayout());
    panelFields.setLayout(new GridLayout(3,2));
    panelButton.setLayout(new FlowLayout());
    
    
    panelFields.add(lblName);
    panelFields.add(txtName);
    panelFields.add(lblTrack);
    panelFields.add(txtTrack);
    panelFields.add(lblTask);
    panelFields.add(txtTask);
    
    panelButton.add(btnStart);
    
    
    titleFrame.add(panelFields, BorderLayout.NORTH); 
    titleFrame.add( panelButton,BorderLayout.SOUTH);
        
        titleFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        titleFrame.setLocationRelativeTo(null);
        titleFrame.setSize(1000,1000);
        titleFrame.setVisible(true);
        titleFrame.pack();
}
    public static void main(String[]args){
        new TitleCard();
    }
}
