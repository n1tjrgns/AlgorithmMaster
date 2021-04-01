package leetcode.medium;

/**
 * https://leetcode.com/problems/container-with-most-water/
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0).
 * Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
 *
 * Notice that you may not slant the container.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: height = [1,8,6,2,5,4,8,3,7]
 * Output: 49
 * Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case, the max area of water (blue section) the container can contain is 49.
 * Example 2:
 *
 * Input: height = [1,1]
 * Output: 1
 * Example 3:
 *
 * Input: height = [4,3,2,1,4]
 * Output: 16
 * Example 4:
 *
 * Input: height = [1,2,1]
 * Output: 2
 *
 *
 * Constraints:
 *
 * n == height.length
 * 2 <= n <= 3 * 104
 * 0 <= height[i] <= 3 * 104
 */

//막대기 사이사이에 공간이 있어서 들어갈 수 있는 물의 공간 구하기
public class ContainerWithMostWater {
    //공간이 줄어들면 그만큼 물을 채울 수 있는 면적이 줄어들기 때문에 안된다.
    //한쪽 벽이 아무리 높아도 다른 쪽이 낮아버리면 결국 다른 쪽 높이 만큼 밖에 안 채워진다.
    //낮은 벽의 높이 * 두 벽 사이의 공간 길이
    public int maxArea(int[] height) {
        int max=0;
        int result=0;
        //근데 속도가 너무 느리다 어떻게하면 좀 더 빨라질까?
        /*for(int i=0; i<height.length; i++){
            for (int j=height.length-1; j>=0; j--){
                if (height[i] < height[j]) {
                    result = height[i] * (j-i);
                }
                else {
                    result = height[j] * (j-i);
                }
                max = Math.max(max, result);
            }
        }*/
        int left = 0, right = height.length-1;
        while (left < right){
            if (height[left] < height[right]) {
                result = height[left] * ( right-left);
                left++;
            }
            else {
                result = height[right] * (right-left);
                right--;
            }
            max = Math.max(max, result);
        }
        return max;
    }

    public static void main(String[] args) {
        ContainerWithMostWater c = new ContainerWithMostWater();
        System.out.println(c.maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
