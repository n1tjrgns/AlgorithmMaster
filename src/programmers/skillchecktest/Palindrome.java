package programmers.skillchecktest;

public class Palindrome {
    //1. 가장 긴 팰린드롬을 찾아야 하기 때문에 뒤에서부터 찾는다.
    //2. 끝까지 찾았는데 그 전에 반환되는 길이가 없다면 최소값은 1이다.
    int ans=1;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;

        for(int start=0; start<s.length(); start++){
            isPalindrom(s, start, start); // 문자열의 길이가 홀수

            //짝수인 경우에는 가운데 기준점을 잡을 수 없음 같으려면 2개씩 같아야함 그래서 +1을 해줘야하지.
            isPalindrom(s, start, start+1); // 문자열의 길이가 짝수

        }

        return ans;
    }

    private void isPalindrom(String s, int start, int end) {
        while (start >=0 && end < s.length() && s.charAt(start) == s.charAt(end)){
            ans = Math.max(end - start + 1, ans);
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        Palindrome p = new Palindrome();
        System.out.println(p.countSubstrings("abcdcba"));
    }
}
