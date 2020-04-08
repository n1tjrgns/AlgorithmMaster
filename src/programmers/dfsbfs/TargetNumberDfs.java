package programmers.dfsbfs;
//https://programmers.co.kr/learn/courses/30/lessons/43165
public class TargetNumberDfs {
    public int solution(int[] numbers, int target) {
        //주어진 배열의 인덱스를 더하거나 빼서 target의 값이 되는 경우의 수를 구하는 문제
        // 탐색인 이유 -> 모든 경우를 다 해봐야함
        // 정답이 3 이 나와야하는 고정 값이 있다? -> 깊이는 3이 되도록
        // 배열의 길이만큼만 돌면 끝나기 때문에 visited도 필요가 없다.
        int answer = 0;

        //for문으로 재귀를 안돌려도 되는 이유 -> 배열의 길이만큼만 돌면 되는데 배열의 길이를 아니까
        answer = dfs(numbers, target, 0, 0);

        return answer;
    }

    private int dfs(int[] numbers, int target, int depth, int answer) {

        if(numbers.length == depth){
            if(answer == target){
                return answer = answer + 1;
            }else{
                return answer = answer;
            }
            //dfs는 매번 깊이가 + 1 임을 잊지 말자.
        }else{
            return dfs(numbers, target, depth+1, answer + numbers[depth])
                    + dfs(numbers, target, depth+1, answer - numbers[depth]);
        }
    }

    public static void main(String[] args) {
        TargetNumberDfs t = new TargetNumberDfs();
        System.out.println(t.solution(new int[]{1,1,1,1,1}, 3));
    }
}
