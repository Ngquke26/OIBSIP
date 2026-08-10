/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.cput.onlineexaminationsystem.gui;

import java.awt.BorderLayout;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;

import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import za.ac.cput.onlineexaminationsystem.domain.ExamData;
import za.ac.cput.onlineexaminationsystem.domain.QuizTimer;


/**
 *
 * @author PC
 */
public class Results extends JFrame{
    private JTextArea resultsArea;
    private JScrollPane scrollPane;
    private JButton btnLogout;
    public Results() {
        super("Quiz Results");

        resultsArea = new JTextArea(15, 40);
        resultsArea.setEditable(false);

           int score = 0;
        int timeTaken = ExamData.totalTime - QuizTimer.timeLeft;

        resultsArea.append("Score: " + score + " out of " + ExamData.totalQuestions + "\n");
        resultsArea.append("Time taken: " + timeTaken + " seconds\n\n");

        for (int i = 0; i < ExamData.totalQuestions; i++) {
            if (ExamData.answers[i] != null &&
                ExamData.answers[i].equals(ExamData.correctAnswers[i])) {
                score++;
                resultsArea.append("Question " + (i + 1) + ": Correct\n");
            } else {
                resultsArea.append("Question " + (i + 1) + ": Incorrect");
                resultsArea.append(" | Your answer: " + ExamData.answers[i]);
                resultsArea.append(" | Correct answer: " + ExamData.correctAnswers[i] + "\n");
            }
        }

        resultsArea.setText("");
        resultsArea.append("Score: " + score + " out of " + ExamData.totalQuestions + "\n");
        resultsArea.append("Time taken: " + timeTaken + " seconds\n\n");

        for (int i = 0; i < ExamData.totalQuestions; i++) {
            if (ExamData.answers[i] != null &&
                ExamData.answers[i].equals(ExamData.correctAnswers[i])) {
                resultsArea.append("Question " + (i + 1) + ": Correct\n");
            } else {
                resultsArea.append("Question " + (i + 1) + ": Incorrect");
                resultsArea.append(" | Your answer: " + ExamData.answers[i]);
                resultsArea.append(" | Correct answer: " + ExamData.correctAnswers[i] + "\n");
            }
        }

        btnLogout = new JButton("LOGOUT");
        btnLogout.addActionListener(e -> {
            new LoginForm();
            dispose();
        });


        this.setLayout(new BorderLayout());
        this.add(new JScrollPane(resultsArea), BorderLayout.CENTER);
        this.add(btnLogout,BorderLayout.SOUTH);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.pack();
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }    
}
