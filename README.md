# Guessing Game 2 Readme

## Description
Guessing Game 2 is a Java program that allows users to play a number guessing game. In this game, the user needs to guess a number between 20 and 25, inclusive. The program provides feedback to the user if their guess is too high or too low. Additionally, the user can choose to quit the game at any time by typing specific keywords.

## Features
- **Score Tracking**: The program keeps track of the user's score and displays it at the end of the game.
- **Error Handling**: Provides error messages for invalid user inputs.
- **User-Friendly**: Allows the user to quit the game using various keywords for convenience.
- **Configurability**: Reads user inputs from a file ("guesses.txt") for easy testing and automation.
- **No Magic Numbers**: All numerical values are represented as constants for better code readability and maintainability.

## Usage
1. **Compile**: Compile the program using a Java compiler.
   ```
   javac GuessingGame2.java
   ```

2. **Run**: Run the compiled program.
   ```
   java GuessingGame2
   ```

3. **Gameplay**: Follow the prompts to play the game. Enter a number between 20 and 25 when prompted. To quit the game, type one of the specified keywords: "q", "quit", "x", "exit", or "bye".

4. **View Score**: After quitting the game, the program will display the user's score, indicating the total number of guesses made and the average number of guesses per number.

## Author
This program was developed by [Your Name].

## Acknowledgments
Special thanks to [Instructor Name] for providing the lab exercise and inspiration for this project.
