
package za.ac.cput.numberguessinggame;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @Athini Ngquke
 */
public class GuessingGame {
    public static void main(String []args){
        System.out.println("FULL NAME:ATHINI NGQUKE");
        System.out.println("ASSIGNED TRACK: JAVA DEVELOPMENT");
        System.out.println("TASK 2 - NUMBER GUESSING GAME");
        
        
        Random rand = new Random();
        Scanner input = new Scanner(System.in);
        
        ArrayList <String> roundSummary = new ArrayList();
        int roundNumber = 1;
        boolean playAgain = true;
        
        while(playAgain){
            System.out.println("Round:"+roundNumber);
            System.out.println("Choose difficulty:");
            System.out.println("1.Easy(1-50, 10 attempts)");
            System.out.println("2.Medium(1-100, 7 attempts");
            System.out.println("3.Hard(1-200, 5 attempts");
            System.out.println("Please enter your choice:");
            int choice = input.nextInt();
            
            int maxNumber;
            int maxAttempts;
            
            if (choice == 1) {
                maxNumber = 50;
                maxAttempts = 10;
            } else if (choice == 2) {
                maxNumber = 100;
                maxAttempts = 7;
            } else if (choice == 3) {
                maxNumber = 200;
                maxAttempts = 5;
            } else {
                System.out.println("Invalid choice. Defaulting to Medium.");
                maxNumber = 100;
                maxAttempts = 7;
            }
           int randomNumber = rand.nextInt(maxNumber) + 1;
            boolean guessedCorrectly = false;
            int attemptsUsed = 0;

            for (int i = 1; i <= maxAttempts; i++) {
                attemptsUsed = i;
                System.out.print("Attempt " + i + " of " + maxAttempts + ": Guess a random number: ");
               
            int userInput = input.nextInt();
            if (userInput == randomNumber) {
                System.out.println("CORRECT");
                guessedCorrectly = true;
                break;
            } else if (userInput > randomNumber) {
                System.out.println("TOO HIGH");
            } else {
                System.out.println("TOO LOW");
            }

        }
            if(!guessedCorrectly ){
            System.out.println("YOU LOST");
        System.out.println("The correct number was:" + randomNumber);
        roundSummary.add("Round " + roundNumber + " — Lost after " + attemptsUsed + " attempts");
            } else {
                roundSummary.add("Round " + roundNumber + " — guessed in " + attemptsUsed + " attempts");
        }
            
       System.out.println("Play again(yes/no):");
       String response = input.next();
       
       if(!response.equalsIgnoreCase("yes")){
           playAgain = false;
       }
    roundNumber++;
    System.out.println();
}
        System.out.println("End of the game");
        for(String summary:roundSummary){
            System.out.println(summary);
    }
        input.close();
}
}

