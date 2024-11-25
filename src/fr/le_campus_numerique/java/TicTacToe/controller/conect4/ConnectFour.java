package fr.le_campus_numerique.java.TicTacToe.controller.conect4;

import fr.le_campus_numerique.java.TicTacToe.controller.BoardGame;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.view.BoardGameView;

public class ConnectFour extends BoardGame {
    BoardGameView boardGameView;

    public ConnectFour() {
        super(6, 7, 4);
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
            view.displayBoard(boardGameView.display(sizeLine, sizeColumn, board));

            if(currentPlayer instanceof HumanPlayer) {
                int[] move = userInteraction.getMoveFromHumanPlayerConnectFour(currentPlayer.getState(), board, sizeLine, sizeColumn);
                setOwner(move[0], move[1]);
            }else if (currentPlayer instanceof ArtificialPlayer) {
                int[] move = userInteraction.getMoveFromComputer(board, sizeLine, sizeColumn);
                setOwner(move[0], move[1]);
            }

            if (isOver()) {
                view.winGame(boardGameView.display(sizeLine, sizeColumn, board), currentPlayer.getState());
                break;
            }

            if(isBoardFull()){
                view.drawGame(boardGameView.display(sizeLine, sizeColumn, board));
                break;
            }

            switchPlayer();
        }
    }
}
