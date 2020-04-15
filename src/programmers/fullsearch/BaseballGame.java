package programmers.fullsearch;

import java.util.HashSet;
import java.util.Set;

public class BaseballGame {
    // 순열 알고리즘 사용을 사용한 bruteforce 풀이
    Set<Integer> set = new HashSet<>();
    private int[][] baseball;

    public int solution(int[][] baseball) {
        this.baseball = baseball;
        int[] arr = {1,2,3,4,5,6,7,8,9}; //숫자야구에 사용 될 숫자들

        // 깊이는 0부터, 숫자야구는 3자리씩 비교니까 최종 k=3
        perm(arr, 0, 3);

        return set.size();
    }

    public void perm(int[] arr, int depth, int k) {
        if (depth == k) {
            returnNumber(arr, k);
        } else {
            for (int i=depth; i<arr.length; i++) {
                swap(arr, i, depth);
                perm(arr, depth + 1, k);
                swap(arr, i, depth);
            }
        }
    }

    public void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //3개씩 자른 배열
    private void returnNumber(int[] arr, int k) {
        int num = 0;

        for(int i=0; i<k; i++){
            num = (int) (num + Math.pow(10,k-i-1) * arr[i]);
        }

        check(num);
    }

    //이제 가져온 숫자로 야구게임 시작
    private void check(int num) {
        int strike = 0;
        int ball = 0;
        boolean visit = false;

        //"123"
        String numStr = Integer.toString(num);

        for(int i=0; i<baseball.length; i++){
            //"123"
            String baseballStr = Integer.toString(baseball[i][0]);
            for(int j=0; j<3; j++){
                char current = baseballStr.charAt(j);
                if(current == numStr.charAt(j)){
                    strike++;
                }else{
                    if(numStr.contains(Character.toString(current))){
                        ball++;
                    }
                }
            }

            //빠른 탈출
            if(strike != baseball[i][1] || ball != baseball[i][2]){
                visit = true;
                break;
            }

            //변수 초기화
            strike = 0;
            ball = 0;
        }
        if(!visit){
            set.add(num);
        }
    }

    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        System.out.println(b.solution(new int[][]{{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}}));
    }
}
