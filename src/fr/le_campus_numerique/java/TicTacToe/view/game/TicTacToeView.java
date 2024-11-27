package fr.le_campus_numerique.java.TicTacToe.view.game;

import fr.le_campus_numerique.java.TicTacToe.model.cell.Cell;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;

public class TicTacToeView extends BoardView implements DisplayBoardView {

    public String display(int sizeLine, int sizeColumn, Cell[][] board) {
        StringBuilder displayBoard = new StringBuilder();
        for (int i = 0; i < sizeLine; i++) {
            displayBoard.append("|");
            for (int j = 0; j < sizeColumn; j++) {
                displayBoard.append(board[i][j].getRepresentation());
                displayBoard.append("|");
            }
            displayBoard.append("\n");
            if (i < sizeLine - 1) displayBoard.append("-".repeat(sizeColumn * 2 + 1)).append("\n");
        }
        return displayBoard.toString();
    }


}
