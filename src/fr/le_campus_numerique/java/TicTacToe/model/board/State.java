package fr.le_campus_numerique.java.TicTacToe.model.board;

public enum State {
        EMPTY("   "),
        X(" X "),
        O(" O ");

    private final String representation;

    State(String representation){
        this.representation = representation;
    }

    public String getRepresentation(){
        return this.representation;
    }
}
