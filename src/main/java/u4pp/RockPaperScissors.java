package u4pp;

/**
* JAVADOC HERE
*/
import java.util.Scanner;

public class RockPaperScissors {

    /* any code you need here for part b */

    /**
     * JAVADOC HERE
     */
    public static void play(Scanner sc) {
        System.out.println("Welcome to Rock Paper Scissors");
        int w = 0;
        int l = 0;
        int t = 0;

        boolean keepPlaying = true;
        while (keepPlaying==true){
            int result = noog(sc);
            
            if (result == 1){
                w += 1;
            }
            else if (result == 0){
                t += 1;
            }
            else{
                l += 1;
            }
            System.out.println("You have " + w + " wins and " + l + " losses and " + t + " ties");
            keepPlaying = getYesOrNoInput(sc, "Would you like to play again? (Y)es or (N)o: ");
        }
        
    }

    /**
     * JAVADOC HERE
     */
    public static int results(String playerChoice, String computerChoice) {
        playerChoice = playerChoice.toLowerCase();
        computerChoice = computerChoice.toLowerCase();
        if(playerChoice.equals(computerChoice)){
            return 0;
        }
        if((playerChoice.equals("r")) && (computerChoice.equals("s")) || (playerChoice.equals("p")) && (computerChoice.equals("r")) || (playerChoice.equals("s")) && (computerChoice.equals("p"))){
            return 1;
        }
        else{
            return -1;
        }
    }

    /* 
     * Helper methods for part b
     * These should be private static methods that help organize your code
     * 
     * Recommended helper methods:
     * 1. getRandomChoice() - returns a random "r", "p", or "s"
     * 2. getPlayerChoice(Scanner sc) - prompts user and returns valid R/P/S/A input
     * 3. getYesNoInput(Scanner sc, String prompt) - prompts user and returns true/false for Y/N
     * 4. playRound(Scanner sc, int[] scores) - handles one complete round of RPS
     * 5. formatChoice(String choice) - converts "r" to "Rock", "p" to "Paper", etc.
     */

private static String k(){
    int q = (int)(Math.random() * 3);
    if (q == 0){
        return "r";
    }
    else if (q == 1){
        return "p";
    }
    else{
        return "s";
    }
}

private static String person(Scanner sc){
    while (true){
        System.out.print("Would you like to pick (R)ock, (P)aper, (S)cissors, or (A)ny: ");
        String h = sc.nextLine().toLowerCase();
        if((h.equals("r")) || (h.equals("p")) || (h.equals("s")) || (h.equals("a"))){
            return h;
        }
        else{
            System.out.println("Invalid input, please try again");
        }
    }
}

private static int noog(Scanner sc){
    String playerChoice = person(sc);
    if (playerChoice.equals("a")){
        playerChoice = k();
    }
    String computerChoice = k();
    int e = results(playerChoice, computerChoice);
    if (e==0){
        System.out.println("You both picked" + formatChoice(playerChoice) + ". It's a tie!");
    }
    else if ( e == 1){
        System.out.println("You picked" + formatChoice(playerChoice) + ". and the Computer picked " + formatChoice(computerChoice) + ". You win!");
    }
    else{
        System.out.println("You picked" + formatChoice(playerChoice) + ". and the Computer picked " + formatChoice(computerChoice) + ". You lose!");
    }
    return e;
}

private static boolean getYesOrNoInput(Scanner sc, String Prompt){
    while (true){
        System.out.print(Prompt);
        String input = sc.nextLine().trim().toLowerCase();
        if(input.equals("y")){
            return true;
        }
        else if (input.equals("n")){
            return false;
        }
        else{
            System.out.println("Invalid Input, please try again");
        }
        }
    }

private static String formatChoice(String choice){
    choice = choice.toLowerCase();
    if(choice.equals("r")){
        return "Rock";
    }
    if (choice.equals("p")){
        return "Paper";
    }
    if (choice.equals("s")){
        return "Scissors";
    }
    else{
        return "Invalid";
    }
}
}