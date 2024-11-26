package fr.le_campus_numerique.java.TicTacToe;

import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.gomoku.Gomoku;
import fr.le_campus_numerique.java.TicTacToe.model.tictacttoe.TicTacToe;
import fr.le_campus_numerique.java.TicTacToe.model.connect4.ConnectFour;
import fr.le_campus_numerique.java.TicTacToe.controller.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.view.View;

public class GameController {
    private UserInteraction userInteraction;
    private View view;
    private BoardModel game;

    public GameController() {
        this.userInteraction = new UserInteraction();
        this.view = new View();
    }

    public BoardModel wichGamePlay() {
        view.displayText("Bien le bonjour joueur émérite, à quel jeu désires-tu jouer ?");
        view.displayText("Tape 1 pour jouer au Morpion, 2 pour jouer au Gomoku, et 3 pour le Puissance 4");
        int choice = userInteraction.getUserInt();

        switch (choice) {
            case 1:
                game = new TicTacToe();
                break;
            case 2:
                game = new Gomoku();
                break;
            case 3:
                game = new ConnectFour();
                break;
            default:
                view.displayText("Choix invalide. Merci de réessayer.");
        }

        return game;
    }
}
