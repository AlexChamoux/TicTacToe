package fr.le_campus_numerique.java.TicTacToe;

import java.util.Scanner;

public class UserInteraction {
    private final Scanner scanner;

    public UserInteraction(){
        this.scanner = new Scanner(System.in);
    }

    public void displayBoard(String boardRepresentation){
        System.out.println(boardRepresentation);
    }

    public int[] getMoveFromPlayer(String currentPlayerRepresentation, Cell[][] board, int size) {
        while (true) {
            System.out.println("Veuillez sélectionner l'emplacement de votre coup en le désignant par son numéro de colonne et de ligne (ex: en haut au milieu = 1 et 2 )");
            System.out.println("Au joueur utilisant les " + currentPlayerRepresentation.trim() + ". Entrez votre coup.");

            System.out.println("Numéro de ligne");
            int row = scanner.nextInt() - 1;

            System.out.println("Numéro de colonne");
            int col = scanner.nextInt() - 1;

            if (row < 0 || row >= size || col < 0 || col >= size) {
                System.out.println("Coordonnées invalides. Les numéros doivent être entre 1 et 3.");
                continue;
            }

            if (!board[row][col].getRepresentation().trim().isEmpty()) {
                System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
                continue;
            }

            return new int[]{row, col};
        }
    }

    public void winGame(String boardRepresentation, String winnerRepresentation) {
        System.out.println(boardRepresentation);
        System.out.println("Félicitations, le joueur " + winnerRepresentation.trim() + " a gagné !!!");
    }

    public void drawGame(String boardRepresentation) {
        System.out.println(boardRepresentation);
        System.out.println("Match nul !!! La grille est pleine. Recommencez");
    }
}
