package fr.le_campus_numerique.java.TicTacToe.controller;


import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.cell.Cell;
import fr.le_campus_numerique.java.TicTacToe.model.cell.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;
import fr.le_campus_numerique.java.TicTacToe.view.game.DisplayBoardView;
import fr.le_campus_numerique.java.TicTacToe.controller.game.TicTacToeController;
import fr.le_campus_numerique.java.TicTacToe.controller.game.GomokuController;
import fr.le_campus_numerique.java.TicTacToe.controller.game.ConnectFourController;

public abstract class GameController {
    protected UserInteraction userInteraction;
    protected BoardModel model;
    protected GameController game;
    protected BoardView boardView;
    protected DisplayBoardView displayBoardView;
    protected Cell[][] board;
    protected Player playerX;
    protected Player playerO;
    protected Player currentPlayer;


    public GameController(int sizeLine, int sizeColumn, int nbIdenticalCell) {
        this.board = new Cell[sizeLine][sizeColumn];
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j] = new Cell();
            }
        }
        this.userInteraction = new UserInteraction();
        this.model = new BoardModel();
        this.boardView = new BoardView();
    }

    public void wichGamePlay() {
        boardView.displayText("Bien le bonjour joueur émérite, à quel jeu désires-tu jouer ?");
        boardView.displayText("Tape 1 pour jouer au Morpion, 2 pour jouer au Gomoku, et 3 pour le Puissance 4");
        int choice = userInteraction.getUserInt();

        switch (choice) {
            case 1:
                game = new TicTacToeController();
                break;
            case 2:
                game = new GomokuController();
                break;
            case 3:
                game = new ConnectFourController();
                break;
            default:
                boardView.displayText("Choix invalide. Merci de réessayer.");
        }

        game.start();
    }

    public void start() {
        definedPlayer();

        while (true) {
            boardView.displayBoard(displayBoardView.display(model.getSizeLine(), sizeColumn, board));

            move();

            if (model.isOver(currentPlayer, sizeLine, sizeColumn, nbIdenticalCell, board)) {
                boardView.winGame(displayBoardView.display(sizeLine, sizeColumn, board), currentPlayer.getState());
                break;
            }

            if(model.isBoardFull(sizeLine, sizeColumn, board)){
                boardView.drawGame(displayBoardView.display(sizeLine, sizeColumn, board));
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
