/*잃어버린 괄호
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
2 초	128 MB	8381	4043	3333	49.606%
문제
세준이는 양수와 +, -, 그리고 괄호를 가지고 길이가 최대 50인 식을 만들었다. 그리고 나서 세준이는 괄호를 모두 지웠다.

그리고 나서 세준이는 괄호를 적절히 쳐서 이 식의 값을 최소로 만들려고 한다.

괄호를 적절히 쳐서 이 식의 값을 최소로 만드는 프로그램을 작성하시오.

입력
첫째 줄에 식이 주어진다. 식은 ‘0’~‘9’, ‘+’, 그리고 ‘-’만으로 이루어져 있고, 가장 처음과 마지막 문자는 숫자이다.
그리고 연속해서 두 개 이상의 연산자가 나타나지 않고, 5자리보다 많이 연속되는 숫자는 없다. 수는 0으로 시작할 수 있다.

출력
첫째 줄에 정답을 출력한다.

예제 입력 1
55-50+40
예제 출력 1
-35
*/
package baekjoon.greedy;

import java.util.ArrayList;

public class LossGualho {
    public static void main(String[] args) {
        // https://plplim.tistory.com/30
        /*Scanner sc = new Scanner(System.in);

        String str = sc.nextLine();*/

        String s = "55-50+40";

        //TODO 우선 문자형인 숫자랑 연산기호를 분리해야 함
        // -가 있을 때 다음 - 가 나오기 전까지 그 안의 값들을 다 더해서 빼줘야함
        // 55 - (50+40+20) => 이렇게 해야 가장 큰 - 연산을 할 수 있으므로 최소값이 된다.

        char []arr = s.toCharArray();
        String temp = "";
        ArrayList<Integer> list = new ArrayList<>();
        ArrayList<Character> plusminus = new ArrayList<>();

        for(int i=0; i<arr.length; i++){
            if(arr[i] != '+' && arr[i] != '-'){
                temp = temp + arr[i];
                System.out.println(temp);
            }else if(arr[i] == '+' || arr[i] == '-'){
                plusminus.add(arr[i]);
                list.add(Integer.parseInt(temp));
                temp = "";
            }
        }
        list.add(Integer.parseInt(temp));

        System.out.println(list);
        System.out.println(plusminus);

        ArrayList<Integer> result = new ArrayList<>();
        result.add(list.get(0)); //첫 번째 수는 무조건 양수임

        boolean flag = false;
        int first=result.get(0);
        int minsum=0;

        //  55 - (50 + 40)

        for(int i=0; i<plusminus.size(); i++){
            if(plusminus.get(i) == '-'){
                flag = true;
                first = first - minsum;
                minsum=0;
            }

            if(flag){
                minsum = minsum + list.get(i+1);
            }else{
                //전부다 +인 경우
                first = first + list.get(i+1);
            }
        }

        if(minsum > 0){
            first = first - minsum;
        }
        System.out.println(first);
    }
}
