package programmers.string;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class ListRotate {

    public static void main(String[] args) {
        ListRotate l = new ListRotate();
        int [] arr = {1,2,3};
        int count = 100;
        System.out.println(l.solution(arr, count));
    }
    //list 가 클 경우에 하나하나 rotation 시키는 비용이 크므로 중간을 잘라서 앞뒤를 바꾸는 형식으로 하는 것이 좋습니다.

    private Queue<Integer> solution(int[] arr, int count) {

        // 1, 2, 3, 4, 5    => 1   :: 2, 3, 4, 5, 1  (석훈)  //  1 ~ 4 & 0
        // 1, 2, 3, 4, 5    => 2   ::  3, 4, 5, 1, 2  (석훈) //  2 ~ 3 & 0 ~1
        // 1, 2, 3, 4, 5    => 3  :: 4, 5, 1, 2, 3  (석훈) // 3 ~ 4 & 0 ~2
        // 1, 2, 3, 4, 5    => 4  :: 5, 1, 2, 3, 4  (석훈) // 4 & 0 ~ 3
        int [] result = new int[arr.length];

        System.arraycopy(arr,  (count % arr.length)  , result , 0, arr.length - (count % arr.length));
        System.arraycopy(arr,  arr.length - (count % arr.length)  , result , result.length, arr.length - (count % arr.length));

        System.out.println(Arrays.toString(result));

        //Insert 2번만 arr 길이 상관없이 무조건 딱 2번

        // answer = arr[5- 1]  // size
        // answer += arr[5 - size]





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
    }
}
