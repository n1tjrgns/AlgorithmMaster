package baekjoon.search;

import java.util.Scanner;
//https://www.acmicpc.net/problem/10974

/*입력
첫째 줄에 N(1 ≤ N ≤ 8)이 주어진다.

출력
첫째 줄부터 N!개의 줄에 걸쳐서 모든 순열을 사전순으로 출력한다.*/
public class AllPermutation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n]; //순열을 만들 배열
        int[] output = new int[n]; //순열을 만든 후 배열
        boolean[] visited = new boolean[n];

        //1, 2, 3 셋팅
        for(int i=0; i<n; i++){
            arr[i] = i+1;
        }

        permutationDfs(arr, output, visited, 0, n, n);
    }

    //순서를 지키면서 n개 중에서 r개를 뽑는 경우
    private static void permutationDfs(int[] arr, int[] output, boolean[] visited, int depth, int n, int r) {
        if(depth == r){
            print(output);
            return;
        }

        for(int i=0; i<n; i++){
            if(!visited[i]){
                visited[i] = true;
                output[depth] = arr[i];
                permutationDfs(arr, output, visited, depth+1, n, r);
                visited[i] = false;
            }
        }
    }

    private static void print(int[] output) {
        for(int i=0; i<output.length; i++){
            System.out.print(output[i] + " ");
        }
        System.out.println();
    }


}
