package fr.le_campus_numerique.java.TicTacToe.model;

public class Cell {

    private State state;

    public Cell(){
        this.state = State.EMPTY;
    }

    public String getRepresentation(){
        return this.state.getRepresentation();
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public boolean isEmpty(){
        return state == State.EMPTY;
    }

}