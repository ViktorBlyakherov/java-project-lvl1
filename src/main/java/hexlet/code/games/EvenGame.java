package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class EvenGame {
    public static final int  MAX_RND_NUMBER = 100;
    public static final  String TASK_TEXT = "Answer 'yes' if the number is even, otherwise answer 'no'.";

    public static void playEven() {

        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            int tempNumber = Utils.getRandomNumber(MAX_RND_NUMBER);
            boolean isEven = (tempNumber % 2 == 0);

            qaArray[i][1] = (isEven) ? "yes" : "no";
            qaArray[i][0] = Integer.toString(tempNumber);
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}
