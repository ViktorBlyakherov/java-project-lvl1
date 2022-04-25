package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    public static final int  MAXRNDNUMBER = 100;

    private static int rightAnswer;
    private static final int PROGRESSIONLENGHT = 10;
    private static final int STEPMAXSIZE = 10;

    private static void makeProgression(List pl) {
        int progressionBegin = Engine.getRandomNumber(MAXRNDNUMBER);
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

    public static void playProgression() {
        String taskText = "What number is missing in the progression?";
        String[] questionsArray = new String[Engine.ROUNDNUMBER];
        String[] answersArray = new String[Engine.ROUNDNUMBER];

        for (int i = 0; i < Engine.ROUNDNUMBER; i++) {
            List<Integer> progressionList = new ArrayList<Integer>();
            makeProgression(progressionList);
            questionsArray[i] = convertProgressionToString(progressionList);
            answersArray[i] = Integer.toString(rightAnswer);
        }
        Engine.play(questionsArray, answersArray, taskText);
    }
}
