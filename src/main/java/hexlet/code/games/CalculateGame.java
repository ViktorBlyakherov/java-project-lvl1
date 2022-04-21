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
        String userName = Engine.getGreeting();
        System.out.println("What is the result of the expression?");
        boolean isRightAnswer = true;

        for (int i = 1; i <= Engine.ROUNDNUMBER; i++) {
            int operandLeft = Engine.getRandomNumber(MAXRNDNUMBER);
            int operandRight = Engine.getRandomNumber(MAXRNDNUMBER);
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



