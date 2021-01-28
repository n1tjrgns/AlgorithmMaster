package leetcode.medium;

import java.awt.print.Pageable;
import java.util.Arrays;

/**
 * https://leetcode.com/problems/maximum-length-of-repeated-subarray/
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 *
 * Example 1:
 *
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 *
 *
 * Note:
 *
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 *
 */
public class MaximumLengthofRepeatedSubarray {
    //두 배열에서 반복되는 요소의 최대 길이값 구하기
    //그냥 숫자 배열의 형태의 경우에는 최초의 숫자가 일치했을 때,
    //그 다음 연속해서 나오는 숫자까지 일치하는지 판단하기 어려움
    //substring으로 만들어서 문자열을 비교하는 식으로 하면??
    public int findLength(int[] A, int[] B) {
        int ans=0;
        int memo[][] = new int[A.length+1][B.length+1];
        int max = 0;
        for (int i = 1; i <= A.length; i++) {
            for (int j = 1; j <= B.length; j++) {
                if (A[i - 1] == B[j - 1]) {
                    memo[i][j] = memo[i - 1][j - 1] + 1;
                    max = Math.max(max, memo[i][j]);
                }
            }
        }
        /*for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {
                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) ans = memo[i][j];
                }
            }
        }*/

        return max;





        /*int ans = 0;
        int[][] memo = new int[A.length + 1][B.length + 1];
        System.out.println("memo = " + memo.length);
        *//* A: [1,2,3,2,1]
         * B: [3,2,1,4,7]*//*
        for (int i = A.length - 1; i >= 0; --i) {
            for (int j = B.length - 1; j >= 0; --j) {
                if (A[i] == B[j]) {

                    memo[i][j] = memo[i+1][j+1] + 1;
                    if (ans < memo[i][j]) {
                        ans = memo[i][j];

                    }
                }
            }
        }
        return ans;*/
        /*

        나의 틀린 풀이
        int answer = 0;

        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        
        for (int i : A) {
            a.append(i);
        }

        for (int i : B) {
            b.append(i);
        }
        System.out.println("a.toString() = " + a.toString());
        System.out.println("b.toString() = " + b.toString());
        int max = 0;
        int realMAx = 0;
        for(int i=1; i<=A.length; i++){
            for(int j=1; j<=B.length; j++){
                System.out.println("a.toString().substring(0,i) = " + a.toString().substring(i-1, i));
                System.out.println("b.toString().substring(0,j)) = " + b.toString().substring(j-1, j));
                if (a.toString().substring(i-1,i).equals(b.toString().substring(j-1,j))){

                    i++;
                    answer++;
                    System.out.println("i = " + i);
                    System.out.println("answer = " + answer);
                    max = Math.max(max, answer);
                    System.out.println("max = " + max);
                    if (i == A.length+1) break;
                }else{
                    break;
                }
            }
            realMAx = Math.max(realMAx, max);
            System.out.println("realMAx = " + realMAx);
        }

        return realMAx;*/
    }

    public static void main(String[] args) {
        MaximumLengthofRepeatedSubarray m = new MaximumLengthofRepeatedSubarray();
        System.out.println(m.findLength(new int[]{1,2,3,2,1}, new int[]{3,2,1,4,7}));
        //System.out.println(m.findLength(new int[]{0,0,0,0,1}, new int[]{1,0,0,0,0}));
    }
}
