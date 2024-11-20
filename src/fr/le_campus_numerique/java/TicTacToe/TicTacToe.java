package fr.le_campus_numerique.java.TicTacToe;

import fr.le_campus_numerique.java.TicTacToe.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.player.Player;
import fr.le_campus_numerique.java.TicTacToe.view.UserInteraction;
import fr.le_campus_numerique.java.TicTacToe.view.View;

public class TicTacToe {
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
        board[row][col].setRepresentation(currentPlayer.getRepresentation());
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
            playerX = new HumanPlayer(" X ");
            playerO = new HumanPlayer(" O ");
        }else if (choice == 2) {
            playerX = new HumanPlayer(" X ");
            playerO = new ArtificialPlayer(" O ");
        }else if (choice == 3) {
            playerX = new ArtificialPlayer(" X ");
            playerO = new ArtificialPlayer(" O ");
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
        String currentSymbol = currentPlayer.getRepresentation().trim();

        for (int i = 0; i < size; i++) {
            if (checkLine(i, 0, 0, 1, currentSymbol) || checkLine(0, i, 1, 0, currentSymbol)) {
                return true;
            }
        }

        if (checkLine(0, 0, 1, 1, currentSymbol) || checkLine(0, size - 1, 1, -1, currentSymbol)) {
            return true;
        }

        return false;
    }

    private boolean checkLine(int startRow, int startCol, int rowIncrement, int colIncrement, String currentSymbol) {
        for (int i = 0; i < size; i++) {
            int row = startRow + i * rowIncrement;
            int col = startCol + i * colIncrement;
            if (!board[row][col].getRepresentation().trim().equals(currentSymbol)) {
                return false;
            }
        }
        return true;
    }

    public boolean isBoardFull() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j].getRepresentation().trim().isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

}