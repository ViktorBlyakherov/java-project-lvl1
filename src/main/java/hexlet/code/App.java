package hexlet.code;


import java.util.Scanner;
import hexlet.code.games.Prime;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CalculateGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;


public class App {

    public static void main(String[] args) {
        final int greetingCode = 1;
        final int evenCode = 2;
        final int calcCode = 3;
        final int gcdCode = 4;
        final int progressionCode = 5;
        final int primeCode = 6;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Brain Games!");
        System.out.println("Please enter the game number and press Enter");
        System.out.println("1 - Greet");
        System.out.println("2 - Even");
        System.out.println("3 - Calc");
        System.out.println("4 - GCD");
        System.out.println("5 - Progression");
        System.out.println("6 - Prime");
        System.out.println("0 - Exit");


        int userChoice = scanner.nextInt();
        System.out.println("Your choice: " + userChoice);
        switch (userChoice) {
            case greetingCode:
                Cli.greetings();
                break;
            case evenCode:
                EvenGame.playEven();
                break;
            case calcCode:
                CalculateGame.playCalculate();
                break;
            case gcdCode:
                GCD.playGCD();
                break;
            case progressionCode:
                Progression.playProgression();
                break;
            case primeCode:
                Prime.playPrime();
                break;
            default:
                System.out.println("Такой игры нет!");
                break;
        }
    }
}
