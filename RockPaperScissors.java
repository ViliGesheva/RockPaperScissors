import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String ROCK = "Rock";
        final String PAPER = "Paper";
        final String SCISSORS = "Scissors";
        int totalPlayerResult = 0;
        int totalComputerResult = 0;
        printBeginning();
        String command = scanner.nextLine();
        while (!command.equals("end")) {
            int playerResult = 0;
            int computerResult = 0;
            String playerMove = command;
            while (!isValidMove(playerMove)) {
                System.out.println("Invalid input. Try again....");
                printBeginning();
                playerMove = scanner.nextLine();
            }
            if (playerMove.equals("r") || playerMove.equals("rock")) {
                playerMove = ROCK;
            } else if (playerMove.equals("p") || playerMove.equals("paper")) {
                playerMove = PAPER;
            } else if (playerMove.equals("s") || playerMove.equals("scissors")) {
                playerMove = SCISSORS;
            }
            System.out.printf("You chose %s\n", playerMove);
            Random random = new Random();
            int randomNumber = random.nextInt(3);
            String computerMove = "";
            if (randomNumber == 0) {
                computerMove = ROCK;
            } else if (randomNumber == 1) {
                computerMove = PAPER;
            } else  {
                computerMove = SCISSORS;
            }
            System.out.printf("Computer chose %s\n", computerMove);
            if (playerMove.equals(computerMove)) {
                System.out.println("This game was a draw!");
            } else if (playerMove.equals(ROCK)) {
                if (computerMove.equals(PAPER)) {
                    System.out.println("You lose! ");
                    computerResult++;
                } else  {
                    System.out.println("You win!");
                    playerResult++;
                }
            } else if (playerMove.equals(PAPER)) {
                if (computerMove.equals(ROCK)) {
                    System.out.println("You win!");
                    playerResult++;
                } else {
                    System.out.println("You lose!");
                    computerResult++;
                }
            } else if (playerMove.equals(SCISSORS)) {
                if (computerMove.equals(ROCK)) {
                    System.out.println("You lose!");
                    computerResult++;
                } else {
                    System.out.println("You win! ");
                    playerResult++;
                }
            }
            totalPlayerResult += playerResult;
            totalComputerResult += computerResult;
            System.out.printf("Result: \nYou - %d : Computer - %d\n", playerResult, computerResult);
            System.out.println("--------------------------------------------------------------------");
            printBeginning();
            command = scanner.nextLine();
        }
        System.out.printf("Total result: \nYou - %d : Computer - %d\n", totalPlayerResult, totalComputerResult);
    }

    public static void printBeginning() {
        System.out.println("Choose [r]ock, [p]aper or [s]cissors: ");
    }

    public static boolean isValidMove(String move) {
        boolean isValidMove = false;
        if (move.equals("r") || move.equals("rock") || move.equals("s") || move.equals("scissors") || move.equals("p") || move.equals("paper")) {
            isValidMove = true;
        }
        return isValidMove;
    }
}
