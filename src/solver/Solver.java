package solver;

import engine.Board;
import engine.Sigil;
import engine.Point;
import java.util.List;

public class Solver {
    Board board;
    List<Sigil> inventory;

    public Solver(Board board, List<Sigil> inventory) {
        this.board = board;
        this.inventory = inventory;
    }

    public boolean solve(int index) {
        if(index == inventory.size()) {
            return true;
        }
        
        Sigil curSigil = inventory.get(index);

        for( int r = 0; r < board.getRows(); r++) {
            for(int c = 0; c < board.getCols(); c++) {
                for(int rot = 0; rot < curSigil.rotations.length; rot++)
                {
                    if(board.canPlace(curSigil, rot, r, c)) {
                        board.place(curSigil, rot, r, c, index + 1);
                    

                        if(solve(index + 1)){
                            return true;
                        }

                        board.remove(curSigil, rot, r, c, index + 1);
                    }
                }
            }
        }


        return false;
    }
}
