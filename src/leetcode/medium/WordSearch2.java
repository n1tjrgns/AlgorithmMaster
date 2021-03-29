package leetcode.medium;


//https://leetcode.com/problems/word-search/discuss/168378/Java-DFS-with-Explanations
public class WordSearch2 {
    private static int m, n;
    private static final int[][] dirs = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0)
            return true;

        m = board.length;
        n = board[0].length;
        char firstChar = word.charAt(0);

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == firstChar) {
                    // Mark as visited.
                    board[i][j] = '-';
                    if (searchFrom(i, j, board, word, 1))
                        return true;
                    // Restore to unvisited.
                    board[i][j] = firstChar;
                }
            }
        }

        return false;
    }

    private static boolean searchFrom(int x, int y, char[][] board, String word, int wi) {
        // Acception case, leaf.
        if (wi == word.length())
            return true;

        for (int[] dir : dirs) {
            int nx = x + dir[0];
            int ny = y + dir[1];

            if (nx < 0 || nx >= m || ny < 0 || ny >= n || word.charAt(wi) != board[nx][ny]){
                continue;

            }
            // Mark as visited.
            board[nx][ny] = '-';
            if (searchFrom(nx, ny, board, word, wi + 1))
                return true;
            // Restore to unvisited.
            board[nx][ny] = word.charAt(wi);
        }

        return false;
    }
    public static void main(String[] args) {
        WordSearch2 w = new WordSearch2();
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED"));
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE"));
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB"));
    }
}
