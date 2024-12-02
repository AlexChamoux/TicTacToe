package fr.le_campus_numerique.java.TicTacToe.model;


import fr.le_campus_numerique.java.TicTacToe.model.board.Board;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;

public class GameRules {
    protected Board board;

    public GameRules(Board board) {
        this.board = board;
    }

    public boolean isEmpty(int row, int col) {
        return board.isEmpty(row, col);
    }

    public void setPlayerMove(int row, int col, Player currentPlayer) {
        board.setCellState(row, col, currentPlayer.getState());
    }

    protected boolean exist(int x, int y) {
        return x >= 0 && x < board.getSizeLine() && y >= 0 && y < board.getSizeColumn();
    }

    public boolean isOver(Player currentPlayer, int nbIdenticalCell) {
        State currentState = currentPlayer.getState();
        int sizeLine = board.getSizeLine();
        int sizeColumn = board.getSizeColumn();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                if (checkDirection(i, j, 0, 1,currentState, nbIdenticalCell) // v = 1 donc direction est
                        || checkDirection(i, j, 1, 0,currentState, nbIdenticalCell) // u = 1 donc direction sud
                        || checkDirection(i, j, 1, 1,currentState, nbIdenticalCell) // u = 1 et v = 1 donc direction sud-est
                        || checkDirection(i, j, 1, -1,currentState, nbIdenticalCell))  // u = 1 et v = -1 donc direction sud-ouest
                    return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, State currentState, int nbIdenticalCell) {
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i+u*k, j + v*k)){
                return false;
            }
            if (board.getCellState(i+u*k, j + v*k) != currentState) {
                return false;
            }
        }
        return true;
    }

}