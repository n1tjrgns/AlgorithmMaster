package leetcode.medium;

//https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    //역순으로 해도 같은 경우를 팰린드롬이라고하지.
    //만들 수 있는 팰린드롬 갯수 구하기
    //기준이 되는 문자를 찾았을 때 좌, 우를 줄리고 늘여가면서 그 낱말이 같은지 계속 체크하면서 카운트
    int ans=0;
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
            ans++;
            start--;
            end++;
        }
    }

    public static void main(String[] args) {
        PalindromicSubstrings p = new PalindromicSubstrings();
        System.out.println(p.countSubstrings("abc"));
        //System.out.println(p.countSubstrings("aaa"));

    }
}
