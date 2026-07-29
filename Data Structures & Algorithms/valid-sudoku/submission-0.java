class Solution {
    public boolean isValidSudoku(char[][] board) {

        java.util.HashSet<String> seen = new java.util.HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {

                if (board[r][c] == '.') continue;

                String row = board[r][c] + "row" + r;
                String col = board[r][c] + "col" + c;
                String box = board[r][c] + "box" + (r / 3) + (c / 3);

                if (!seen.add(row) || !seen.add(col) || !seen.add(box)) {
                    return false;
                }
            }
        }

        return true;
    }
}