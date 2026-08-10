
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
public class Question1 extends JFrame {
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
    private JButton btnFowardTracking;
    
    public Question1(){
        super("Question1");
        
        titlePanel = new JPanel();
        lblTitle = new JLabel("QUESTION 1");
        
        bodyPanel = new JPanel();
        lblQuestion = new JLabel("1. What is the answer of 1+1 ?");
        group = new ButtonGroup();
        
        option1 = new JRadioButton("2");
        group.add(option1);
        option2 = new JRadioButton("3");
        group.add(option2);
        option3 = new JRadioButton("4");
        group.add(option3);
        option4 = new JRadioButton("1");
        group.add(option4);
        
        buttons = new JPanel();
        btnFowardTracking = new JButton("NEXT");
        
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
                if (answer!= null){
                    ExamData.answers[0] = answer;
                 Question2 two = new Question2();
                    two.setVisible(true);
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
        
        buttons.add(btnFowardTracking);
        
        this.add(QuizTimer.timerLabel, BorderLayout.WEST);
        QuizTimer.startTimer(this);
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
