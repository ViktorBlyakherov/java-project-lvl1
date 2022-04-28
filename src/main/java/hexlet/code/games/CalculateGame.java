package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalculateGame {
    public static final int MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What is the result of the expression?";
    public static final String[] OPERATORS_ARRAY = {"+", "-", "*"};

    public static String getRandomOperation() {
        final int quantityOperators = OPERATORS_ARRAY.length;
        int tempNumber = (int) (Math.random() * quantityOperators);
        return OPERATORS_ARRAY[tempNumber];
    }

    private static int calc(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                System.out.println("Неизвестная операция!");
                return 0;
        }
    }

    public static void playCalculate() {
        String[][] qaArray = new String[Engine.ROUND_NUMBER][2];

        for (int i = 0; i < Engine.ROUND_NUMBER; i++) {
            int operandLeft = Utils.getRandomNumber(MAX_RND_NUMBER);
            int operandRight = Utils.getRandomNumber(MAX_RND_NUMBER);
            String operator = getRandomOperation();
            qaArray[i][0] = operandLeft + " " + operator + " " + operandRight;
            int resultCalc = calc(operandLeft, operandRight, operator);
            qaArray[i][1] = Integer.toString(resultCalc);
        }
        Engine.play(qaArray, TASK_TEXT);
    }
}



