package fr.le_campus_numerique.java.TicTacToe.model;


import fr.le_campus_numerique.java.TicTacToe.model.cell.Cell;
import fr.le_campus_numerique.java.TicTacToe.model.cell.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;

public class BoardModel {
    protected int sizeLine;
    protected int sizeColumn;
    protected int nbIdenticalCell;

    public BoardModel(int sizeLine, int sizeColumn, int nbIdenticalCell) {
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
        this.nbIdenticalCell = nbIdenticalCell;

    }

    public int getSizeLine() {
        return sizeLine;
    }

    public int getSizeColumn() {
        return sizeColumn;
    }

    public void setOwner(int row, int col, Player currentPlayer, Cell[][] board) {
        board[row][col].setState(currentPlayer.getState());
    }

//    public void switchPlayer() {
//        if(currentPlayer == playerX){
//            currentPlayer = playerO;
//        }else{
//            currentPlayer = playerX;
//        }
//    }

    public boolean isBoardFull(Cell[][] board) {
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    protected boolean exist(int x, int y) {
        return x >= 0 && x < sizeLine && y >= 0 && y < sizeColumn;
    }

    public boolean isOver(Player currentPlayer, Cell[][] board) {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                if (checkDirection(i, j, 0, 1,currentState, board) // v = 1 donc direction est
                        || checkDirection(i, j, 1, 0,currentState, board) // u = 1 donc direction sud
                        || checkDirection(i, j, 1, 1,currentState, board) // u = 1 et v = 1 donc direction sud-est
                        || checkDirection(i, j, 1, -1,currentState, board))  // u = 1 et v = -1 donc direction sud-ouest
                    return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, State currentState, Cell[][] board) {
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i+u*k, j + v*k)){
                return false;
            }
            if (board[i+u*k][j + v*k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

}