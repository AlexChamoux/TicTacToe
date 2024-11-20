package fr.le_campus_numerique.java.TicTacToe;

public class HumanPlayer extends Player {
    private UserInteraction userInteraction;

    public HumanPlayer(String representation, UserInteraction userInteraction) {
        super(representation);
        this.userInteraction = userInteraction;
    }
}
