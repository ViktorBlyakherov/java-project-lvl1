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

    /*Не понял ваш комментарий:
    Из названия метода makeProgression() можно сделать вывод что он возвращает прогрессию, а по факту возвращает
    одно число - это необходимо поправить. Пусть в методе makeProgression() будет создаваться массив (или список)
    с прогрессией. Затем можно заменить одно число на многоточие. После этого сформировать строчку для вопроса -
    String.join(" ", progressionList).

     */

    private static void makeProgression(List pl) {
        int progressionBegin = Utils.getRandomNumber(MAX_RND_NUMBER);
        int progressionStep = Utils.getRandomNumber(STEP_MAX_SIZE);
        for (int i = 1; i <= PROGRESSION_LENGHT; i++) {
            pl.add(Integer.toString(progressionBegin));
            progressionBegin = progressionBegin + progressionStep;
        }
    }

    public static void playProgression() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            List<String> progressionList = new ArrayList<>();
            makeProgression(progressionList);
            int indexToHide = Utils.getRandomNumber(PROGRESSION_LENGHT);
            String rightAnswer = progressionList.get(indexToHide);
            progressionList.set(indexToHide, "..");
            qaArray[i][0] = String.join(" ", progressionList);
            qaArray[i][1] = rightAnswer;
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
