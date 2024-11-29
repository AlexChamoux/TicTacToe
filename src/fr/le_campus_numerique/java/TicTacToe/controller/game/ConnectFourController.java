package fr.le_campus_numerique.java.TicTacToe.controller.game;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;

public class ConnectFourController extends GameController {

    public ConnectFourController() {
        super(6,7,4);
    }

    public void move() {
        int[] move;
        if (currentPlayer instanceof HumanPlayer) {
            move = userInteraction.getMoveFromHumanPlayerConnectFour(currentPlayer.getState(), model, board.getSizeLine(), board.getSizeColumn());
        } else {
            move = userInteraction.getMoveFromComputerConnectFour(model, board.getSizeLine(), board.getSizeColumn());
        }
        model.setOwner(move[0], move[1], currentPlayer);
    }

}