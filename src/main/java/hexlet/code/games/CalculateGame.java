package hexlet.code.games;

import hexlet.code.Engine;

public class CalculateGame {
    public static final int MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What is the result of the expression?";

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
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            int operandLeft = Engine.getRandomNumber(MAX_RND_NUMBER);
            int operandRight = Engine.getRandomNumber(MAX_RND_NUMBER);
            String operator = Engine.getRandomOperation();
            qaArray[i][0] = operandLeft + " " + operator + " " + operandRight;
            int resultCalc = calc(operandLeft, operandRight, operator);
            qaArray[i][1] = Integer.toString(resultCalc);
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}



