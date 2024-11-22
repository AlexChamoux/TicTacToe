
package fr.le_campus_numerique.java.TicTacToe.user_in_out;

import fr.le_campus_numerique.java.TicTacToe.game.board.Cell;
import fr.le_campus_numerique.java.TicTacToe.game.board.State;
import java.util.Scanner;
import java.security.SecureRandom;

public class UserInteraction {
    private final Scanner scanner;
    final SecureRandom secureRandom = new SecureRandom();
    private View view;

    public UserInteraction(){
        this.scanner = new Scanner(System.in);
        this.view = new View();
    }

    public int[] getMoveFromHumanPlayer(State currentPlayerState, Cell[][] board, int sizeLine, int sizeColumn) {
        while (true) {
            view.displayTextAndVariable(currentPlayerState);

            view.displayText("Numéro de ligne");
            int row = scanner.nextInt() - 1;

            view.displayText("Numéro de colonne");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= sizeLine || col < 0 || col >= sizeColumn) {
                view.displayText("Coordonnées invalides. Les numéros doivent être entre 1 et 3.");
                continue;
            }

            if (!board[row][col].isEmpty()) {
                view.displayText("Cette case est déjà occupée. Veuillez choisir une autre case.");
                continue;
            }

            return new int[]{row, col};
        }
    }


    public int typeOfPlayer(){
        view.displayText("Veuillez choisir votre type de partie");
        view.displayText("Taper 1 pour joueur vs joueur, 2 pour joueur vs ordinateur et 3 pour ordi vs ordi");
        int choice = scanner.nextInt();

        return choice;
    }

    public int[] getMoveFromComputer(Cell[][] board, int sizeLine, int sizeColumn) {
        while (true) {
            int row = secureRandom.nextInt(sizeLine);
            int col = secureRandom.nextInt(sizeColumn);

            if (!board[row][col].isEmpty()) {
                System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
                continue;
            }

            return new int[]{row, col};
        }
    }

    public String getUserString(){
        return scanner.nextLine();
    }

    public int getUserInt(){
        return scanner.nextInt();
    }

}
