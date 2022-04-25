package hexlet.code.games;

import hexlet.code.Engine;

public class EvenGame {
    public static final int  MAXRNDNUMBER = 100;

    public static void playEven() {
        String taskText = "Answer 'yes' if the number is even, otherwise answer 'no'.";
        String[] questionsArray = new String[Engine.ROUNDNUMBER];
        String[] answersArray = new String[Engine.ROUNDNUMBER];

        for (int i = 0; i < Engine.ROUNDNUMBER; i++) {
            int tempNumber = Engine.getRandomNumber(MAXRNDNUMBER);
            boolean isEven = (tempNumber % 2 == 0);
            if (isEven) {
                answersArray[i] = "yes";
            } else {
                answersArray[i] = "no";
            }
            questionsArray[i] = Integer.toString(tempNumber);
        }
        Engine.play(questionsArray, answersArray, taskText);
    }
}
