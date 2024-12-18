package fr.le_campus_numerique.java.TicTacToe.view;

import fr.le_campus_numerique.java.TicTacToe.model.board.State;

public class View {

    public void display(String rep){
        System.out.println(rep);
    }

    public void displayTextAndVariable(String message){
        System.out.println("Veuillez sélectionner l'emplacement de votre coup en le désignant par un numéro.");
        System.out.println("Au joueur utilisant les " + message + ". Entrez votre coup.");
    }

    public void displayText(String message){
        System.out.println(message);
    }


    public void winGame(String rep, String winnerState) {
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

    public void playAgain(){
        System.out.println("Voulez-vous rejouer ? (oui/non)");
    }



}
