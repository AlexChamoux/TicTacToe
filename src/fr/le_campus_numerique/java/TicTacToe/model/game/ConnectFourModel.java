package fr.le_campus_numerique.java.TicTacToe.model.game;

import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;

public class ConnectFourModel extends BoardModel {

    public ConnectFourModel() {
        super(6, 7, 4);
    }

//    public void play() {
//        int choice = boardController.playController();
//
//        if (choice == 1) {
//            playerX = new HumanPlayer(State.X);
//            playerO = new HumanPlayer(State.O);
//        }else if (choice == 2) {
//            playerX = new HumanPlayer(State.X);
//            playerO = new ArtificialPlayer(State.O);
//        }else if (choice == 3) {
//            playerX = new ArtificialPlayer(State.X);
//            playerO = new ArtificialPlayer(State.O);
//        }
//
//        currentPlayer = playerX;
//
//        while (true) {
//            view.displayBoard(boardView.display(sizeLine, sizeColumn, board));
//
//            if(currentPlayer instanceof HumanPlayer) {
//                int[] move = boardController.moveHumanConnectFour(currentPlayer.getState(), board, sizeLine, sizeColumn);
//                setOwner(move[0], move[1]);
//            }else if (currentPlayer instanceof ArtificialPlayer) {
//                int[] move = boardController.moveComputerConnectFour(board, sizeLine, sizeColumn);
//                setOwner(move[0], move[1]);
//            }
//
//            if (isOver()) {
//                view.winGame(boardView.display(sizeLine, sizeColumn, board), currentPlayer.getState());
//                break;
//            }
//
//            if(isBoardFull()){
//                view.drawGame(boardView.display(sizeLine, sizeColumn, board));
//                break;
//            }
//
//            switchPlayer();
//        }
//    }
}
