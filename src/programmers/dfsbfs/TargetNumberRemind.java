package programmers.dfsbfs;
//https://programmers.co.kr/learn/courses/30/lessons/43165

public class TargetNumberRemind {
    // 배열을가지고 조합 탐색을 하다가
    // depth가 배열 끝까지 탐색을 완료했을 때 target과 같은 경우 카운트 하는 문제
    public int solution(int[] numbers, int target) {
        int answer = 0;

        return dfs(numbers, target, 0, answer);
    }

    private int dfs(int[] numbers, int target, int depth, int answer) {

        // depth가 배열의 깊이 만큼 탐색을 했을 때
        if(numbers.length == depth){
            if(target == answer) {// 타겟과 answer이 같으면
                answer = answer + 1;
            }else{
                answer = answer; // 아무일도 없었다..
            }
        }else{ // 배열의 길이와 depth가 같지 않을 동안은 계속 + 하거나 - 하거나 계산을 해야겠지??
            return dfs(numbers, target, depth + 1, answer + numbers[depth])
                    + dfs(numbers, target, depth + 1, answer - numbers[depth]);
        }

        return answer;
    }

    public static void main(String[] args) {
        TargetNumberRemind t = new TargetNumberRemind();
        System.out.println(t.solution(new int[]{1,1,1,1,1}, 3));
    }
}
