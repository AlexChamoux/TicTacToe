package fr.le_campus_numerique.java.TicTacToe;

import fr.le_campus_numerique.java.TicTacToe.controller.GameController;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        GameController controller = new GameController();
        controller.wichGamePlay();
    }
}