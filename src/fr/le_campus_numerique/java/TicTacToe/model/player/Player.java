
package fr.le_campus_numerique.java.TicTacToe.model.player;

import fr.le_campus_numerique.java.TicTacToe.model.board.State;

public abstract class Player {

    private State state;

    public Player(State state) {
        this.state = state;
    }

    public String getRepresentation(){
        return state.getRepresentation();
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }
}
