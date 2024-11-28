package fr.le_campus_numerique.java.TicTacToe.controller;


import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.board.Board;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;

public abstract class GameController {
    protected UserInteraction userInteraction;
    protected BoardModel model;
    protected BoardView boardView;
    protected Player playerX;
    protected Player playerO;
    protected Player currentPlayer;
    protected Board board;
    protected int nbIdenticalCell;


    public GameController(int sizeLine, int sizeColumn, int nbIdenticalCell, BoardView view) {
        this.board = new Board(sizeLine, sizeColumn);
        this.nbIdenticalCell = nbIdenticalCell;
        this.userInteraction = new UserInteraction();
        this.model = new BoardModel(board);
        this.boardView = view;
    }

    public void start() {
        definedPlayer();

        while (true) {
            boardView.displayBoard(boardView.display(board.getSizeLine(), board.getSizeColumn(), board.getBoardState()));

            move();

            if (model.isOver(currentPlayer, nbIdenticalCell)) {
                boardView.winGame(boardView.display(board.getSizeLine(), board.getSizeColumn(), board.getBoardState()),
                        currentPlayer.getState());
                break;
            }

            if(board.isFull()){
                boardView.drawGame(boardView.display(board.getSizeLine(), board.getSizeColumn(), board.getBoardState()));
                break;
            }

            switchPlayer();
        }
    }

    private void definedPlayer() {


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
    }

    public abstract void move();

    public void switchPlayer() {
        if(currentPlayer == playerX){
            currentPlayer = playerO;
        }else{
            currentPlayer = playerX;
        }
    }



}
