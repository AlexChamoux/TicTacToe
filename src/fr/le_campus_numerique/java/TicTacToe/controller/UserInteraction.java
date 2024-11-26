
package fr.le_campus_numerique.java.TicTacToe.controller;

import fr.le_campus_numerique.java.TicTacToe.model.Cell;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.view.View;

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
            try {
                view.displayTextAndVariable(currentPlayerState);

                view.displayText("Numéro de ligne");
                int row = Integer.parseInt(scanner.nextLine()) - 1;

                view.displayText("Numéro de colonne");
                int col = Integer.parseInt(scanner.nextLine()) - 1;

                if (row < 0 || row >= sizeLine || col < 0 || col >= sizeColumn) {
                    view.displayText("Coordonnées invalides. Les numéros doivent être entre 1 et " + sizeColumn + ".");
                    continue;
                }

                if (!board[row][col].isEmpty()) {
                    view.displayText("Cette case est déjà occupée. Veuillez choisir une autre case.");
                    continue;
                }

                return new int[]{row, col};
            }catch (NumberFormatException e){
                view.displayText("Entrée invalide. Veuillez entrer un nombre.");
            }
        }
    }

    public int[] getMoveFromHumanPlayerConnectFour(State currentPlayerState, Cell[][] board, int sizeLine, int sizeColumn) {
        while (true) {
            view.displayHumanMoveConnectFour(currentPlayerState);

            view.displayText("Numéro de colonne");
            int col = scanner.nextInt() - 1;

            if (col < 0 || col >= sizeColumn) {
                view.displayText("Colonne invalide. Veuillez entrer un numéro entre 1 et " + sizeColumn + ".");
                continue;
            }

            int row = -1;
            for (int i = sizeLine - 1; i >= 0; i--) {
                if (board[i][col].isEmpty()) {
                    row = i;
                    break;
                }
            }

            if (row == -1) {
                view.displayText("Cette colonne est pleine. Veuillez choisir une autre colonne.");
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

    public int[] getMoveFromComputerConnectFour(Cell[][] board, int sizeLine, int sizeColumn) {
        while (true) {
            int col = secureRandom.nextInt(sizeColumn);

            if (col < 0 || col >= sizeColumn) {
                view.displayText("Colonne invalide. Veuillez entrer un numéro entre 1 et " + sizeColumn + ".");
                continue;
            }

            int row = -1;
            for (int i = sizeLine - 1; i >= 0; i--) {
                if (board[i][col].isEmpty()) {
                    row = i;
                    break;
                }
            }

            if (row == -1) {
                view.displayText("Cette colonne est pleine. Veuillez choisir une autre colonne.");
                continue;
            }

            return new int[]{row, col};
        }
    }

    public int getUserInt(){
        return scanner.nextInt();
    }

}
