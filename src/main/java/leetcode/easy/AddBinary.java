package leetcode.easy;
/*Given two binary strings, return their sum (also a binary string).

The input strings are both non-empty and contains only characters 1 or 0.

Example 1:

Input: a = "11", b = "1"
Output: "100"
Example 2:

Input: a = "1010", b = "1011"
Output: "10101"*/
public class AddBinary {
    //TODO 문자열을 2진수의 덧셈처럼 더해서 다시 문자열로 리턴하는 문제
    // 0 + 0 = 0
    // 1 + 0 or 0 + 1 = 1
    // 1 + 1 = 0,  + 앞에 1
    // 문자열 모양을 비교해서 계산
    // 숫자로 바꿔서 2가 될 때 처리
    // 길이를 맞춰주기 위해 0으로 채워?



    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        //if 문에서 인덱스 -- 연산을 하기 위해 length - 1
        int aLen = a.length()-1;
        int bLen = b.length()-1;

        int plus = 0;

        while(aLen >= 0 || bLen>=0){
            int sum = plus;
            //1010
            //각각 string을 chartAt - '0'으로 int로 변환해서
            if(aLen >= 0){
                sum = sum + a.charAt(aLen--) - '0';

            }
            //1011
            if(bLen >= 0){
                sum = sum + b.charAt(bLen--) - '0';
            }

            //2로 나눈 나머지는 저장하고
            sb.append(sum % 2); //0
            //자릿수의 올림이 있는지 계산
            plus = sum / 2;
        }

        //올림이 있으면 마지막에 1자리 수 증가
        if(plus != 0){
            sb.append(plus);
        }

        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        AddBinary a = new AddBinary();
        System.out.println(a.addBinary("1010","1011"));
        System.out.println(a.addBinary("11","1"));
    }
}
