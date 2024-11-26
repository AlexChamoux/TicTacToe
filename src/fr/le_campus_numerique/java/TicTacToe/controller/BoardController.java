package fr.le_campus_numerique.java.TicTacToe.controller;


import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.model.connect4.ConnectFour;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.GameController;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;
import fr.le_campus_numerique.java.TicTacToe.view.View;

public class BoardController {
    protected UserInteraction userInteraction;
    protected BoardModel model;
    protected BoardView boardView;
    protected View view;
    protected GameController gameController;


    public BoardController() {
        this.userInteraction = new UserInteraction();
        this.boardView = new BoardView();
        this.view = new View();
        this.gameController = new GameController();
    }

    public void play() {
        model = gameController.wichGamePlay();

        int choice = userInteraction.typeOfPlayer();

        if (choice == 1) {
            model.setPlayerX(new HumanPlayer(State.X));
            model.setPlayerO(new HumanPlayer(State.O));
        }else if (choice == 2) {
            model.setPlayerX(new HumanPlayer(State.X));
            model.setPlayerO(new ArtificialPlayer(State.O));
        }else if (choice == 3) {
            model.setPlayerX(new ArtificialPlayer(State.X));
            model.setPlayerO(new ArtificialPlayer(State.O));
        }

        model.setCurrentPlayer(model.getPlayerX());

        while (true) {
            view.displayBoard(boardView.display(model.getSizeLine(), model.getSizeColumn(), model.getBoard()));

            if(!(model instanceof ConnectFour)) {
                if (model.getCurrentPlayer() instanceof HumanPlayer) {
                    int[] move = userInteraction.getMoveFromHumanPlayer(model.getCurrentPlayer().getState(), model.getBoard(), model.getSizeLine(), model.getSizeColumn());
                    model.setOwner(move[0], move[1], model.getCurrentPlayer());
                } else if (model.getCurrentPlayer() instanceof ArtificialPlayer) {
                    int[] move = userInteraction.getMoveFromComputer(model.getBoard(), model.getSizeLine(), model.getSizeColumn());
                    model.setOwner(move[0], move[1], model.getCurrentPlayer());
                }
            }else{
                if (model.getCurrentPlayer() instanceof HumanPlayer) {
                    int[] move = userInteraction.getMoveFromHumanPlayerConnectFour(model.getCurrentPlayer().getState(), model.getBoard(), model.getSizeLine(), model.getSizeColumn());
                    model.setOwner(move[0], move[1], model.getCurrentPlayer());
                } else if (model.getCurrentPlayer() instanceof ArtificialPlayer) {
                    int[] move = userInteraction.getMoveFromComputerConnectFour(model.getBoard(), model.getSizeLine(), model.getSizeColumn());
                    model.setOwner(move[0], move[1], model.getCurrentPlayer());
                }
            }

            if (model.isOver()) {
                view.winGame(boardView.display(model.getSizeLine(), model.getSizeColumn(), model.getBoard()), model.getCurrentPlayer().getState());
                break;
            }

            if(model.isBoardFull()){
                view.drawGame(boardView.display(model.getSizeLine(), model.getSizeColumn(), model.getBoard()));
                break;
            }

            model.switchPlayer(model.getCurrentPlayer(), model.getPlayerX(), model.getPlayerO());
        }
    }

}
