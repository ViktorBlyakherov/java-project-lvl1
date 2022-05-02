package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;
import java.util.ArrayList;
import java.util.List;

public class ProgressionGame {
    public static final int  MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What number is missing in the progression?";
    private static final int PROGRESSION_LENGHT = 10;
    private static final int STEP_MAX_SIZE = 10;


    private static List<String> makeProgression() {
        List<String> pl = new ArrayList<>();
        int progressionBegin = Utils.getRandomNumber(MAX_RND_NUMBER);
        int progressionStep = Utils.getRandomNumber(STEP_MAX_SIZE);
        for (int i = 0; i < PROGRESSION_LENGHT; i++) {
            pl.add(Integer.toString(progressionBegin));
            progressionBegin = progressionBegin + progressionStep;
        }
        return pl;
    }

    public static void playProgression() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            List<String> progressionList = makeProgression();
            int indexToHide = Utils.getRandomNumber(PROGRESSION_LENGHT) - 1;
            String rightAnswer = progressionList.get(indexToHide);
            progressionList.set(indexToHide, "..");
            qaArray[i][0] = String.join(" ", progressionList);
            qaArray[i][1] = rightAnswer;
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
