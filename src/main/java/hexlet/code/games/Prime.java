package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class Prime {
    private static String isPrime(int a) {
        int gcd = 1;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    public static void playPrime(String userName) {
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'");
        boolean isRightAnswer = true;

        for (int i = 1; i <= App.ROUNDNUMBER; i++) {
            int firstNumber = Engine.getRandomNumber(App.MAXRNDNUMBER);
            Engine.askQuestion(Integer.toString(firstNumber));
            String rightAnswer = isPrime(firstNumber);
            String userAnswer = Engine.getAnswer();


            if (userAnswer.equals(rightAnswer)) {
                Engine.printCorrectResult();
            } else {
                Engine.printIncorrectResult(userAnswer, rightAnswer);
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
