/*제일 작은 수 제거하기
문제 설명
정수를 저장한 배열, arr 에서 가장 작은 수를 제거한 배열을 리턴하는 함수, solution을 완성해주세요.
단, 리턴하려는 배열이 빈 배열인 경우엔 배열에 -1을 채워 리턴하세요. 예를들어 arr이 [4,3,2,1]인 경우는 [4,3,2]를 리턴 하고, [10]면 [-1]을 리턴 합니다.

제한 조건
arr은 길이 1 이상인 배열입니다.
인덱스 i, j에 대해 i ≠ j이면 arr[i] ≠ arr[j] 입니다.
입출력 예
arr	return
[4,3,2,1]	[4,3,2]
[10]	[-1]*/

package programmers.practice;

import java.util.ArrayList;
import java.util.Arrays;

public class DeleteMinNumber {

        public int[] solution(int[] arr) {
                int[] answer = {};
                int len = arr.length;
                int location=0;
                int min=0;

                if(arr.length == 1){
                        return new int[]{-1};
                }

                ArrayList<Integer> num = new ArrayList<>();

                for(int a : arr ){
                        num.add(a);
                }

                min = num.get(0);

                for(int i=0; i<len; i++){
                        if(arr[i] < min){
                                min = arr[i];
                                location = i;
                        }
                }

                num.remove(location);

                answer = new int[num.size()];

                for(int i=0; i<num.size(); i++){
                        answer[i] = num.get(i);
                }

                return answer;
        }

        public static void main(String[] args) {
                DeleteMinNumber d = new DeleteMinNumber();
                 //int arr[] = {4,3,2,1,5};
                int arr[] = {1,3,2,1,5};
                 //int arr[] = {4,3,2,1};
                 //int arr[] = {10};
                System.out.println(Arrays.toString(d.solution(arr)));
        }
}
