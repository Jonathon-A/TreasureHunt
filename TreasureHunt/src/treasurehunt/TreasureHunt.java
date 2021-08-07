package treasurehunt;

import java.util.Scanner;
import java.util.Random;

public class TreasureHunt {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Random rand = new Random();
        System.out.println("Welcome to treasure hunt, the map is 10 by 10 and has a random number of coins at each coordinate, you have 10 attempts to get as many coins as you can.");
        String[][] board = new String[11][11];
        for (int i = 1; i < 11; i++) {
            for (int j = 1; j < 11; j++) {

                board[i][j] = "[ ]";
                System.out.print(board[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");
        int total = 0;

        for (int turns = 0; turns < 10; turns++) {
            int x = 0;
            int y = 0;
            boolean Occupied;
            do {
                x = 0;
                y = 0;

                while ((x < 1) || (x > 10)) {
                    System.out.println("Incorrect x coordinate");
                    System.out.println("Guess a x coordinate: ");
                    x = input.nextInt();
                }

                while ((y < 1) || (y > 10)) {
                    System.out.println("Incorrect y coordinate");
                    System.out.println("Guess a y coordinate: ");
                    y = input.nextInt();
                }

                Occupied = !"[ ]".equals(board[x][y]);
                if (Occupied) {
                    System.out.println("You've already guessed that position");
                }
            } while (Occupied);

            System.out.println("");
            int r1 = rand.nextInt(10);
            total = total + r1;
            board[x][y] = ("[" + r1 + "]");
            for (int i = 1; i < 11; i++) {
                for (int j = 1; j < 11; j++) {
                    System.out.print(board[i][j]);
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("You found " + r1 + " coins at point: (" + x + "," + y + ")");
            System.out.println("");
        }
        System.out.println("You found " + total + " coins in total");
    }
}
