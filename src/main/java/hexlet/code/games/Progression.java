package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    private static int rightAnswer;
    private static final int PROGRESSIONLENGHT = 10;
    private static final int STEPMAXSIZE = 10;

    private static void makeProgression(List pl) {
        int progressionBegin = Engine.getRandomNumber(App.MAXRNDNUMBER);
        int progressionStep = Engine.getRandomNumber(STEPMAXSIZE);

        for (int i = 1; i <= PROGRESSIONLENGHT; i++) {
            pl.add(progressionBegin);
            progressionBegin = progressionBegin + progressionStep;
        }
    }

    private static String convertProgressionToString(List<Integer> pl) {
        int indexToHide = Engine.getRandomNumber(PROGRESSIONLENGHT);
        String tempStr = "";

        for (int i = 0; i < PROGRESSIONLENGHT; i++) {
            if ((i + 1) == indexToHide) {
                tempStr = tempStr + ".. ";
                rightAnswer = pl.get(i);
            } else {
                tempStr = tempStr + pl.get(i) + " ";
            }
        }
        return tempStr;
    }

    public static void playProgression(String userName) {
        System.out.println("What number is missing in the progression?");
        boolean isRightAnswer = true;

        for (int i = 1; i <= App.ROUNDNUMBER; i++) {
            List<Integer> progressionList = new ArrayList<Integer>();
            makeProgression(progressionList);
            Engine.askQuestion(convertProgressionToString(progressionList));
            String userAnswer = Engine.getAnswer();

            if (Integer.parseInt(userAnswer) == rightAnswer) {
                Engine.printCorrectResult();
            } else {
                Engine.printIncorrectResult(userAnswer, Integer.toString(rightAnswer));
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
