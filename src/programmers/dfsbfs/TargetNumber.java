package programmers.dfsbfs;

public class TargetNumber {
    public int solution(int[] numbers, int target) {
        int answer = 0;

        return dfs(numbers, target, 0, 0);
    }

    private int dfs(int[] numbers, int target, int depth, int answer) {

        if(numbers.length == depth){
            if(target == answer){
                return answer = answer + 1;
            }else{
                return answer = answer;
            }
        }else{
            return dfs(numbers, target, depth + 1, answer + numbers[depth] )
                    + dfs(numbers, target, depth + 1, answer - numbers[depth] );
        }
    }
}
