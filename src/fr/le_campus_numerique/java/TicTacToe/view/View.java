
package fr.le_campus_numerique.java.TicTacToe.view;

import fr.le_campus_numerique.java.TicTacToe.model.State;

public class View {

    public void displayTextAndVariable(State currentPlayerState){
        System.out.println("Veuillez sélectionner l'emplacement de votre coup en le désignant par un numéro.");
        System.out.println("Au joueur utilisant les " + currentPlayerState + ". Entrez votre coup.");
    }

    public void displayHumanMoveConnectFour(State currentPlayerState){
        System.out.println("Veuillez sélectionner une colonne pour mettre votre jeton");
        if(currentPlayerState == State.X) {
            System.out.println("Au joueur utilisant les bleus. Entrez votre coup.");
        }else{
            System.out.println("Au joueur utilisant les rouges.");
        }

    }

    public void displayText(String message){
        System.out.println(message);
    }

    public void winGame(String boardRepresentation, State winnerState) {
        System.out.println(boardRepresentation);
        System.out.println("Félicitations, le joueur " + winnerState + " a gagné !!!");
    }

    public void drawGame(String boardRepresentation) {
        System.out.println(boardRepresentation);
        System.out.println("Match nul !!! La grille est pleine. Recommencez");
    }

    public void displayBoard(String boardRepresentation){
        System.out.println(boardRepresentation);
    }
}
