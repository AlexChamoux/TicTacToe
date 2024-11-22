package fr.le_campus_numerique.java.TicTacToe;

import fr.le_campus_numerique.java.TicTacToe.game.BoardGame;
import fr.le_campus_numerique.java.TicTacToe.game.gomoku.Gomoku;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.TicTacToe;
import fr.le_campus_numerique.java.TicTacToe.game.conect4.ConnectFour;
import fr.le_campus_numerique.java.TicTacToe.user_in_out.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.user_in_out.View;

public class GameController {
    private UserInteraction userInteraction;
    private View view;
    private BoardGame game;

    public GameController() {
        this.userInteraction = new UserInteraction();
        this.view = new View();
    }

    public void wichGamePlay() {
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
                return;
        }

        game.play();
    }
}
