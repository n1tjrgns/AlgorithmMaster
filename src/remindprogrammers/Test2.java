package remindprogrammers;

public class Test2 {
    public String solution(String number, int k) {
        StringBuilder answer = new StringBuilder();
        //조합 하는 문제가아닌 순서는 그대로 유지하면서 그 안에서 가장 큰 숫자를 구해야 하는 문제
        int max = 0;
        int idx = 0;
        for(int i=0; i<number.length()-k; i++){
            max = 0;
            for(int j=idx; j<=i+k; j++){
                if (max < number.charAt(j) - '0' ){
                    max = number.charAt(j) - '0';
                    idx=j+1;
                }
            }
            answer.append(max);
        }


        return answer.toString();
    }

    public static void main(String[] args) {
        Test2 t = new Test2();
        System.out.println(t.solution("1924",2));
    }
}
