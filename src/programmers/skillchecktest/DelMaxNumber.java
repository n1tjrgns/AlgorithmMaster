package programmers.skillchecktest;

import java.util.Stack;

//전체를 숫자로 변환해서 정렬한다음에
//k 갯수만큼 앞에서부터 제거하고
//남은 자리수를 다시 String으로 변환해서 리턴??
//하지만 순서가 바뀌지 않는 조건 때문에 이건 안된다.

//문자를 무조건 숫자로 바꾸려하지말고, 아스키 코드값을 활용해서 바로 계산하는 생각도 좀 하자
public class DelMaxNumber {
    public String solution(String number, int k) {
        String answer ="";
        //결국 k개를 제외할것이기 때문에 length - k
        char[] result = new char[number.length() - k];
        Stack<Character> stack = new Stack<>();

        //스택을 사용해 우선 맨 처음에는 값을 넣고, 출력된 값과 다음값을 비교해
        //스택에 있는 값보다 크면 스택의 값을 빼고, 새 값을 넣어준다.
        //이 행위를 할 경우 k개 만큼 제거를 한 것에 해당하기 때문에 k--를 해줘야함.
        for(int i=0; i<number.length(); i++){
            char c = number.charAt(i);
            System.out.println("c : "+ c);
            while(!stack.isEmpty()){
                if(stack.peek() < c && k-- > 0){
                    stack.pop();
                }
            }
            stack.push(c);
        }

        for(int i=0; i<result.length; i++){
            result[i] = stack.get(i);
        }

        return new String(result);
    }

    public static void main(String[] args) {
        DelMaxNumber d = new DelMaxNumber();
        String num = "1924";
        System.out.println(d.solution(num, 2));
    }
}
