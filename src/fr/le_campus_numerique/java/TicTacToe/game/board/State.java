package fr.le_campus_numerique.java.TicTacToe.game.board;

public enum State {
        EMPTY("   "),
        X(" X "),
        O(" O ");

    private final String representation;

    private State (String representation){
        this.representation = representation;
    }

    public String getRepresentation(){
        return this.representation;
    }
}
