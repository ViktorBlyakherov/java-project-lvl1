package hexlet.code.games;
import hexlet.code.App;
import hexlet.code.Engine;

public class EvenGame {
    public static void playEven(String userName) {
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        boolean isRightAnswer = true;

        for (int i = 1; i <= App.ROUNDNUMBER; i++) {
            int tempNumber = Engine.getRandomNumber(App.MAXRNDNUMBER);
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
