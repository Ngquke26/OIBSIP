
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
public class Question3 extends JFrame{
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
    
    public Question3(){
        super("Question 3");
        
        titlePanel = new JPanel();
        lblTitle = new JLabel("QUESTION 3");
        
        bodyPanel = new JPanel();
        lblQuestion = new JLabel("3. Which one is defined as a doing word?");
        group = new ButtonGroup();
        
        option1 = new JRadioButton("noun");
        group.add(option1);
        option2 = new JRadioButton("verb");
        group.add(option2);
        option3 = new JRadioButton("adverb");
        group.add(option3);
        option4 = new JRadioButton("adjective");
        group.add(option4);
        
        buttons = new JPanel();
        btnBackTracking = new JButton("BACK");
        btnFowardTracking = new JButton("NEXT");
        
        btnBackTracking.addActionListener(e->{
           Question2 two = new Question2();
                    two.setVisible(true);
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
                
                   ExamData.answers[2] = answer;  
                
                Question4 four = new Question4();
                    four.setVisible(true);
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
        
      
        
        buttons.add(btnBackTracking);
        buttons.add(btnFowardTracking);
        
       this.add(QuizTimer.timerLabel, BorderLayout.WEST);
        
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
