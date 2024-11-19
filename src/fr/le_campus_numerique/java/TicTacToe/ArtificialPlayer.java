package fr.le_campus_numerique.java.TicTacToe;

import java.security.SecureRandom;

public class ArtificialPlayer {
    final SecureRandom secureRandom = new SecureRandom();



    public int[] getMoveFromComputer(Cell[][] board, int size) {
        int row = secureRandom.nextInt(3);
        int col = secureRandom.nextInt(3);

        if (!board[row][col].getRepresentation().trim().isEmpty()) {
            System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
            System.exit(0);
        }
        return new int[]{row, col};
    }


}
