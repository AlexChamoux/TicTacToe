package fr.le_campus_numerique.java.TicTacToe.view.game;

import fr.le_campus_numerique.java.TicTacToe.model.cell.Cell;

public interface DisplayBoardView {

    public String display(int sizeLine, int sizeColumn, Cell[][] board);
}
