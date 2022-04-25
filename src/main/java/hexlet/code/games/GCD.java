package hexlet.code.games;

import hexlet.code.Engine;

public class GCD {
    public static final int  MAXRNDNUMBER = 20;

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
        String taskText = "Find the greatest common divisor of given numbers.";
        String[] questionsArray = new String[Engine.ROUNDNUMBER];
        String[] answersArray = new String[Engine.ROUNDNUMBER];

        for (int i = 0; i < Engine.ROUNDNUMBER; i++) {
            int firstNumber = Engine.getRandomNumber(MAXRNDNUMBER);
            int secondNumber = Engine.getRandomNumber(MAXRNDNUMBER);
            questionsArray[i] = firstNumber + " " + secondNumber;
            int rightGCD = findGCD(firstNumber, secondNumber);
            answersArray[i] = Integer.toString(rightGCD);
        }
        Engine.play(questionsArray, answersArray, taskText);
    }
}
