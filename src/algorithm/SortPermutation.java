package algorithm;

import java.util.Arrays;

public class SortPermutation {

    //순서를 지키면서 arr 에서 n 개를 뽑는 경우
    public int[] solution(int[] arr, int depth, int n){
        boolean[] visited = new boolean[arr.length];

        // arr : 순열을 만들 배열
        int[] output = new int[n]; // 순열을 만든 후 배열
        sortPermutation(arr, output, depth, n, visited);

        return arr;
    }

    //여기서 depth는 output에 들어간 숫자의 길이
    //마찬가지로 n개중에서 r개를 뽑으려면 매개변수를 추가해줘야함.
    private void sortPermutation(int[] arr, int[] output, int depth, int n, boolean[] visited) {
        if(depth == n){
            System.out.println(Arrays.toString(output));
        }
        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                sortPermutation(arr, output, depth + 1, n,visited);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        SortPermutation p = new SortPermutation();
        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3}, 0, 3)));
    }
}
