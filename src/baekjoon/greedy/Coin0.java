/*동전 0
시간 제한	메모리 제한	제출	정답	맞은 사람	정답 비율
1 초	256 MB	23678	12874	10431	54.955%
문제
준규가 가지고 있는 동전은 총 N종류이고, 각각의 동전을 매우 많이 가지고 있다.

동전을 적절히 사용해서 그 가치의 합을 K로 만들려고 한다. 이때 필요한 동전 개수의 최솟값을 구하는 프로그램을 작성하시오.

입력
첫째 줄에 N과 K가 주어진다. (1 ≤ N ≤ 10, 1 ≤ K ≤ 100,000,000)

둘째 줄부터 N개의 줄에 동전의 가치 Ai가 오름차순으로 주어진다. (1 ≤ Ai ≤ 1,000,000, A1 = 1, i ≥ 2인 경우에 Ai는 Ai-1의 배수)

출력
첫째 줄에 K원을 만드는데 필요한 동전 개수의 최솟값을 출력한다.

예제 입력           출력 6
10 4200
1
5
10
50
100
500
1000
5000
10000
50000*/
package baekjoon.greedy;

import java.util.Scanner;

public class Coin0 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int cnt = 0;

        int []arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        for (int i=n-1; i>=0; i--){
            if(arr[i] <= k ){
                cnt = cnt + k/arr[i];
                k = k%arr[i];
            }
        }

        System.out.println(cnt);
    }

}
