import engine.Board;
import engine.Sigil;
import solver.Solver;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {
        System.out.println("Starting Sigil Puzzle Solver");
        System.out.println();

        Scanner input = new Scanner(System.in);

        System.out.println("Number of rows:");
        
        int rows = input.nextInt();

        System.out.println();
        System.out.println("Number of Columns:");
        
        int cols = input.nextInt();
        System.out.println();

        int area = rows*cols;

        Board board = new Board(rows, cols);

        System.out.println("Lets solve this puzzle that is " + rows + " x " + cols + ". But first we need the sigils.");
        
        List<Sigil> inventory = new ArrayList<>();
        String[] pieceNames = {"Z", "S", "T", "J", "L", "I", "O"};

        Sigil[] sigilTypes = {
            Sigil.Z, // Most restrictive
            Sigil.S, 
            Sigil.T, 
            Sigil.J, 
            Sigil.L, 
            Sigil.I, 
            Sigil.O  // Least restrictive (Gap filler)
        };

        for (int i = 0; i < pieceNames.length; i++) {
            System.out.print("How many " + pieceNames[i] + " sigils? ");
            int count = input.nextInt();
    
            for (int j = 0; j < count; j++) {
                inventory.add(sigilTypes[i]);
            }
        }

        input.close();


        if(inventory.size()*4 != area) {
            System.out.println("The total area of the pieces (" + inventory.size()*4 + ") does not match the area of the board (" + area + "). Please double check your parameters");
            return;
        }

        Solver solver = new Solver(board, inventory);

        boolean isSolved = solver.solve();

        if (isSolved) {
            System.out.println("Puzzle Solved!");
            board.printBoard();
        } 
        else {
            System.out.println("This puzzle is impossible with these sigils.");
        }

        
    }
}
