package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class GCD {
    public static final int MAX_RND_NUMBER = 20;
    public static final String TASK_TEXT = "Find the greatest common divisor of given numbers.";

    private static int findGCD(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void playGCD() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            int firstNumber = Utils.getRandomNumber(MAX_RND_NUMBER);
            int secondNumber = Utils.getRandomNumber(MAX_RND_NUMBER);
            qaArray[i][0] = firstNumber + " " + secondNumber;
            int rightGCD = findGCD(firstNumber, secondNumber);
            qaArray[i][1] = Integer.toString(rightGCD);
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
