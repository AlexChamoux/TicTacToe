package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.GameRules;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;

public class ConnectFourController extends GameController {
//    int sizeLine = 6;
//    int sizeColumn = 7;
    int[] move;

    public ConnectFourController() {
        super(6,7,4);
    }

    public void move() {
        if (currentPlayer instanceof HumanPlayer) {
//            move = userInteraction.getMoveFromHumanPlayerConnectFour(currentPlayer.getState(), model, board.getSizeLine(), board.getSizeColumn());

            while (true) {

                boardView.displayHumanMoveConnectFour(currentPlayer.getState());

                boardView.displayText("Numéro de colonne");
                int col = userInteraction.getUserInt() - 1;

                if (col < 0 || col >= sizeColumn) {
                    boardView.displayText("Colonne invalide. Veuillez entrer un numéro entre 1 et " + sizeColumn + ".");
                    continue;
                }

                int row = -1;
                for (int i = sizeLine - 1; i >= 0; i--) {
                    if (model.isEmpty(i, col)) {
                        row = i;
                        break;
                    }
                }

                if (row == -1) {
                    boardView.displayText("Cette colonne est pleine. Veuillez choisir une autre colonne.");
                    continue;
                }

                move = new int[]{row, col};
                break;
            }

        } else {
//            move = userInteraction.getMoveFromComputerConnectFour(model, board.getSizeLine(), board.getSizeColumn());

            while (true) {
                int col = userInteraction.getSecRandom(sizeColumn);

                if (col < 0 || col >= sizeColumn) {
                    boardView.displayText("Colonne invalide. Veuillez entrer un numéro entre 1 et " + sizeColumn + ".");
                    continue;
                }

                int row = -1;
                for (int i = sizeLine - 1; i >= 0; i--) {
                    if (model.isEmpty(i, col)) {
                        row = i;
                        break;
                    }
                }

                if (row == -1) {
                    boardView.displayText("Cette colonne est pleine. Veuillez choisir une autre colonne.");
                    continue;
                }

                move = new int[]{row, col};
                break;
            }

        }
        model.setPlayerMove(move[0], move[1], currentPlayer);
    }

}