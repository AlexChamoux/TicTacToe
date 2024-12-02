package fr.le_campus_numerique.java.TicTacToe.controller;


import fr.le_campus_numerique.java.TicTacToe.model.GameRules;
import fr.le_campus_numerique.java.TicTacToe.model.board.Board;
import fr.le_campus_numerique.java.TicTacToe.model.board.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.Player;
import fr.le_campus_numerique.java.TicTacToe.view.View;
import fr.le_campus_numerique.java.TicTacToe.view.UserInteraction;

public abstract class GameController {
    protected UserInteraction userInteraction;
    protected GameRules model;
    protected View view;
    protected Player playerX;
    protected Player playerO;
    protected Player currentPlayer;
    protected Board board;
    protected int nbIdenticalCell;
    protected int sizeLine;
    protected int sizeColumn;
    protected int[] move;


    public GameController(int sizeLine, int sizeColumn, int nbIdenticalCell) {
        this.board = new Board(sizeLine, sizeColumn);
        this.nbIdenticalCell = nbIdenticalCell;
        this.userInteraction = new UserInteraction();
        this.model = new GameRules(board);
        this.view = new View();
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
    }

    public void start() {
        definedPlayer();

        while (true) {
            view.display(board.getRepresentation());

            move();

            if (model.isOver(currentPlayer, nbIdenticalCell)) {
                String representation = board.getRepresentation();
                String winnerState = currentPlayer.getState().toString();
                view.winGame(representation, winnerState);
                playAgain();
            }

            if(board.isFull()){
                view.drawGame(board.getRepresentation());
                playAgain();
            }

            switchPlayer();
        }
    }

    private void playAgain() {
        view.playAgain();
        String choice = userInteraction.getUserString();
        if (choice.equalsIgnoreCase("oui")) {
            board.clear();
            start();
        }else{
            System.exit(0);
        }
    }

    private void definedPlayer() {

        view.displayText("Veuillez choisir votre type de partie");
        view.displayText("Taper 1 pour joueur vs joueur, 2 pour joueur vs ordinateur et 3 pour ordi vs ordi");
        int choice = userInteraction.getUserInt();

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

    public void move() {

        if (currentPlayer instanceof HumanPlayer) {

            while (true) {
                String player = currentPlayer.getState().toString();
                view.displayTextAndVariable(player);

                view.displayText("Numéro de ligne");
                int row = userInteraction.getUserInt() - 1;

                view.displayText("Numéro de colonne");
                int col = userInteraction.getUserInt() - 1;

                if (row < 0 || row >= sizeLine || col < 0 || col >= sizeColumn) {
                    view.displayText("Coordonnées invalides. Les numéros doivent être entre 1 et " + sizeColumn + ".");
                    continue;
                }

                if (!model.isEmpty(row, col)) {
                    view.displayText("Cette case est déjà occupée. Veuillez choisir une autre case.");
                    continue;
                }

                move = new int[]{row, col};
                break;
            }

        } else {
            while (true) {
                int row = userInteraction.getSecRandom(sizeLine);
                int col = userInteraction.getSecRandom(sizeColumn);

                if (!model.isEmpty(row, col)) {
                    System.out.println("Cette case est déjà occupée. Veuillez choisir une autre case.");
                    continue;
                }

                move = new int[]{row, col};
                break;
            }
        }
        model.setPlayerMove(move[0], move[1], currentPlayer);
    }


    public void switchPlayer() {
        if(currentPlayer == playerX){
            currentPlayer = playerO;
        }else{
            currentPlayer = playerX;
        }
    }



}
