package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.controller.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.view.MenuView;
import fr.le_campus_numerique.java.TicTacToe.view.game.TicTacToeView;
import fr.le_campus_numerique.java.TicTacToe.view.game.GomokuView;
import fr.le_campus_numerique.java.TicTacToe.view.game.ConnectFourView;

public class MenuController {
    protected MenuView menuView;
    protected UserInteraction userInteraction;

    public MenuController() {
        this.menuView = new MenuView();
        this.userInteraction = new UserInteraction();
    }

    public void wichGamePlay() {
        menuView.displayMenu();

        int choice = userInteraction.getUserInt();

        GameController game;

        switch (choice) {
            case 1 -> {
                TicTacToeView ticTacToeView = new TicTacToeView(null);
                userInteraction.setBoardView(ticTacToeView);
                game = new TicTacToeController(ticTacToeView);
            }
            case 2 -> {
                GomokuView gomokuView = new GomokuView(null);
                userInteraction.setBoardView(gomokuView);
                game = new GomokuController(gomokuView);
            }
            case 3 -> {
                ConnectFourView connectFourView = new ConnectFourView(null);
                userInteraction.setBoardView(connectFourView);
                game = new ConnectFourController(connectFourView);
            }
            default -> throw new IllegalStateException("Choix invalide inattendu.");
        }

        game.start();
    }

//    public void wichGamePlay() {
//        menuView.displayMenu();
//        int choice = userInteraction.getUserInt();
//
//        switch (choice) {
//            case 1:
//                game = new TicTacToeController();
//                break;
//            case 2:
//                game = new GomokuController();
//                break;
//            case 3:
//                game = new ConnectFourController();
//                break;
//            default:
//                boardView.displayText("Choix invalide. Merci de réessayer.");
//        }
//
//        game.start();
//    }
}
