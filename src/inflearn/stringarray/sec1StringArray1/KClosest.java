package inflearn.stringarray.sec1StringArray1;

import java.util.Arrays;

public class KClosest {
    public int[][] kClosest(int[][] points, int k) {
        //유클리드 거리 계산 공식을 적용했을 때 작은 순서쌍 리턴.
        // k갯수 만큼 작은 수 부터 리턴해야함.

        // 바로 유클리드 공식으로 작은 수 부터 오름차순으로 정렬
        Arrays.sort(points, (p1,p2) ->(int) Math.pow(p1[0],2) + (int) Math.pow(p1[1],2) -
                                (int) Math.pow(p2[0],2) + (int) Math.pow(p2[1],2));

        for (int[] point : points) {
            System.out.println("point = " + Arrays.toString(point));
        }

        //k개만큼만 배열을 복사하여 리턴 -> 2차원 배열도 바로 복사 가능하네.
        return Arrays.copyOfRange(points,0,k);
    }

    public static void main(String[] args) {
        KClosest k = new KClosest();
        System.out.println(Arrays.deepToString(k.kClosest(new int[][]{{1, 3}, {-2, 2}}, 1)));
    }
}
