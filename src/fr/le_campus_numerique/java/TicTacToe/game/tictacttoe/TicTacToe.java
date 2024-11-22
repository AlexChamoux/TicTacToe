package fr.le_campus_numerique.java.TicTacToe.game.tictacttoe;

import fr.le_campus_numerique.java.TicTacToe.game.board.State;
import fr.le_campus_numerique.java.TicTacToe.game.BoardGame;

public class TicTacToe extends BoardGame {

    public TicTacToe(){
        super(3, 3, 3);
    }

    public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
                if(checkLine(i, currentState) || checkColumn(i, currentState) || checkFirstDiagonal(currentState) || checkSecondDiagonal(currentState)){
                    return true;
                }
        }
        return false;
    }

    private boolean checkLine(int row, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (exist(row, k) && !(board[row][k].getState() == currentState)){
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (exist(col, k) && !(board[k][col].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiagonal(State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (exist(k,k) && !(board[k][k].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal(State currentState){
        for (int k = 0; k < nbIdenticalCell; k++) {
            if (exist(k,(sizeLine-1)-k) && !(board[k][(sizeLine-1)-k].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

}