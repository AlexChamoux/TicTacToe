package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.GameRules;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;

public class TicTacToeController extends GameController {
//    int sizeLine = 3;
//    int sizeColumn = 3;
//    int[] move;

    public TicTacToeController() {
        super(3,3,3);
    }

//    public void move() {
//
//        if (currentPlayer instanceof HumanPlayer) {
////            move = userInteraction.getMoveFromHumanPlayer(currentPlayer.getState(), model, board.getSizeLine(), board.getSizeColumn());
//
//            while (true) {
//                    boardView.displayTextAndVariable(currentPlayer.getState());
//
//                    boardView.displayText("Numéro de ligne");
//                    int row = userInteraction.getUserInt() - 1;
//
//                    boardView.displayText("Numéro de colonne");
//                    int col = userInteraction.getUserInt() - 1;
//
//                    if (row < 0 || row >= sizeLine || col < 0 || col >= sizeColumn) {
//                        boardView.displayText("Coordonnées invalides. Les numéros doivent être entre 1 et " + sizeColumn + ".");
//                        continue;
//                    }
//
//                    if (!model.isEmpty(row, col)) {
//                        boardView.displayText("Cette case est déjà occupée. Veuillez choisir une autre case.");
//                        continue;
//                    }
//
//                    move = new int[]{row, col};
//                    break;
//            }
//
//        } else {
////            move = userInteraction.getMoveFromComputer(model, board.getSizeLine(), board.getSizeColumn());
//            while (true) {
//                int row = userInteraction.getSecRandom(sizeLine);
//                int col = userInteraction.getSecRandom(sizeColumn);
//
//                if (!model.isEmpty(row, col)) {
//                    System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
//                    continue;
//                }
//
//                move = new int[]{row, col};
//                break;
//            }
//        }
//        model.setPlayerMove(move[0], move[1], currentPlayer);
//    }

}
