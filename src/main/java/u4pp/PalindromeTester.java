package u4pp;
/**
* YOUR COMMENTS HERE
*/
import java.util.Scanner;

public class PalindromeTester {
    /**
     * YOUR JAVADOC HERE
     */
    public static void execute(Scanner sc) {
        System.out.println("Welcome to Palindrome Tester");
        
        boolean keepGoing=true;
        while (keepGoing==true){
            System.out.print("Enter a phrase: ");
            String phrase = sc.nextLine();
        
        if (isPalindrome(phrase)==true){
            System.out.println(phrase + " is a palindrome");
        }
        else{
            System.out.println(phrase + " is not a palindrome");
        }
        keepGoing = getYesOrNoInput(sc, "Keep testing? (Y)es or (N)o: ");
    }
    }

    /**
     * YOUR JAVADOC HERE
     */
    public static boolean isPalindrome(String phrase) {
        if(phrase==null){
            return false;
        }
        String cleaned = cleanString(phrase);
        int left = 0;
        int right = cleaned.length()- 1;

        while (left < right){
            if (cleaned.charAt(left) != cleaned.charAt(right)){
                return false;
            }
            left += 1;
            right -= 1;
        }
        return true;
    }

    private static String cleanString(String phrase){
        return phrase.replaceAll("[^A-Za-z]", "").toLowerCase();
    }

    private static boolean getYesOrNoInput(Scanner sc, String p) {
        while(true){
            System.out.print(p);
            String input = sc.nextLine().trim();

            if ((input.equalsIgnoreCase("y")) || input.equalsIgnoreCase("yes")){
                return true;
            }
            else if ((input.equalsIgnoreCase("n")) || (input.equalsIgnoreCase("no"))){
                return false;
            }
            else{
                System.out.println("Invalid Input, please try again");
            }

        }
    }

    /* Any helper methods you might need */
}