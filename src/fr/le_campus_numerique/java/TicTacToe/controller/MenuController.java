package fr.le_campus_numerique.java.TicTacToe.controller;

import fr.le_campus_numerique.java.TicTacToe.controller.game.ConnectFourController;
import fr.le_campus_numerique.java.TicTacToe.controller.game.GomokuController;
import fr.le_campus_numerique.java.TicTacToe.controller.game.TicTacToeController;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;
import fr.le_campus_numerique.java.TicTacToe.view.UserInteraction;

public class MenuController {
    protected BoardView boardView;
    protected UserInteraction userInteraction;

    public MenuController() {
        this.boardView = new BoardView();
        this.userInteraction = new UserInteraction();
    }

    public void wichGamePlay() {
        boardView.displayMenu();

        int choice = userInteraction.getUserInt();

        GameController game;

        switch (choice) {
            case 1 -> {
                game = new TicTacToeController();
            }
            case 2 -> {
                game = new GomokuController();
            }
            case 3 -> {
                game = new ConnectFourController();
            }
            default -> throw new IllegalStateException("Choix invalide inattendu.");
        }

        game.start();
    }

}
