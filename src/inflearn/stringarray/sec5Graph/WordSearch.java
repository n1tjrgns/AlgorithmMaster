package inflearn.stringarray.sec5Graph;

//https://leetcode.com/problems/word-search/

public class WordSearch {
    //2차원 배열이 있을때, 탐색하면서 주어진 단어를 만들수 있는지 여부 판단하
    private int[] dx = {0, 0, 1, -1};
    private int[] dy = {1, -1, 0, 0};
    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                System.out.println("x = " + i + " ::: y = " + j);
                if (board[i][j] == word.charAt(0)) { //시작점만 찾기

                    if (dfs(i, j, board, word, 1, visited,m,n)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean dfs(int x, int y, char[][] board, String word, int cnt, boolean[][] visited, int m, int n) {

        System.out.println("cnt = " + cnt);

        if (cnt == word.length()) return true; //카운트가 길이와 같아졌다는건 단어를 찾았다는 것

        for(int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >=0 && ny >=0 && nx < m && ny <n){
                if (word.charAt(cnt) == board[nx][ny] && !visited[nx][ny]){
                    visited[x][y] = true;
                    System.out.println(" nx = " + nx + " ::: ny = " + ny);
                    if (dfs(nx, ny, board, word, cnt+1, visited,m,n)){
                        return true;
                    }else{
                        visited[x][y] = false;
                    }
                }
            }
        }

        return false;
    }

    public static void main(String[] args) {
        WordSearch w = new WordSearch();
        System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}},"ABCCED"));
        //System.out.println(w.exist(new char[][]{{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, "ABCB")); //false
    }
}
