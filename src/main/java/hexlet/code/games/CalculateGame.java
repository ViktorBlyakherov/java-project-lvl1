package hexlet.code.games;

import hexlet.code.Engine;

public class CalculateGame {
    public static final int  MAXRNDNUMBER = 100;

    private static int calc(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                throw new Error("Неизвестная операция!");
        }
    }

    public static void playCalculate() {
        String taskText = "What is the result of the expression?";
        String[] questionsArray = new String[Engine.ROUNDNUMBER];
        String[] answersArray = new String[Engine.ROUNDNUMBER];

        for (int i = 0; i < Engine.ROUNDNUMBER; i++) {
            int operandLeft = Engine.getRandomNumber(MAXRNDNUMBER);
            int operandRight = Engine.getRandomNumber(MAXRNDNUMBER);
            String operator = Engine.getRandomOperation();
            questionsArray[i] = operandLeft + " " + operator + " " + operandRight;
            int resultCalc = calc(operandLeft, operandRight, operator);
            answersArray[i] = Integer.toString(resultCalc);
        }
        Engine.play(questionsArray, answersArray, taskText);
    }
}



