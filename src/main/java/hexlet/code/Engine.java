package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static final int  ROUNDNUMBER = 3;

    public static String getGreeting() {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        System.out.println("Hello, " + name + "!");
        return name;
    }

    public static int getRandomNumber(int max) {
        return (int) (Math.random() * max) + 1;
    }

    public static void printFail(String userName) {
        System.out.println("Let's try again, " + userName + "!");
    }

    public static void printSucces(String userName) {
        System.out.println("Congratulations, " + userName + "!");
    }

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

    public static void askQuestion(String task) {
        System.out.println("Question: " +  task);
    }

    public static String getAnswer() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Your answer: ");
        String userAnswer = scanner.next();
        return userAnswer;
    }

    public static void play(String[] questionsArray, String[] answersArray, String taskText) {
        boolean isRightAnswer = true;
        String userName = Engine.getGreeting();
        System.out.println(taskText);
        for (int i = 0; i < ROUNDNUMBER; i++) {
            Engine.askQuestion(questionsArray[i]);
            String userAnswer = Engine.getAnswer();
            if (userAnswer.equals(answersArray[i])) {
                Engine.printCorrectResult();
            } else {
                Engine.printIncorrectResult(userAnswer, answersArray[i]);
                Engine.printFail(userName);
                isRightAnswer = false;
                break;
            }
        }
        if (isRightAnswer) {
            Engine.printSucces(userName);
        }
    }

    public static void printIncorrectResult(String userAnswer, String rightAnswer) {
        System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was " + rightAnswer + ".");
    }

    public static void printCorrectResult() {
        System.out.println("Correct!");
    }
}
