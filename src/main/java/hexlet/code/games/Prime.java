package hexlet.code.games;

import hexlet.code.Engine;

public class Prime {
    public static final int  MAXRNDNUMBER = 100;

    private static String isPrime(int a) {
        int gcd = 1;
        for (int i = 2; i < a; i++) {
            if (a % i == 0) {
                return "no";
            }
        }
        return "yes";
    }

    public static void playPrime() {
        String taskText = "Answer 'yes' if given number is prime. Otherwise answer 'no'";
        String[] questionsArray = new String[Engine.ROUNDNUMBER];
        String[] answersArray = new String[Engine.ROUNDNUMBER];

        for (int i = 0; i < Engine.ROUNDNUMBER; i++) {
            int firstNumber = Engine.getRandomNumber(MAXRNDNUMBER);
            questionsArray[i] = Integer.toString(firstNumber);
            String rightAnswer = isPrime(firstNumber);
            answersArray[i] = rightAnswer;
        }
        Engine.play(questionsArray, answersArray, taskText);
    }
}
