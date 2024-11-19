package fr.le_campus_numerique.java.TicTacToe;

public class View {

    public void displayTextAndVariable(String currentPlayerRepresentation){
        System.out.println("Veuillez sélectionner l'emplacement de votre coup en le désignant par son numéro de ligne et de colonne (ex: en haut au milieu = 1 et 2 )");
        System.out.println("Au joueur utilisant les " + currentPlayerRepresentation.trim() + ". Entrez votre coup.");
    }

    public void displayText(String message){
        System.out.println(message);
    }

    public void winGame(String boardRepresentation, String winnerRepresentation) {
        System.out.println(boardRepresentation);
        System.out.println("Félicitations, le joueur " + winnerRepresentation.trim() + " a gagné !!!");
    }

    public void drawGame(String boardRepresentation) {
        System.out.println(boardRepresentation);
        System.out.println("Match nul !!! La grille est pleine. Recommencez");
    }

    public void displayBoard(String boardRepresentation){
        System.out.println(boardRepresentation);
    }
}
