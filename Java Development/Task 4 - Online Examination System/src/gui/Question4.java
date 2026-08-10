/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.onlineexaminationsystem.gui;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.SwingUtilities;
import za.ac.cput.onlineexaminationsystem.domain.ExamData;
import za.ac.cput.onlineexaminationsystem.domain.QuizTimer;


/**
 *
 * @author PC
 */
public class Question4 extends JFrame {
    private JPanel titlePanel;
    private JLabel lblTitle;
    
    private JPanel bodyPanel;
    private JLabel lblQuestion;
    private ButtonGroup group;
    private JRadioButton option1;
    private JRadioButton option2;
    private JRadioButton option3;
    private JRadioButton option4;
    
    private JPanel buttons;
    private JButton btnBackTracking;
    private JButton btnFowardTracking;
    
    public Question4(){
        super("Question4");
        
        titlePanel = new JPanel();
        lblTitle = new JLabel("QUESTION 4");
        
        bodyPanel = new JPanel();
        lblQuestion = new JLabel("4. Who was the first black president?");
        group = new ButtonGroup();
        
        option1 = new JRadioButton("Thabo Mbeki");
        group.add(option1);
        option2 = new JRadioButton("Jacob Zuma");
        group.add(option2);
        option3 = new JRadioButton("Cyril Ramaphosa");
        group.add(option3);
        option4 = new JRadioButton("Nelson Mandela");
        group.add(option4);
        
        buttons = new JPanel();
        btnBackTracking = new JButton("BACK");
        btnFowardTracking = new JButton("NEXT");
        
        btnBackTracking.addActionListener(e->{
            
            Question3 three = new Question3();
                    three.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnBackTracking)).dispose();  
        });
        btnFowardTracking.addActionListener(e->{
            String answer = null;
            if (option1.isSelected()) {
                answer = option1.getText();
            } else if (option2.isSelected()) {
                answer = option2.getText();
            } else if (option3.isSelected()) {
                answer = option3.getText();
            } else if (option4.isSelected()) {
                answer = option4.getText();
            }

            // Show or save the answer
            if (answer != null) {
                
              
             ExamData.answers[3] = answer;
                
                Question5 five = new Question5();
                    five.setVisible(true);
                    ((JFrame) SwingUtilities.getWindowAncestor(btnFowardTracking)).dispose(); 
            } else {
                JOptionPane.showMessageDialog(this, "No option selected!");
            }
           
             
        });
        
        this.setLayout(new BorderLayout());
        titlePanel.setLayout(new FlowLayout());
        bodyPanel.setLayout(new GridLayout(5,1));
        buttons.setLayout(new FlowLayout());
        titlePanel.add(lblTitle);
        
        bodyPanel.add(lblQuestion);
        bodyPanel.add(option1);
        bodyPanel.add(option2);
        bodyPanel.add(option3);
        bodyPanel.add(option4);
        
      this.add(QuizTimer.timerLabel, BorderLayout.WEST);
        
        buttons.add(btnBackTracking);
        buttons.add(btnFowardTracking);
        
       
        
        this.add(titlePanel,BorderLayout.NORTH);
        this.add(bodyPanel,BorderLayout.CENTER);
        this.add(buttons,BorderLayout.SOUTH);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setSize(1000,1000);
        this.setVisible(true);
        this.pack();
        
    }
    
}
