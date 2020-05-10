package programmers.kakaointernship;

import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/64061
public class CraneGame {

    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();

        for(int i=0; i<moves.length; i++){
            for(int j=0; j<board.length; j++){
                // moves의 인덱스(x축)은 그대로 있으면서 board의(y)축은 0이 아닐때 까지 계속 아래로 내려가면서 탐색을 해야한다.
                if(board[j][moves[i]-1] != 0){
                    if(stack.isEmpty()){ //비어있으면 뽑은 값을 넣어주고
                        stack.push(board[j][moves[i]-1]);
                    }else{ //비어있지 않다면 같은지 체크
                        if(stack.peek() == board[j][moves[i]-1]){
                            stack.pop();
                            answer += 2;
                        }else{ //같지 않다면 푸쉬
                            stack.push(board[j][moves[i]-1]);
                        }
                    }
                    //뽑은 숫자는 0 처리
                    board[j][moves[i]-1] = 0;
                    break;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        CraneGame c = new CraneGame();
        int board[][] = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int moves[] = {1,5,3,5,1,2,1,4};
        System.out.println(c.solution(board,moves));
    }
}
