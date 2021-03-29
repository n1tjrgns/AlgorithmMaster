package leetcode.medium;


//https://leetcode.com/problems/word-search/discuss/168378/Java-DFS-with-Explanations
public class WordSearch {
    //2차원 배열을 탐색하면서 단어를 조합했을 때 word를 만들 수 있으면 true, 없으면 false
        private int[] dx = {0,0,1,-1};
        private int[] dy = {1,-1,0,0};
        private static int m,n;

        public boolean exist(char[][] board, String word) {
            System.out.println("word = " + word.length());
            m = board.length;
            n = board[0].length;
            if (word == null || word.length() == 0) return true;
            if (m*n < word.length()) return false;
            boolean[][] visited = new boolean[m][n];

            //단어가 1개인 경우 때문에 처음 단어를 들고 들어가야함
            char firstChar = word.charAt(0);

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (firstChar == board[i][j]){
                        if (dfs(i, j, board, word, 1,visited)){
                            return true;
                        }
                    }
                }
            }

            return false;
        }

        private boolean dfs(int x, int y, char[][] board, String word, int cnt, boolean[][] visited) {
            System.out.println("x = " + x + " ::: y = " + y);
            System.out.println("cnt = " + cnt);

            if (cnt == word.length()) return true;
            else if (cnt > word.length()) return false;

            for(int i=0; i<4; i++){
                int nx = x + dx[i];
                int ny = y + dy[i];



                if (nx < 0 || ny < 0 || nx >= m || ny >= n || word.charAt(cnt) != board[nx][ny]){
                    visited[x][y] = false;
                }else if (nx >=0 && ny >= 0 && nx < m && ny < n){
                    //System.out.println("board[nx][ny] = " + board[nx][ny]  + " :::  word,charat = "  + word.charAt(cnt));
                    if (word.charAt(cnt) == board[nx][ny] && !visited[nx][ny]){
                        visited[x][y] = true;
                        System.out.println("i = " + i + " ::: nx = " + nx + " ::: ny = " + ny);
                        if (dfs(nx, ny , board, word, cnt+1, visited)) return true;
                        else visited[x][y] = false;
                    }
                }
            }

            return false;
        }


    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCCED")); //true
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")); //false
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "SEE")); //true

        //System.out.println(w.exist(new char[][]{{'a'}}, "a")); //true

        //System.out.println(w.exist(new char[][]{{'a','a'}}, "aaa")); //false
        System.out.println(w.exist(new char[][]{{'a','a','b','a','a','b'},{'a','a','b','b','b','a'},{'a','a','a','a','b','a'},{'b','a','b','b','a','b'},{'a','b','b','a','b','a'},{'b','a','a','a','a','b'}}, "bbbaabbbbbab")); //false
    }
}
