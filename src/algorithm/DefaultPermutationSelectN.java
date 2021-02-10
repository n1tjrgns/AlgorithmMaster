package algorithm;

import java.util.Arrays;

public class DefaultPermutationSelectN {
    //순서 없이 arr.length개 중에서 n개를 뽑는 경우
    //permutation(arr, 0, n)
    public static void main(String[] args) {
        DefaultPermutationSelectN p = new DefaultPermutationSelectN();
        System.out.println(Arrays.toString(p.solution(new int[]{1, 2, 3}, 0, 3)));
    }

    public int[] solution(int[] arr, int depth, int n){
        permutation(arr,0,n);

        return arr;
    }
     void permutation(int[] arr, int depth, int n){
        if(depth == n){
            System.out.println(Arrays.toString(arr));
        }
        for(int i=depth; i<arr.length; i++){
            swap(arr, i, depth);
            permutation(arr, depth + 1, n);
            swap(arr, i, depth);
        }
    }

    void swap(int[] arr, int depth, int i) {
        int temp = arr[depth];
        arr[depth] = arr[i];
        arr[i] = temp;
    }
}
