
package fr.le_campus_numerique.java.TicTacToe;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner;
    private View view;

    public UserInteraction(){
        this.scanner = new Scanner(System.in);
        this.view = new View();
    }

    public int[] getMoveFromPlayer(String currentPlayerRepresentation, Cell[][] board, int size) {
        while (true) {
            view.displayTextAndVariable(currentPlayerRepresentation);

            view.displayText("Numéro de ligne");
            int row = scanner.nextInt() - 1;

            view.displayText("Numéro de colonne");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= size || col < 0 || col >= size) {
                view.displayText("Coordonnées invalides. Les numéros doivent être entre 1 et 3.");
                continue;
            }

            if (!board[row][col].getRepresentation().trim().isEmpty()) {
                view.displayText("Cette case est déjà occupée. Veuillez choisir une autre case.");
                continue;
            }

            return new int[]{row, col};
        }
    }


}
