import java.util.Scanner;

public class TicTacToe {
    private final Scanner scanner = new Scanner(System.in);
    int size = 3;
    Cell[][] displayBoard;
    Player player;

    public TicTacToe(){
        displayBoard = new Cell[size][size];

        for(int i = 0; i < size; i++){
            for(int j = 0; j < size; j++){
                 displayBoard[i][j] = new Cell();
            }
        }
    }

    public String display(){
        StringBuilder board = new StringBuilder();

        for(int i = 0; i < size; i++){
            board.append("|");
            for(int j = 0; j < size; j++){
                board.append(displayBoard[i][j].getRepresentation());
                board.append("|");
            }
            board.append("\n");
            if (i < size - 1) board.append("-----------\n");
        }

        return board.toString();
    }

    public getMovefromPlayer(){
        System.out.println("Veuillez sélectionner l'emplacement de votre 'O' en le désignant par son numéro de colonne et de ligne (ex: en haut à gauche = 1 ; 1 )");
        scanner.nextInt();


        return ;
    }



}
