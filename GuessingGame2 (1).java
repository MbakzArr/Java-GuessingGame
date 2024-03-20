import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuessingGame2
{
    public static void main(final String[] args)
            throws FileNotFoundException
    {
        // same as GuessingGame but:
        // number range is 20-25 (not 1-10)
        // if the user guesses outside the bounds of 20-25, give error message
        // if the user guesses too low or too high (e.g. they guess 21, computer had 23),
        // tell the user "higher" or "lower" until the user guesses the number, then
        // pick a new number
        // also, the user can end the game by typing, q, x, quit, exit, or bye
        // finally: NO MAGIC NUMBERS allowed
        final Random r;
        final Scanner s;
        final List<String> exitChoices;

        final File f;
        f = new File("guesses.txt");

        int computerNumber;
        int userNumber;
        String userInput;
        boolean quit;
        boolean validExitChoiceByUser;

        validExitChoiceByUser = false;
        exitChoices = new ArrayList();
        exitChoices.add("x");
        exitChoices.add("exit");
        exitChoices.add("q");
        exitChoices.add("quit");
        exitChoices.add("bye");
        quit = false;
        r = new Random();
        // s = new Scanner(System.in);
        s = new Scanner(f);

        computerNumber = r.nextInt(19, 25) + 1; // 20-25
        System.out.println("computer picked " + computerNumber);

        while(!quit)
        {
            validExitChoiceByUser = false;

            System.out.print("Type a number 20-25, q, quit, x, exit, or bye: ");

            if(s.hasNext())
            {
                if(s.hasNextInt())
                {
                    userNumber = s.nextInt();

                    if(userNumber > 25)
                    {
                        System.out.println("too high; pick 20-25 only");
                    }
                    else if(userNumber < 20)
                    {
                        System.out.println("too low; pick 20-25 only");
                    }
                    else if(userNumber > computerNumber)
                    {
                        System.out.println("LOWER!!");
                    }
                    else if(userNumber < computerNumber)
                    {
                        System.out.println("HIGHER!!");
                    }
                    else // userNumber == computerNumber
                    {
                        System.out.println("CORRECT!");
                        computerNumber = r.nextInt(19, 25) + 1; // 20-25
                    }
                }
                else // not an int
                {
                    userInput = s.next();
                    for(final String choice: exitChoices)
                    {
                        if(userInput.equalsIgnoreCase(choice))
                        {
                            validExitChoiceByUser = true;
                            System.out.println("Thanks for playing");
                            quit = true;
                        }
                    }
                    if(!validExitChoiceByUser)
                    {
                        System.out.println("Invalid choice: " + userInput);
                    }
                }
            }
        }
        s.close();
    }
}
