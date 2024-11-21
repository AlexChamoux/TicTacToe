package fr.le_campus_numerique.java.TicTacToe.game.tictacttoe;

import fr.le_campus_numerique.java.TicTacToe.Cell;
import fr.le_campus_numerique.java.TicTacToe.State;
import fr.le_campus_numerique.java.TicTacToe.game.BoardGame;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.player.Player;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.user_in_out.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.game.tictacttoe.user_in_out.View;

public class TicTacToe extends BoardGame {
    private static final int size = 3;
    private Cell[][] board;
    private Player playerX;
    private Player playerO;
    private Player currentPlayer;
    private UserInteraction userInteraction;
    private View view;

    public TicTacToe(){
        this.userInteraction = new UserInteraction();
        this.view = new View();
        this.board = new Cell[size][size];
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public String display(){
        StringBuilder displayBoard = new StringBuilder();

        for(int i = 0; i < size; i++){
            displayBoard.append("|");
            for(int j = 0; j < size; j++){
                displayBoard.append(board[i][j].getRepresentation());
                displayBoard.append("|");
            }
            displayBoard.append("\n");
            if (i < size - 1) displayBoard.append("-----------\n");
        }

        return displayBoard.toString();
    }

    public void setOwner(int row, int col) {
        board[row][col].setState(currentPlayer.getState());
    }

    public void switchPlayer() {
        if (currentPlayer == playerX) {
            currentPlayer = playerO;
        }else{
            currentPlayer = playerX;
        }
    }

    public void play() {
        int choice = userInteraction.typeOfPlayer();

        if (choice == 1) {
            playerX = new HumanPlayer(State.X);
            playerO = new HumanPlayer(State.O);
        }else if (choice == 2) {
            playerX = new HumanPlayer(State.X);
            playerO = new ArtificialPlayer(State.O);
        }else if (choice == 3) {
            playerX = new ArtificialPlayer(State.X);
            playerO = new ArtificialPlayer(State.O);
        }

        currentPlayer = playerX;

        while (true) {
            view.displayBoard(display());

            if(currentPlayer instanceof HumanPlayer) {
                int[] move = userInteraction.getMoveFromHumanPlayer(currentPlayer.getRepresentation(), board, size);
                setOwner(move[0], move[1]);
            }else if (currentPlayer instanceof ArtificialPlayer) {
                int[] move = userInteraction.getMoveFromComputer(board, size);
                setOwner(move[0], move[1]);
            }

            if (isOver()) {
                view.winGame(display(), currentPlayer.getRepresentation());
                break;
            }

            if(isBoardFull()){
                view.drawGame(display());
                break;
            }

            switchPlayer();
        }
    }

    public boolean isOver() {
        State currentState = currentPlayer.getState();

        for (int i = 0; i < size; i++) {
                if(checkLine(i, currentState) || checkColumn(i, currentState) || checkFirstDiagonal(currentState) || checkSecondDiagonal(currentState)){
                    return true;
                }
        }
        return false;
    }

    private boolean checkLine(int row, State currentState){
        for (int k = 0; k < 3; k++) { // 3 correspond aux nombres de cellules qui doivent être égal pour valider
            if (exist(row, k) && !(board[row][k].getState() == currentState)){
                return false;
            }
        }
        return true;
    }

    private boolean checkColumn(int col, State currentState){
        for (int k = 0; k < 3; k++) {
            if (exist(col, k) && !(board[k][col].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkFirstDiagonal(State currentState){
        for (int i = 0; i < 3; i++) {
            if (exist(i,i) && !(board[i][i].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

    private boolean checkSecondDiagonal(State currentState){
        for (int i = 0; i < 3; i++) {
            if (exist(i,(size-1)-i) && !(board[i][(size-1)-i].getState() == currentState)) {
                return false;
            }
        }
        return true;
    }

    private boolean exist(int x, int y){
        if (x < 0 || x > size - 1 || y < 0 || y > size - 1){
            return false;
        }
        return true;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

}