package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;

public class GomokuController extends GameController {

    public GomokuController() {
        super(15,15,5);
    }

    public void move() {
        int[] move;
        if (currentPlayer instanceof HumanPlayer) {
            move = userInteraction.getMoveFromHumanPlayer(currentPlayer.getState(), model, board.getSizeLine(), board.getSizeColumn());
        } else {
            move = userInteraction.getMoveFromComputer(model, board.getSizeLine(), board.getSizeColumn());
        }
        model.setOwner(move[0], move[1], currentPlayer);
    }

}
