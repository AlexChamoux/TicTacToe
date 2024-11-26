package fr.le_campus_numerique.java.TicTacToe.model.gomoku;

import fr.le_campus_numerique.java.TicTacToe.model.BoardModel;
import fr.le_campus_numerique.java.TicTacToe.model.State;
import fr.le_campus_numerique.java.TicTacToe.model.player.ArtificialPlayer;
import fr.le_campus_numerique.java.TicTacToe.model.player.HumanPlayer;
import fr.le_campus_numerique.java.TicTacToe.view.BoardView;

public class Gomoku extends BoardModel {
    BoardView boardView;


    public Gomoku() {
        super(15, 15, 5);
        this.boardView = new BoardView();
    }

}
