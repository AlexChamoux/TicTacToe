package fr.le_campus_numerique.java.TicTacToe.view;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.board.Board;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;

public class BoardView {

    public void display(String rep){
        System.out.println(rep);
    }

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

    public void winGame(String rep, State winnerState) {
        display(rep);
        System.out.println("Félicitations, le joueur " + winnerState + " a gagné !!!");
    }

    public void drawGame(String rep) {
        display(rep);
        System.out.println("Match nul !!! La grille est pleine. Recommencez");
    }

    public void displayMenu() {
        System.out.println("Bien le bonjour joueur émérite, à quel jeu désires-tu jouer ?");
        System.out.println("Tape 1 pour jouer au Morpion, 2 pour jouer au Gomoku, et 3 pour le Puissance 4");
    }

}
