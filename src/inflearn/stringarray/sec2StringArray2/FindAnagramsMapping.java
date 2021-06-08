package inflearn.stringarray.sec2StringArray2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 두 배열이 존재할 때
 * A의 배열에 있는 값이 B의 배열의 몇번째 인덱스인지 인덱스 값을 반환해라.
 * B 배열은 A를 복사한 배열이고, 순서만 랜덤으로 바뀌어있다.
 */


public class FindAnagramsMapping {
    public int[] AnagramsMapping(int[] A, int[] B) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<B.length; i++){
            map.put(B[i], i);
        }

        int answer[] = new int[A.length];
        for (int i=0; i<A.length; i++){
            answer[i] = map.get(A[i]);
        }

        return answer;
    }
    public static void main(String[] args) {
        FindAnagramsMapping f = new FindAnagramsMapping();
        System.out.println(Arrays.toString(f.AnagramsMapping(new int[]{12, 28, 46, 32, 50}, new int[]{50, 12, 32, 46, 28})));
    }
}
