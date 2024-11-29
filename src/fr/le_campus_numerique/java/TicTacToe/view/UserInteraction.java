
package fr.le_campus_numerique.java.TicTacToe.view;

import java.util.Scanner;
import java.security.SecureRandom;

public class UserInteraction {
    private final Scanner scanner;
    final SecureRandom secureRandom = new SecureRandom();
    private BoardView boardView;

    public UserInteraction(){
        this.scanner = new Scanner(System.in);
        this.boardView = new BoardView();
    }

    public int getSecRandom(int sizeLine) {
        return secureRandom.nextInt(sizeLine);
    }

    public int getUserInt() {
        while (true) {
            try {
                return Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                boardView.displayText("Entrée invalide. Veuillez entrer un nombre.");
            }
        }
    }

    public String getUserString(){
        return scanner.nextLine();
    }

}
