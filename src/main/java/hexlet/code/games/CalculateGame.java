package hexlet.code.games;

import hexlet.code.App;
import hexlet.code.Engine;

public class CalculateGame {

    private static int calc(int a, int b, String operator) {
        switch (operator) {
            case "+":
                return a + b;
            case "-":
                return a - b;
            case "*":
                return a * b;
            default:
                return 0;
        }
    }

    public static void playCalculate(String userName) {
        System.out.println("What is the result of the expression?");
        boolean isRightAnswer = true;

        for (int i = 1; i <= App.ROUNDNUMBER; i++) {
            int operandLeft = Engine.getRandomNumber(App.MAXRNDNUMBER);
            int operandRight = Engine.getRandomNumber(App.MAXRNDNUMBER);
            String operator = Engine.getRandomOperation();
            Engine.askQuestion(operandLeft + " " + operator + " " + operandRight);
            int resultCalc = calc(operandLeft, operandRight, operator);
            String userAnswer = Engine.getAnswer();

            if (Integer.parseInt(userAnswer) == resultCalc) {
                Engine.printCorrectResult();
            } else {
                Engine.printIncorrectResult(userAnswer, Integer.toString(resultCalc));
                Engine.printFail(userName);
                isRightAnswer = false;
                break;
            }
        }

        if (isRightAnswer) {
            Engine.printSucces(userName);
        }
    }
}



