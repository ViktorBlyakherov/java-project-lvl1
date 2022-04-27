package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

import java.util.ArrayList;
import java.util.List;

public class Progression {
    public static final int  MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGHT = 10;
    private static final int STEP_MAX_SIZE = 10;

    private static String makeProgression(List pl) {
        int progressionBegin = Utils.getRandomNumber(MAX_RND_NUMBER);
        int progressionStep = Utils.getRandomNumber(STEP_MAX_SIZE);
        int indexToHide = Utils.getRandomNumber(PROGRESSION_LENGHT);
        String rightAnswer = "";
        for (int i = 1; i <= PROGRESSION_LENGHT; i++) {
            if (i == indexToHide) {
                pl.add("..");
                rightAnswer = Integer.toString(progressionBegin);
            } else {
                pl.add(Integer.toString(progressionBegin));
            }
            progressionBegin = progressionBegin + progressionStep;
        }
        return rightAnswer;
    }

    public static void playProgression() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            List<String> progressionList = new ArrayList<>();
            String rightAnswer = makeProgression(progressionList);
            qaArray[i][0] = String.join(" ", progressionList);
            qaArray[i][1] = rightAnswer;
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
