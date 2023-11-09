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