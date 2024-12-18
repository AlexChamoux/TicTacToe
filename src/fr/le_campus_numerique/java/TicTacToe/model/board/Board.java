package fr.le_campus_numerique.java.TicTacToe.model.board;

public class Board {
    protected int sizeLine;
    protected int sizeColumn;
    protected Cell[][] board;

    public Board(int sizeLine, int sizeColumn) {
        this.sizeLine = sizeLine;
        this.sizeColumn = sizeColumn;
        this.board = new Cell[sizeLine][sizeColumn];
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j] = new Cell();
            }
        }
    }

    public boolean isFull() {
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                if (board[i][j].isEmpty()) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isEmpty(int row, int col) {
        return row >= 0 && row < sizeLine && col >= 0 && col < sizeColumn && board[row][col].isEmpty();
    }

    public State getCellState(int row, int col) {
        if (row >= 0 && row < sizeLine && col >= 0 && col < sizeColumn) {
            return board[row][col].getState();
        }
        return null;
    }

    public boolean setCellState(int row, int col, State state) {
        if (row >= 0 && row < sizeLine && col >= 0 && col < sizeColumn) {
            return board[row][col].occupy(state);
        }
        return false;
    }

    public int getSizeLine() {
        return sizeLine;
    }

    public int getSizeColumn() {
        return sizeColumn;
    }

    public void clear() {
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                board[i][j].clear();
            }
        }
    }

    public String getRepresentation() {
        String rep = createLine();
        for (int i = 0; i < sizeLine; i++) {
            for (int j = 0; j < sizeColumn; j++) {
                rep = rep + board[i][j].getRepresentation();
            }
            rep = rep + "|\n";
            rep += createLine();
        }
        return rep;
    }

    private String createLine(){
        String line = "";
        for (int j = 0; j < sizeColumn; j++) {
            line = line + Cell.getHorRep();
        }
        line = line + "\n";
        return line;
    }

}
