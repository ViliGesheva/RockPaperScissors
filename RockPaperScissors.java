import java.util.Random;
import java.util.Scanner;

public class RockPaperScissors {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        final String ROCK = "Rock";
        final String PAPER = "Paper";
        final String SCISSORS = "Scissors";
        int playerScore = 0;
        int computerScore = 0;
        System.out.println("Enter player name: ");
        String name = scanner.nextLine();
        printBeginning();

        String command = scanner.nextLine();
        while (!command.equals("end") && !command.equals("e")) {

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
            System.out.printf("%s chose %s\n",name, playerMove);
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
                    System.out.printf("%s lose!\n", name);
                    computerScore++;
                } else  {
                    System.out.printf("%s win!\n", name);
                    playerScore++;
                }
            } else if (playerMove.equals(PAPER)) {
                if (computerMove.equals(ROCK)) {
                    System.out.printf("%s win!\n", name);
                    playerScore++;
                } else {
                    System.out.printf("%s lose!\n", name);
                    computerScore++;
                }
            } else if (playerMove.equals(SCISSORS)) {
                if (computerMove.equals(ROCK)) {
                    System.out.printf("%s lose!\n", name);
                    computerScore++;
                } else {
                    System.out.printf("%s win!\n", name);
                    playerScore++;
                }
            }
            System.out.printf("%s - %d : Computer - %d\n", name, playerScore, computerScore);
            System.out.println("--------------------------------------------------------------------");
            printBeginning();
            command = scanner.nextLine();
        }
        if (playerScore > computerScore) {
            System.out.println("VICTORY");
        } else if (computerScore > playerScore) {
            System.out.println("LOSS");
        } else {
            System.out.println("DRAW");
        }
        System.out.printf("Total score: \n%s - %d : Computer - %d\n",name, playerScore, computerScore);
    }

    public static void printBeginning() {
        System.out.println("\"To end the game enter [e]nd\"");
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
