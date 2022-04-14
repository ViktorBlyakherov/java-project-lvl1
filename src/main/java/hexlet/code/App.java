package hexlet.code;

import java.util.Scanner;
import hexlet.code.games.Prime;
import hexlet.code.games.EvenGame;
import hexlet.code.games.CalculateGame;
import hexlet.code.games.GCD;
import hexlet.code.games.Progression;


public class App {
    public static final int  ROUNDNUMBER = 3;
    public static final int  MAXRNDNUMBER = 100;

    public static void main(String[] args) {
        final int greetingCode = 1;
        final int evenCode = 2;
        final int calcCode = 3;
        final int gcdCode = 4;
        final int progressionCode = 5;
        final int primeCode = 6;
        final int exitCode = 0;

        Scanner scanner = new Scanner(System.in);
        String userName;
//        boolean isPlay = true;
//        while (isPlay) {
            Engine.printMenu();
            int userChoice = scanner.nextInt();
            System.out.println("Your choice: " + userChoice);
            switch (userChoice) {
                case greetingCode:
                    userName = Engine.getGreeting();
                    break;
                case evenCode:
                    userName = Engine.getGreeting();
                    EvenGame.playEven(userName);
                    break;
                case calcCode:
                    userName = Engine.getGreeting();
                    CalculateGame.playCalculate(userName);
                    break;
                case gcdCode:
                    userName = Engine.getGreeting();
                    GCD.playGCD(userName);
                    break;
                case progressionCode:
                    userName = Engine.getGreeting();
                    Progression.playProgression(userName);
                    break;
                case primeCode:
                    userName = Engine.getGreeting();
                    Prime.playPrime(userName);
                    break;
                case exitCode:
//                    isPlay = false;
                    break;
                default:
                    break;
            }
//    }
    }
}
