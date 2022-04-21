package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static final int  MAXRNDNUMBER = 100;

    public static void playEven() {
        String userName = Engine.getGreeting();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean isRightAnswer = true;

        for (int i = 1; i <= Engine.ROUNDNUMBER; i++) {
            int tempNumber = Engine.getRandomNumber(MAXRNDNUMBER);
            boolean isEven = (tempNumber % 2 == 0);
            Engine.askQuestion(Integer.toString(tempNumber));
            String userAnswer = Engine.getAnswer();
            if ((isEven && userAnswer.equals("yes")) || (!isEven && userAnswer.equals("no"))) {
                Engine.printCorrectResult();
            } else {
                if (isEven) {
                    Engine.printIncorrectResult(userAnswer, "yes");
                } else {
                    Engine.printIncorrectResult(userAnswer, "no");
                }
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
