package fr.le_campus_numerique.java.TicTacToe.view.game;

import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;
import fr.le_campus_numerique.java.TicTacToe.controller.GameController;

public class TicTacToeView extends BoardView {

    public TicTacToeView(GameController controller) {
        super(controller);
    }

    public String display(int sizeLine, int sizeColumn, State[][] boardState) {
        StringBuilder displayBoard = new StringBuilder();
        for (int i = 0; i < sizeLine; i++) {
            displayBoard.append("|");
            for (int j = 0; j < sizeColumn; j++) {
                displayBoard.append(boardState[i][j].getRepresentation());
                displayBoard.append("|");
            }
            displayBoard.append("\n");
            if (i < sizeLine - 1) displayBoard.append("-".repeat(sizeColumn * 2 + 1)).append("\n");
        }
        return displayBoard.toString();
    }
}
