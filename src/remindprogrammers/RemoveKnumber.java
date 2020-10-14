package remindprogrammers;

public class RemoveKnumber {
    public String solution(String number, int k) {
        StringBuilder answer=  new StringBuilder();

        int idx=0;
        int max=0;
        //조합을 하는게 아닌 순서를 그대로 유지한 상태에서 가장 큰 수를 만들어야한다.
        // 따라서 number.length - k 중에서 가장 큰수를 찾고 그 뒤부터 나머지 숫자를 찾는다.
        for(int i=0; i<number.length()-k; i++){
            max = 0;
            for(int j=idx; j<=i+k; j++){
                if (max < number.charAt(j) - '0'){
                    max = number.charAt(j) - '0';
                    idx = j+1;
                }
            }

            answer.append(max);
        }

        return answer.toString();
    }

    public static void main(String[] args) {
        RemoveKnumber r= new RemoveKnumber();
        System.out.println(r.solution("1924", 2));
        System.out.println(r.solution("1231234", 3));
    }
}
