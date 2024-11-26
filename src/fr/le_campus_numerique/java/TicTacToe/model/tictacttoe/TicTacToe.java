package fr.le_campus_numerique.java.TicTacToe.model.tictacttoe;

import fr.le_campus_numerique.java.TicTacToe.controller.BoardController;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;


public class TicTacToe extends BoardModel {
    BoardView boardView;
    BoardController boardController;

    public TicTacToe(){
        super(3, 3, 3);
        this.boardView = new BoardView();
    }

}