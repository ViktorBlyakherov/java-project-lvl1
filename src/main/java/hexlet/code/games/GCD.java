package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class GCD {
    private static int findGCD(int a, int b) {
        int gcd = 1;
        for (int i = 1; i <= a && i <= b; i++) {
            if (a % i == 0 && b % i == 0) {
                gcd = i;
            }
        }
        return gcd;
    }

    public static void playGCD(String userName) {
        System.out.println("Find the greatest common divisor of given numbers.");
        boolean isRightAnswer = true;

        for (int i = 1; i <= App.ROUNDNUMBER; i++) {
            int firstNumber = Engine.getRandomNumber(App.MAXRNDNUMBER);
            int secondNumber = Engine.getRandomNumber(App.MAXRNDNUMBER);
            Engine.askQuestion(firstNumber + " " + secondNumber);
            int rightGCD = findGCD(firstNumber, secondNumber);
            String userAnswer = Engine.getAnswer();

            if (Integer.parseInt(userAnswer) == rightGCD) {
                Engine.printCorrectResult();
            } else {
                Engine.printIncorrectResult(userAnswer, Integer.toString(rightGCD));
                Engine.printFail(userName);
                isRightAnswer = false;
                break;
            }
        }

        if (isRightAnswer) {
            Engine.printSucces(userName);
        }
    }
}
