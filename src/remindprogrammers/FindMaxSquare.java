package remindprogrammers;
/*문제 설명
1와 0로 채워진 표(board)가 있습니다. 표 1칸은 1 x 1 의 정사각형으로 이루어져 있습니다.
표에서 1로 이루어진 가장 큰 정사각형을 찾아 넓이를 return 하는 solution 함수를 완성해 주세요.
(단, 정사각형이란 축에 평행한 정사각형을 말합니다.)

예를 들어
1	2	3	4
0	1	1	1   0,0 0,1 0,2 0,3
1	1	1	1   1,0 1,1 1,2 1,3
1	1	1	1   2,0 2,1 2,2 2,3
0	0	1	0   3,0 3,1 3,2 3,3
가 있다면 가장 큰 정사각형은

1	2	3	4
0	1	1	1
1	1	1	1
1	1	1	1
0	0	1	0
가 되며 넓이는 9가 되므로 9를 반환해 주면 됩니다.

제한사항
표(board)는 2차원 배열로 주어집니다.
표(board)의 행(row)의 크기 : 1,000 이하의 자연수
표(board)의 열(column)의 크기 : 1,000 이하의 자연수
표(board)의 값은 1또는 0으로만 이루어져 있습니다.
입출력 예
board	answer
[[0,1,1,1],[1,1,1,1],[1,1,1,1],[0,0,1,0]]	9
[[0,0,1,1],[1,1,1,1]]	4
입출력 예 설명
입출력 예 #1
위의 예시와 같습니다.

입출력 예 #2
| 0 | 0 | 1 | 1 |
| 1 | 1 | 1 | 1 |
로 가장 큰 정사각형의 넓이는 4가 되므로 4를 return합니다.*/
public class FindMaxSquare {
    public int solution(int [][]board) {
        int answer = 0;
        int up, left, upleft;
        //첫줄은 상단과, 대각선 상단이 존재하지 않으므로 건너뛴다. 그래서 1부터 시작
        for (int y=1; y < board.length; y++){
            for(int x=1; x < board[0].length; x++){
                if (board[y][x] == 1){
                    up = board[y-1][x];
                    left = board[y][x-1];
                    upleft = board[y-1][x-1];

                    int min = Math.min(up, left);
                    min = Math.min(min, upleft);
                    board[y][x] = min + 1;
                }
            }
        }

        for (int y=0; y < board.length; y++) {
            for (int x = 0; x < board[0].length; x++) {
                if (board[y][x] > 0){
                    answer = Math.max(answer, board[y][x]);
                }
            }
        }

        return (int) Math.pow(answer,2);
    }

    public static void main(String[] args) {
        FindMaxSquare f = new FindMaxSquare();
        System.out.println(f.solution(new int[][]{{0,0,1,1},{1,1,1,1}}));
        System.out.println(f.solution(new int[][]{{0,1,1,1},{1,1,1,1},{1,1,1,1},{0,0,1,0}}));
    }
}
