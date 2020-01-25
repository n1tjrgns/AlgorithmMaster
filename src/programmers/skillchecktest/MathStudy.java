package programmers.skillchecktest;

public class MathStudy {

    public int solution(int n) {
        int answer = 0;

        for(int i=1; i<=n; i++){
            int temp = 0;
            // j=i가 핵심이네. => 투 포인터 알고리즘, start == end부터 시작
            //위에 for문에서 i값은 이미 i에 들어가있어서 i+1로 더했는데.
            for(int j=i; j<=n; j++){
                temp = temp+j;
                if(temp == n){
                    answer++;
                    break;
                }else if(temp > n){
                    break;
                }
            }
        }
        return answer;
    }

    //또 다른 풀이 :: 정수론
    //주어진 자연수를 연속된 자연수의 합으로 표현하는 방법의 수
    // ==> 주어진 수의 홀수 약수의 개수와 동일하다.

    /*for(int i=1; i<n; i=i+2){
        if(n % i == 0){
            answer++;
        }
    }*/


    public static void main(String[] args) {
        MathStudy m = new MathStudy();
        System.out.println(m.solution(15));
    }
}
