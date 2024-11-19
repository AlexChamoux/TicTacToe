package fr.le_campus_numerique.java.TicTacToe;

public class Cell {
    private String representation;

    public Cell() {
        this.representation = "   ";
    }

    public String getRepresentation(){
        return representation;
    }

    public void setRepresentation(String representation){
        this.representation = representation;
    }
}
