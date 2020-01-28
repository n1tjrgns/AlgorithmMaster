/*모의고사
문제 설명
수포자는 수학을 포기한 사람의 준말입니다.
수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때,
가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
입출력 예 설명
입출력 예 #1

수포자 1은 모든 문제를 맞혔습니다.
수포자 2는 모든 문제를 틀렸습니다.
수포자 3은 모든 문제를 틀렸습니다.
따라서 가장 문제를 많이 맞힌 사람은 수포자 1입니다.

입출력 예 #2

모든 사람이 2문제씩을 맞췄습니다.*/

package programmers.fullsearch;

import java.util.ArrayList;
import java.util.Arrays;

public class MockTest2 {
    //3인방의 찍는 방식
    //1번 : 1, 2, 3, 4, 5
    //2번 : 2, 1, 2, 2, 2, 3, 2, 4, 2, 5
    //3번 : 3, 3, 1, 1, 2, 2, 4, 4, 5, 5

    //정답지가 주어질 때, 누가 제일 많이 맞췄는지, 같으면 여러명 출력
    public int[] solution(int[] answers) {
        //3명에 대한 결과 값
        int[] answer = {};

        //맞춘 갯수 카운트
        int [] correctCount = new int[3];

        int num1[] = {1,2,3,4,5};
        int num2[] = {2, 1, 2, 3, 2, 4, 2, 5};
        int num3[] = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        for(int i=0; i<answers.length; i++){
            if(answers[i] == num1[i%5]){
                correctCount[0]++;
            }
            if (answers[i] == num2[i%8]){
                correctCount[1]++;
            }
            if (answers[i] == num3[i%10]) {
                correctCount[2]++;
            }
        }

        //1번 학생이 가장 많이 맞췄다고 가정
        int top = correctCount[0];
        for(int i=0; i<correctCount.length; i++){
            if( top < correctCount[i]){
                top = correctCount[i];
            }
        }

        ArrayList<Integer> list = new ArrayList<>();

        //answers와 비교해서
        for(int i=0; i<correctCount.length; i++){
            if(top == correctCount[i]){
                list.add(i);
            }
        }

        answer = new int[list.size()];

        for(int i=0; i<list.size(); i++){
            //인덱스가 0부터 시작하므로 +1
            answer[i] = list.get(i)+1;
        }


        return answer;
    }



    public static void main(String[] args) {
            MockTest2 m = new MockTest2();
        int arr[] = {1,2,3,4,5};
        System.out.println(Arrays.toString(m.solution(arr)));
    }
}


/*int[] player2 = {2, 1, 2, 3, 2, 4, 2, 5};// 8
        int[] player3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};// 10
        int[] answer = new int[]{0,0,0};
        int maxNum = 0;
        List<Integer> countNum = new ArrayList<>();

        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == player1[i % 5]) {
                answer[0]++;
            }

            if (answers[i] == player2[i % 8]) {
                answer[1]++;
            }

            if (answers[i] == player3[i % 10]) {
                answer[2]++;
            }
        }

        for (int i : answer) {
            if (i > maxNum) {
                maxNum = i;
            }
        }

        for (int i = 0; i < 3; i++) {
            if (answer[i] == maxNum) {
                countNum.add(i+1);
            }
        }*/