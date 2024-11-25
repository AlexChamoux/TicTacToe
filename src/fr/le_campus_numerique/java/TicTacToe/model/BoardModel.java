package fr.le_campus_numerique.java.TicTacToe.model;

public class BoardModel {
    protected int sizeLine;
    protected int sizeColumn;
    protected int nbIdenticalCell;
    private Cell[][] board;
    
    
    public BoardModel() {
        this.board = new Cell[sizeLine][sizeColumn];
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j] = new Cell();
            }
        }
    }
}
