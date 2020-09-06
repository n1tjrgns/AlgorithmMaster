package leetcode.medium;

import java.util.HashMap;
import java.util.Map;

public class FourSum2 {
    //A + B + C + D = 0 -> A + B = -C - D
    //각각의 배열별로 인덱스가 다를 수 있으므로 탐색이 불가능함.
    public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
        Map<Integer,Integer> map = new HashMap<>();
        int count =0;

        for(int i=0; i<A.length; i++){
            for(int j=0; j<B.length; j++){
                int sum = A[i] + B[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        for(int i=0; i<C.length; i++){
            for(int j=0; j<D.length; j++){
                int sum = C[i] + D[j];
                count = count + map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }

    public static void main(String[] args) {
        FourSum2 f = new FourSum2();
        System.out.println(f.fourSumCount(new int[]{1,2},new int[]{-2,-1}, new int[]{-1,2}, new int[]{0,2}));
    }
}
