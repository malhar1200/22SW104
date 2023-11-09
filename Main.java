import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        boolean playAgain = true;

        // Define a dictionary of words and hints
        HashMap<String, String> wordHints = new HashMap<>();
        wordHints.put("programming", "Computer science field");
        wordHints.put("computer", "Electronic device");
        wordHints.put("java", "Programming language");
        wordHints.put("hangman", "Word-guessing game");
        wordHints.put("coding", "Writing software");
        wordHints.put("algorithm", "Set of instructions");
        wordHints.put("software", "Computer programs");

        while (playAgain) {
            System.out.println("Welcome to Hangman!");

            // Select a random word from the dictionary
            String wordToGuess = wordHints.keySet().toArray()[random.nextInt(wordHints.size())].toString();
            int maxAttempts = 6; // Change this value to set a different number of attempts

            Hangman game = new Hangman(wordToGuess, maxAttempts);
            System.out.println("Hint: " + wordHints.get(wordToGuess));
            game.play(scanner);

            System.out.print("Do you want to play again? (yes/no): ");
            String playAgainChoice = scanner.next().toLowerCase();
            playAgain = playAgainChoice.equals("yes");
        }

        scanner.close();
    }
}