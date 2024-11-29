package fr.le_campus_numerique.java.TicTacToe.model.board;

public class Cell {

    private State state;

    public Cell(){
        this.state = State.EMPTY;
    }

    public String getRepresentation(){
        return "|" + this.state.getRepresentation();
    }

    public static String getHorRep(){
        return "----";
    }

    public State getState() {
        return this.state;
    }

    public void setState(State state){
        this.state = state;
    }

    public boolean occupy(State state){
        if(this.isEmpty() && state != State.EMPTY){
            setState(state);
            return true;
        }
        return false;
    }

    public boolean isEmpty(){
        return state == State.EMPTY;
    }

    public void clear(){
        setState(State.EMPTY);
    }

}