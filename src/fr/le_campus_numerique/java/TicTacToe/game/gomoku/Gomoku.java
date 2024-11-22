package fr.le_campus_numerique.java.TicTacToe.game.gomoku;

import fr.le_campus_numerique.java.TicTacToe.game.BoardGame;
import fr.le_campus_numerique.java.TicTacToe.game.board.State;

public class Gomoku extends BoardGame {

    public Gomoku() {
        super(15, 15, 5);
    }

    public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                System.out.println("I : " + i + ", J : " + j);

                if (checkLine(i, j, currentState)
                        || checkColumn(i, j, currentState)
                        || checkFirstDiagonal(i, j, currentState)
                        || checkSecondDiagonal(i, j, currentState)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean checkLine(int i, int j, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i, j + k)){
                return false;
            }
            if (board[i][j + k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int i, int j, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i + k, j)){
                return false;
            }
            if (board[i + k][j].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiagonal(int i, int j, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i + k, j + k)){
                return false;
            }
            if (board[i + k][j + k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal(int i, int j, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (!exist(i + k, j - k)){
                return false;
            }
            if (board[i + k][j - k].getState() != currentState) {
                return false;
            }
        }
        return true;
    }
}
