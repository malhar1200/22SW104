import java.util.Scanner;
class Hangman extends Game {
    public Hangman(String wordToGuess, int maxAttempts) {
        super(wordToGuess, maxAttempts);
    }

    @Override
    public void play(Scanner scanner) {
        while (!isGameOver()) {
            System.out.println("Current progress: " + getCurrentProgress());
            System.out.println("Remaining attempts: " + getRemainingAttempts());

            System.out.print("Guess a letter: ");
            char guess = scanner.next().toLowerCase().charAt(0);  // Convert input to lowercase
            guessLetter(guess);
            System.out.println();
        }

        if (getRemainingAttempts() > 0) {
            System.out.println("Congratulations! You guessed the word: " + getCurrentProgress());
        } else {
            System.out.println("You ran out of attempts. The word was: " + wordToGuess);
        }
    }
}

abstract class Game {
    protected String wordToGuess;
    protected int maxAttempts;
    protected int remainingAttempts;
    protected String currentProgress;

    public Game(String wordToGuess, int maxAttempts) {
        this.wordToGuess = wordToGuess.toLowerCase();
        this.maxAttempts = maxAttempts;
        this.remainingAttempts = maxAttempts;
        this.currentProgress = createInitialProgress();
    }

    public boolean isGameOver() {
        return remainingAttempts <= 0 || currentProgress.equals(wordToGuess);
    }

    public void guessLetter(char letter) {
        letter = Character.toLowerCase(letter);
        if (wordToGuess.contains(String.valueOf(letter))) {
            for (int i = 0; i < wordToGuess.length(); i++) {
                if (wordToGuess.charAt(i) == letter) {
                    currentProgress = currentProgress.substring(0, i) + letter + currentProgress.substring(i + 1);
                }
            }
        } else {
            remainingAttempts--;
        }
    }

    public String getCurrentProgress() {
        return currentProgress;
    }

    public int getRemainingAttempts() {
        return remainingAttempts;
    }

    private String createInitialProgress() {
        StringBuilder progress = new StringBuilder();
        for (int i = 0; i < wordToGuess.length(); i++) {
            if (Character.isLetter(wordToGuess.charAt(i))) {
                progress.append("_");
            } else {
                progress.append(wordToGuess.charAt(i));
            }
        }
        return progress.toString();
    }

    public abstract void play(Scanner scanner);
}

