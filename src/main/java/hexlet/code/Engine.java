package hexlet.code;
import java.util.Scanner;

public class Engine {
    public static final int ROUND_NUMBER = 3;

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

    public static void play(String[][] qaArray,  String taskText) {
        System.out.println("Welcome to the Brain Games!");
        System.out.println("May I have your name?");
        Scanner scanner = new Scanner(System.in);
        String userName = scanner.nextLine();
        System.out.println("Hello, " + userName + "!");

        boolean isRightAnswer = true;
        System.out.println(taskText);
        for (int i = 0; i < ROUND_NUMBER; i++) {
            System.out.println("Question: " +  qaArray[i][0]);
            System.out.print("Your answer: ");
            String userAnswer = scanner.next();
            if (userAnswer.equals(qaArray[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.println("'" + userAnswer + "' is wrong answer ;(. Correct answer was "
                        + qaArray[i][1] + ".");
                System.out.println("Let's try again, " + userName + "!");
                isRightAnswer = false;
                break;
            }
        }
        if (isRightAnswer) {
            System.out.println("Congratulations, " + userName + "!");
        }
    }
}
