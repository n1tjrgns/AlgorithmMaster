package programmers.healingpaper;

public class StrToInt {
    public Object getStrToInt(String str) {
        boolean Sign = true;
        int result = 0;
        if(str.contains(".")){
            return null;
        }
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == '-') {
                Sign = false;
            } else{
                result = (result * 10) + (ch - '0');
            }
        }
        return Sign ? result :-1 * result;
    }
    //아래는 테스트로 출력해 보기 위한 코드입니다.
    public static void main(String args[]) {
        StrToInt strToInt = new StrToInt();
        //String step[] = {"123","123.456","-123"};

        System.out.println(strToInt.getStrToInt("123"));
        System.out.println(strToInt.getStrToInt("123.456"));
        System.out.println(strToInt.getStrToInt("-123"));
    }
}
