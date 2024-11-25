package fr.le_campus_numerique.java.TicTacToe.controller;


import fr.le_campus_numerique.java.TicTacToe.model.Cell;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;
import fr.le_campus_numerique.java.TicTacToe.root.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.view.View;

public abstract class BoardGame {
    protected int sizeLine;
    protected int sizeColumn;
    protected int nbIdenticalCell;
    protected Cell[][] board;
    protected Player playerX;
    protected Player playerO;
    protected Player currentPlayer;
    protected UserInteraction userInteraction;
    protected View view;

    public BoardGame(int sizeLine, int sizeColumn, int nbIdenticalCell) {
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
        this.nbIdenticalCell = nbIdenticalCell;
        this.userInteraction = new UserInteraction();
        this.view = new View();
        this.board = new Cell[sizeLine][sizeColumn];
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public String display() {
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

    public void setOwner(int row, int col) {
        board[row][col].setState(currentPlayer.getState());
    }

    public void switchPlayer() {
        currentPlayer = (currentPlayer == playerX) ? playerO : playerX;
    }

    public boolean isBoardFull() {
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

    public abstract void play();

    public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                if (checkDirection(i, j, 0, 1,currentState) // v = 1 donc direction est
                        || checkDirection(i, j, 1, 0,currentState) // u = 1 donc direction sud
                        || checkDirection(i, j, 1, 1,currentState) // u = 1 et v = 1 donc direction sud-est
                        || checkDirection(i, j, 1, -1,currentState))  // u = 1 et v = -1 donc direction sud-ouest
                    return true;
            }
        }
        return false;
    }

    private boolean checkDirection(int i, int j, int u, int v, State currentState){
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

    //    public boolean isOver() {
//        State currentState = currentPlayer.getState();
//
//        for (int i = 0; i < sizeLine; i++) {
//            for(int j = 0; j < sizeColumn; j++) {
//                for (int k = 0; k < nbIdenticalCell; k++) {
//                    if (checkLine(i, j, k, currentState)
//                            || checkColumn(i, j, k, currentState)
//                            || checkFirstDiagonal(i, j, k, currentState)
//                            || checkSecondDiagonal(i, j, k, currentState)) {
//                        return true;
//                    }
//                }
//            }
//        }
//        return false;
//    }
//
//    private boolean checkLine(int i, int j, int k, State currentState){
//        if (exist(i, (j + k)) && !(board[i][j+k].getState() == currentState)) {
//            return false;
//        }
//        return true;
//    }
//
//    private boolean checkColumn(int i, int j, int k, State currentState){
//        if (exist((i+k), j) && !(board[i+k][j].getState() == currentState)) {
//            return false;
//        }
//        return true;
//    }
//
//    private boolean checkFirstDiagonal(int i, int j, int k, State currentState){
//        if (exist(i + k,j + k) && !(board[i+k][j+k].getState() == currentState)) {
//            return false;
//        }
//        return true;
//    }
//
//    private boolean checkSecondDiagonal(int i, int j, int k, State currentState){
//        if (exist(i + k,j - k) && !(board[i+k][j-k].getState() == currentState)) {
//            return false;
//        }
//        return true;
//    }

}