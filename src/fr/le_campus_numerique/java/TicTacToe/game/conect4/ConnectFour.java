package fr.le_campus_numerique.java.TicTacToe.game.conect4;

import fr.le_campus_numerique.java.TicTacToe.game.BoardGame;
import fr.le_campus_numerique.java.TicTacToe.game.board.State;

public class ConnectFour extends BoardGame {

    public ConnectFour() {
        super(6, 7, 4);
    }

    public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < sizeLine; i++) {
            for(int j = 0; j < sizeColumn; j++) {
                for (int k = 0; k < nbIdenticalCell; k++) {
                    if (checkLine(i, j, k, currentState)
                            || checkColumn(i, j, k, currentState)
                            || checkFirstDiagonal(i, j, k, currentState)
                            || checkSecondDiagonal(i, j, k, currentState)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean checkLine(int i, int j, int k, State currentState){
        if (exist(i, (j + k)) && !(board[i][j+k].getState() == currentState)) {
            return false;
        }
        return true;
    }

    private boolean checkColumn(int i, int j, int k, State currentState){
        if (exist((i+k), j) && !(board[i+k][j].getState() == currentState)) {
            return false;
        }
        return true;
    }

    private boolean checkFirstDiagonal(int i, int j, int k, State currentState){
        if (exist(i + k,j + k) && !(board[i+k][j+k].getState() == currentState)) {
            return false;
        }
        return true;
    }

    private boolean checkSecondDiagonal(int i, int j, int k, State currentState){
        if (exist(i + k,j - k) && !(board[i+k][j-k].getState() == currentState)) {
            return false;
        }
        return true;
    }

}
