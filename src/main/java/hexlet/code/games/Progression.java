package hexlet.code.games;

import hexlet.code.Engine;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    public static final int  MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What number is missing in the progression?";
    private static int rightAnswer;
    private static final int PROGRESSION_LENGHT = 10;
    private static final int STEP_MAX_SIZE = 10;

    private static void makeProgression(List pl) {
        int progressionBegin = Engine.getRandomNumber(MAX_RND_NUMBER);
        int progressionStep = Engine.getRandomNumber(STEP_MAX_SIZE);

        for (int i = 1; i <= PROGRESSION_LENGHT; i++) {
            pl.add(progressionBegin);
            progressionBegin = progressionBegin + progressionStep;
        }
    }

    private static String convertProgressionToString(List<Integer> pl) {
        int indexToHide = Engine.getRandomNumber(PROGRESSION_LENGHT);
        String tempStr = "";

        for (int i = 0; i < PROGRESSION_LENGHT; i++) {
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
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            List<Integer> progressionList = new ArrayList<Integer>();
            makeProgression(progressionList);
            qaArray[i][0] = convertProgressionToString(progressionList);
            qaArray[i][1] = Integer.toString(rightAnswer);
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
