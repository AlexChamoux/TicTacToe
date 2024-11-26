package fr.le_campus_numerique.java.TicTacToe.model;


import fr.le_campus_numerique.java.TicTacToe.model.player.Player;

public class BoardModel {
    protected int sizeLine;
    protected int sizeColumn;
    protected int nbIdenticalCell;
    protected Cell[][] board;
    protected Player playerX;
    protected Player playerO;
    protected Player currentPlayer;


    public BoardModel(int sizeLine, int sizeColumn, int nbIdenticalCell) {
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
        this.nbIdenticalCell = nbIdenticalCell;
        this.board = new Cell[sizeLine][sizeColumn];
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public int getSizeLine() {
        return sizeLine;
    }

    public int getSizeColumn() {
        return sizeColumn;
    }

    public Cell[][] getBoard() {
        return board;
    }

    public Player getPlayerX() {
        return playerX;
    }

    public void setPlayerX(Player playerX) {
        this.playerX = playerX;
    }

    public Player getPlayerO() {
        return playerO;
    }

    public void setPlayerO(Player playerO) {
        this.playerO = playerO;
    }

    public Player getCurrentPlayer() {
        return currentPlayer;
    }

    public void setCurrentPlayer(Player currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setOwner(int row, int col, Player currentPlayer) {
        board[row][col].setState(currentPlayer.getState());
    }

    public void switchPlayer(Player currentPlayer, Player playerX, Player playerO) {
        if(currentPlayer == playerX){
            currentPlayer = playerO;
        }else{
            currentPlayer = playerX;
        }
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

}