package programmers.healingpaper;

import java.util.Arrays;

/* 배열에 값이 주어졌을 때 카운트 만큼 맨 앞의 인덱스를 빼서 맨 뒤로 붙인다.
* 2번 문제는 list 를 rotation 하는 함수를 작성하라는 문제인데요,

예를 들어 list [1, 2, 3] 이 있을 때 이를 1 만큼 rotation 시킨다고 하면 왼쪽으로 한칸씩 움직이고 처음에 있던 1은 뒤로 돌아가서 [2, 3, 1] 의 결과를 얻게 됩니다.
위 list 를 100번 rotation 하라고 하면 간단하게 1번 rotation 했을 때와 결과가 같기 때문에 그런 방식으로 동작하는 함수를 작성해주시면 됩니다.*/
public class ListRotate {

    public static void main(String[] args) {
        ListRotate l = new ListRotate();
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int count = 101;
        System.out.println(Arrays.toString(l.solution(arr, count)));
    }

    //1차 풀이과정 :: 큐에서 하나씩 빼서 뒤에 붙이기 -> 사이즈가 커질 경우 연산 횟수가 많아짐
    /*private Queue<Integer> solution(int[] arr, int count) {
        Queue<Integer> que = new LinkedList<>();

        for(int a : arr){
            que.add(a);
        }

        if(count % que.size() == 0){
            return que;
        }else{
            for(int i=0; i< count % que.size(); i++){ //100, 3 = 1>
                int poll = que.poll();
                que.add(poll);
            }
        }

        return que;
    }*/



    // 2차 풀이 :: System.arraycopy라는 것을 알게되어 사용

    // 1, 2, 3, 4, 5    => 0   :: 1, 2, 3, 4, 5 // 0 ~ 4
    // 1, 2, 3, 4, 5    => 1   :: 2, 3, 4, 5, 1 // 1 ~ 4 & 0
    // 1, 2, 3, 4, 5    => 2   :: 3, 4, 5, 1, 2 // 2 ~ 4 & 0 ~1
    // 1, 2, 3, 4, 5    => 3   :: 4, 5, 1, 2 , 3 // 3 ~ 4 & 0 ~ 2
    // 1, 2, 3, 4, 5    => 4  :: 5, 1, 2, 3, 4 // 4 & 0 ~ 3

    //System.arraycopy(a , 0 , b, 0, a.length)
    //a의 0번째 인덱스부터 a의 크기만큼 b의 0번째 인덱스를 시작으로 복사한다.
    //list 가 클 경우에 하나하나 rotation 시키는 비용이 크므로 중간을 잘라서 앞뒤를 바꾸는 형식으로 하는 것이 좋습니다.
    public int[] solution(int[] arr, int count) {
        int[] result = new int[arr.length];

        if (count % arr.length == 0) {
            return arr;
        } else {
            System.arraycopy(arr, count % arr.length, result, 0, arr.length - count % arr.length);
            System.arraycopy(arr, 0, result, arr.length - count % arr.length, count % arr.length);
        }
        return result;
    }



}
