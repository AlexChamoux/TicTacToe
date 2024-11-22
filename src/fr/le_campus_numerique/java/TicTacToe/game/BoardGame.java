package fr.le_campus_numerique.java.TicTacToe.game;


import fr.le_campus_numerique.java.TicTacToe.game.board.Cell;
import fr.le_campus_numerique.java.TicTacToe.game.board.State;
import fr.le_campus_numerique.java.TicTacToe.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.player.Player;
import fr.le_campus_numerique.java.TicTacToe.user_in_out.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.user_in_out.View;

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
                int[] move = userInteraction.getMoveFromHumanPlayer(currentPlayer.getState(), board, sizeLine, sizeColumn);
                setOwner(move[0], move[1]);
            }else if (currentPlayer instanceof ArtificialPlayer) {
                int[] move = userInteraction.getMoveFromComputer(board, sizeLine, sizeColumn);
                setOwner(move[0], move[1]);
            }

            if (isOver()) {
                view.winGame(display(), currentPlayer.getState());
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