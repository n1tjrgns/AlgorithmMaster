package programmers.greedy;

import java.util.Arrays;

public class JoyStick {
    public int solution(String name) {
        //조이스틱 위, 아래 -> 문자열 +-, 맨 끝에 도달했을 경우 초기화
        //조이스틱 왼쪽, 오른쪽 -> 인덱스 +-, 맨 끝일 경우 초기화

        //각각 조작 할 때마다 카운트 ++

        //최소 이동이기 때문에 동작하기전에 어느 방향으로 가야 빠를지를 체크 후 이동해야한다.
        int answer = 0;

        // 1. 길이만큼 A로 배열 초기화
        char arr[] = new char[name.length()];
        Arrays.fill(arr,'A');

        char[] target = name.toCharArray();

        // 위, 아래 판단해서 해당 단어 만들기
        // A ~ Z 65 ~ 90 총 26개  M이 중간
        //순서대로 위 앞만 판단해서 추가한것, 이동횟수 고려 x

        for(int i=0; i<arr.length; i++){

            if(target[i] <= 'M'){
                answer = answer + target[i] - arr[i];
            }else{
                answer = answer + 26 - (target[i] - arr[i]);
            }
        }

        //양 옆은 어떻게 판단할까
        //int result = checkA(target);
        int minMove = target.length - 1; // 오른쪽으로만 움직일 경우 최소 움직여야하는 횟수

        for(int i=0; i<target.length; i++){
            if(target[i] != 'A'){
                int next = i+1; //다음 값이 A인지 판단하기 위해 +1을 해줄 변수

                //A를 만난경우, A가 없을 떄 까지 카운트
                while(next < target.length && target[next] == 'A'){
                    next++;
                }

                // i * 2 가 결국 오른쪽으로 왔다가 다시 왼쪽으로 가는 횟수를 나타낸다
                // BBAABBB 의 경우 B -> B (A만남) 다시 처음 B로 돌아가면 총 2회, 즉 A를 만나기 직전 인덱스 값 * 2
                //전체길이에서 next를 빼준다 = (되돌아 가는 경우와 A 로 이루어진 부분을 제외한 값을 이동해야하는 부분을 구한다.)
                int moveCnt = i * 2 + target.length - next;
                minMove = Math.min(minMove, moveCnt);
            }
        }
        return answer+minMove;
    }

    public static void main(String[] args) {
        JoyStick j = new JoyStick();

        //System.out.println(j.solution("JEROEN")); // 56
        //System.out.println(j.solution("JAN")); // 23
        //System.out.println(j.solution("JAZ")); // 11
        System.out.println(j.solution("BBAABBB")); // 10
    }
}
