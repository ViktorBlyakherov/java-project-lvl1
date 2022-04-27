package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.Utils;

public class CalculateGame {
    public static final int MAX_RND_NUMBER = 100;
    public static final String TASK_TEXT = "What is the result of the expression?";

    public static String getRandomOperation() {
        final int quantityOperators = 3;
        final int plusOperatorCode = 1;
        final int minusOperatorCode = 2;
        final int multiplyOperatorCode = 3;


        int tempNumber = (int) (Math.random() * quantityOperators + 1);
        switch (tempNumber) {
            case plusOperatorCode:
                return "+";
            case minusOperatorCode:
                return "-";
            case multiplyOperatorCode:
                return "*";
            default:
                System.out.println("Неизвестная операция!");
                return "";
        }
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



