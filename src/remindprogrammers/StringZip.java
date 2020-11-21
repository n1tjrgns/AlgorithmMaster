package remindprogrammers;

public class StringZip {
    public int solution(String s) {
        //길이가 1이면 빠른 종료
        if (s.length() == 1) return 1;

        //아무라 길어도 문자열 길이 자체를 넘을 수 없음
        int answer = s.length();

        for(int i=1; i<=s.length()/2; i++){
            String now = "";
            String next = "";
            String result = "";
            int cnt = 1;
            for (int j=0; j<=s.length() / i; j++){
                int start = j * i;
                int end = Math.min(i * (j+1), s.length());
                now = next;
                next = s.substring(start,end);

                if (now.equals(next)){
                    cnt++;
                }else{
                    result = result + (transCnt(cnt) + now);
                    cnt=1;
                }
            }
            result = result + (transCnt(cnt) + next);
            answer = Math.min(answer, result.length());

        }
        return answer;
    }

    //1인 경우 출력할 필요가 없으니 ""로 대체 해주기 위한 메소드
    private String transCnt(int cnt) {
        return cnt > 1 ? String.valueOf(cnt) : "";
    }

    private String cntCheck(int cnt) {
        return cnt > 1 ? String.valueOf(cnt) : "";
    }

    public static void main(String[] args) {
        StringZip s = new StringZip();
        System.out.println(s.solution("aabbaccc"));  //2a2ba3c 7
        //System.out.println(s.solution("ababcdcdababcdcd"));
        //System.out.println(s.solution("abcabcdede"));
        //System.out.println(s.solution("abcabcabcabcdededededede"));
    }
}
