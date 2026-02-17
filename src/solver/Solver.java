package solver;

import engine.Board;
import engine.Sigil;
import engine.Point;
import java.util.List;

public class Solver {
    Board board;
    List<Sigil> inventory;
    boolean[] used;

    public Solver(Board board, List<Sigil> inventory) {
        this.board = board;
        this.inventory = inventory;
        this.used = new boolean[inventory.size()];
    }

    public boolean solve() {
        Point anchor = board.findFirstEmpty();

        if (anchor == null) return true;

        for (int i = 0; i < inventory.size(); i++) {
            if (used[i]) continue; 

            Sigil curSigil = inventory.get(i);
            used[i] = true;

            for (int rot = 0; rot < curSigil.rotations.length; rot++) {
                for (Point offset : curSigil.rotations[rot]) {
                    int r = anchor.r() - offset.r();
                    int c = anchor.c() - offset.c();

                    if (board.canPlace(curSigil, rot, r, c)) {
                        board.place(curSigil, rot, r, c, i + 1);

                        if (solve()) return true;

                        board.remove(curSigil, rot, r, c, i + 1);
                    }
                }
            }
            used[i] = false;
        }

        return false;
    }
}
