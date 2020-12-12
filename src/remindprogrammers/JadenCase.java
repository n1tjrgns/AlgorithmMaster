package remindprogrammers;

public class JadenCase {
    public static void main(String[] args) {
        JadenCase j = new JadenCase();
        System.out.println(j.solution("3people unFollowed me"));
        System.out.println(j.solution("for the last week"));
    }

    /**
     * 첫 문자가 영문이 아닐시 -> 대문자 변환 x
     * 나머지는 전부 첫 문자만 대문자로 변환해라
     *
     * @param s
     * @return
     */
    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        String first = s.charAt(0)+"";
        sb.append(first.toUpperCase());

        for(int i=1; i<s.length(); i++){
            String now = s.charAt(i)+"";
            if (" ".equals(now)){
                sb.append(" ");
            }else if (s.charAt(i-1) == ' '){
                sb.append(now.toUpperCase());
            }else{
                sb.append(now.toLowerCase());
            }
        }

        return sb.toString();
    }
}
