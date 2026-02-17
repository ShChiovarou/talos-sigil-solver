package engine;

import engine.Sigil;
import engine.Point;

public class Board {
    int rows;
    int cols;
    int[][] board;

    private static final char[] SYMBOLS = {
        '.', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 
        'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z',
    };

    private static final String RESET = "\u001B[0m";

    private static final String[] COLORS = {
        "\u001B[90m",      // 0: Gray (for '.')
        "\u001B[38;5;160m", // A: Red
        "\u001B[38;5;40m",  // B: Green
        "\u001B[38;5;33m",  // C: Blue
        "\u001B[38;5;220m", // D: Yellow
        "\u001B[38;5;129m", // E: Purple
        "\u001B[38;5;51m",  // F: Cyan
        "\u001B[38;5;208m", // G: Orange
        "\u001B[38;5;197m", // H: Pink
        "\u001B[38;5;190m", // I: Lime
        "\u001B[38;5;21m",  // J: Deep Blue
        "\u001B[38;5;124m", // K: Maroon
        "\u001B[38;5;46m",  // L: Bright Green
        "\u001B[38;5;226m", // M: Gold
        "\u001B[38;5;63m",  // N: Royal Blue
        "\u001B[38;5;201m", // O: Magenta
        "\u001B[38;5;82m",  // P: Chartreuse
        "\u001B[38;5;202m", // Q: Dark Orange
        "\u001B[38;5;213m", // R: Soft Pink
        "\u001B[38;5;45m",  // S: Turquoise
        "\u001B[38;5;178m", // T: Mustard
        "\u001B[38;5;93m",  // U: Indigo
        "\u001B[38;5;118m", // V: Spring Green
        "\u001B[38;5;161m", // W: Crimson
        "\u001B[38;5;141m", // X: Lavender
        "\u001B[38;5;214m", // Y: Peach
        "\u001B[38;5;39m"   // Z: Sky Blue
    };

    public Board(int rows, int cols) {
        this.rows=rows;
        this.cols=cols;

        board = new int[rows][cols]; 
    }

    public boolean isOccupied(int x, int y) {
        if(board[x][y] == 0)
        {
            return false;
        }
        return true;
    }

    public int getCell(int x, int y)
    {
        return board[x][y];
    }

    public void setCell(int x, int y, int symbol) {
        board[x][y] = symbol;
    }

    public void unSetCell(int x, int y) {
        board[x][y] = 0;
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public void printBoard() {
        for(int[] row : board) {
            for(int cell : row) {
                char toPrint = SYMBOLS[cell];
                System.out.print(COLORS[cell] + toPrint + "  " + RESET);
            }
            System.out.println();
        }
    }



    public boolean canPlace(Sigil sigil, int rot, int r, int c) {
        Point[] points = sigil.rotations[rot];

        for(Point p : points) {

            if(r + p.r() >= rows || r + p.r() < 0 ) {
                return false;
            }
            if(c + p.c() >= cols ||  c + p.c() < 0) {
                return false;
            }
            if( board[r+p.r()][c+p.c()] != 0) {
                return false;
            }
        }

        return true;
    }

    public void place(Sigil sigil, int rot, int r, int c, int symbol) {
        Point[] points = sigil.rotations[rot];

        for(Point p : points) {
            board[r+p.r()][c+p.c()] = symbol;
        }
    }

    public void remove(Sigil sigil, int rot, int r, int c, int symbol) {
        Point[] points = sigil.rotations[rot];

        for(Point p : points) {
            board[r+p.r()][c+p.c()] = 0;
        }
    }

    public Point findFirstEmpty() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (board[r][c] == 0) return new Point(r, c);
            }
        }
        return null;
    }
}
