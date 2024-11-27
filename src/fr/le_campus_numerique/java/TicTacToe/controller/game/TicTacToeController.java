package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;

public class TicTacToeController extends GameController {

    public TicTacToeController() {
        super(3,3,3);

    }

    public void move() {
        int[] move;
        if (currentPlayer instanceof HumanPlayer) {
            move = userInteraction.getMoveFromHumanPlayer(currentPlayer.getState(), board, model.getSizeLine(), model.getSizeColumn());
        } else {
            move = userInteraction.getMoveFromComputer(board, model.getSizeLine(), model.getSizeColumn());
        }
        model.setOwner(move[0], move[1], currentPlayer, board);
    }

}
