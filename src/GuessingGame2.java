/**
 * GuessingGame2 class implements a guessing game where the user 
 * tries to guess a randomly generated number within a specified range.
 * The game provides the user with multiple chances to guess the correct number,
 * allows input from either manual typing or a file, and calculates the score
 * based on the user's performance.
 *
 * Parameters: None
 * Arguments: None
 * Return: None
 * 
 * @author Khuliso Junior Ravhuravhu and Arehone Brenden Mbadaliga
 * version 1.0
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class GuessingGame2
{
    private static final int LOWER_BOUND = 20;
    private static final int UPPER_BOUND = 25;
    private static final int NUM_GUESSES_ALLOWED = 5;
    private static final int TOTAL_NUMBERS_TO_GUESS = 20;
    private static final int NUM_BOUNDS = 0; 
    private static int TOTAL_GUESSES = 0;
    private static int TOT_NUMBER_GUESSED = 0;

    public static void main(final String[] args) throws FileNotFoundException
    {
        final Random random = new Random();
        final Scanner scanner = new Scanner(System.in);
        final List<String> exitChoices = new ArrayList<>();
        final File file = new File("guesses.txt");

        exitChoices.add("x");
        exitChoices.add("exit");
        exitChoices.add("q");
        exitChoices.add("quit");
        exitChoices.add("bye");

        System.out.print("Do you want to type answers or use a file to input answers? (type/file): ");
        String inputMethod = scanner.nextLine().toLowerCase();

        List<Integer> guesses = new ArrayList<>();
        if (inputMethod.equals("file"))
        {
            System.out.print("Enter the filename: ");
            String fileName = scanner.nextLine();
            try (Scanner fileScanner = new Scanner(new File(fileName)))
            {
                while (fileScanner.hasNextInt()) {
                    guesses.add(fileScanner.nextInt());
                }
            } catch (FileNotFoundException e)
            {
                System.out.println("\nFile not found. \nUsing manual input instead.\n");
                inputMethod = "type";
            }
        }

        int computerNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + NUM_BOUNDS) + LOWER_BOUND;

        System.out.println("Computer picked: " + computerNumber);

        boolean quit = false;
        while (!quit)
        {
            System.out.print("Type a number " + LOWER_BOUND + "-" + UPPER_BOUND + ", q, quit, x, exit, or bye: ");
            if (scanner.hasNext())
            {
                if (scanner.hasNextInt()) {
                    int userNumber = scanner.nextInt();
                    TOTAL_GUESSES++;
                    if (userNumber > UPPER_BOUND)
                    {
                        System.out.println("Too high; pick " + LOWER_BOUND + "-" + UPPER_BOUND + " only");
                    } else if (userNumber < LOWER_BOUND)
                    {
                        System.out.println("Too low; pick " + LOWER_BOUND + "-" + UPPER_BOUND + " only");
                    } else if (userNumber > computerNumber)
                    {
                        System.out.println("LOWER!!");
                    } else if (userNumber < computerNumber)
                    {
                        System.out.println("HIGHER!!");
                    } else {
                        System.out.println("CORRECT!");
                        TOT_NUMBER_GUESSED++;
                        computerNumber = random.nextInt(UPPER_BOUND - LOWER_BOUND + NUM_BOUNDS) + LOWER_BOUND;
                        System.out.println("Computer picked: " + computerNumber);
                        if (TOT_NUMBER_GUESSED == NUM_GUESSES_ALLOWED)
                        {
                            break;
                        }
                    }
                } else
                { // not an int
                    String userInput = scanner.next();
                    for (String choice : exitChoices)
                    {
                        if (userInput.equalsIgnoreCase(choice))
                        {
                            System.out.println("Good Game J!");
                            quit = true;
                            break;
                        }
                    }
                    if (!quit)
                    {
                        System.out.println("Invalid choice: " + userInput);
                    }
                }
            }
        }

        double averageGuessesPerNumber = TOTAL_GUESSES / (double) NUM_GUESSES_ALLOWED;
        double percentageGuessed = (TOT_NUMBER_GUESSED / (double) TOTAL_NUMBERS_TO_GUESS) * 100;
        System.out.println("\nThe computer picked " + TOTAL_NUMBERS_TO_GUESS + " different numbers.");
        System.out.println("\nYou guessed " + TOT_NUMBER_GUESSED + " of them with " + TOTAL_GUESSES + " guesses.");
        System.out.println("\nYou averaged " + averageGuessesPerNumber + " guesses and guessed " + percentageGuessed + "% of the numbers.");

        scanner.close();
    }
}
