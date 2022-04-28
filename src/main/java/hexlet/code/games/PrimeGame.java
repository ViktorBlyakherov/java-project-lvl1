package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class PrimeGame {
    public static final int MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "Answer 'yes' if given number is prime. Otherwise answer 'no'";

    private static boolean isPrime(int a) {
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static void playPrime() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            int firstNumber = Utils.getRandomNumber(MAX_RND_NUMBER);
            qaArray[i][0] = Integer.toString(firstNumber);
            String rightAnswer;
            qaArray[i][1] = (isPrime(firstNumber)) ? "yes" : "no";
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
