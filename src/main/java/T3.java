import java.util.Arrays;

class T3 {
    int[] board = new int[9];
    int[] history = new int[9];
    int counter = 0;

    void move(int pos) {
        board[pos] = (counter % 2) == 0 ? +1 : -1;
        history[counter++] = pos;
    }

    void undo() {
        if (counter != 0) board[history[--counter]] = 0;
    }

    void undoAll() {
        while (counter > 0) undo();
    }

    boolean isValidMove(int pos) {
        if (pos < 0 || pos > 8) return false;
        if (board[pos] != 0) return false;
        if (threeInARow()) return false;
        return true;
    }
    boolean threeInARow() {
        int i = 8;
        int[][] rows = {{0,1,2}, {3,4,5}, {6,7,i}, // horizontal
                {0,3,6}, {1,4,7}, {2,5,6}, // vertical
                {0,4,i}, {2,4,6}};         // diagonal
        return Arrays.stream(rows).parallel().anyMatch(row -> {
            int sum = Arrays.stream(row).map(pos -> board[pos]).sum();
            return Math.abs(sum) == 3;
        });
    }
    @Override
    public String toString() {
        char[] sym = {'O', ' ', 'X'};
        char[] repr = new char[9];
        for(int i = 0; i < board.length; i++) repr[i] = sym[board[i] + 1];
        return
                "<tr>\n" +
                        String.format("  <td onclick=\"sendMove(0)\">%c</td>\n", repr[0]) +
                        String.format("  <td onclick=\"sendMove(1)\">%c</td>\n", repr[1]) +
                        String.format("  <td onclick=\"sendMove(2)\">%c</td>\n", repr[2]) +
                        "</tr>\n" +
                        "<tr>\n" +
                        String.format("  <td onclick=\"sendMove(3)\">%c</td>\n", repr[3]) +
                        String.format("  <td onclick=\"sendMove(4)\">%c</td>\n", repr[4]) +
                        String.format("  <td onclick=\"sendMove(5)\">%c</td>\n", repr[5]) +
                        "</tr>\n" +
                        "<tr>\n" +
                        String.format("  <td onclick=\"sendMove(6)\">%c</td>\n", repr[6]) +
                        String.format("  <td onclick=\"sendMove(7)\">%c</td>\n", repr[7]) +
                        String.format("  <td onclick=\"sendMove(8)\">%c</td>\n", repr[8]) +
                        "</tr>\n";
    }
}