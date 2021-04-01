package leetcode.hard;

import java.util.Arrays;

//막대기 사이에 공간이 없고 오직 막대기로만 쌓았을때 이루어진 물의 넓이 구하
public class TrappingRainWater {
    //빗물채우기 문제
    public int trap(int[] height) {
        if (height.length == 0) return 0;

        int ans=0;
        int length = height.length;

        int[] leftMax = new int[length];
        int[] rightMax = new int[length];

        System.out.println(Arrays.toString(height));
        for(int i=1; i<height.length; i++){
            leftMax[i] = Math.max(height[i], leftMax[i-1]);
        }
        System.out.println(Arrays.toString(leftMax));
        for(int i=length-2; i>=0; i--){
            rightMax[i] = Math.max(height[i], rightMax[i+1]);
        }
        System.out.println(Arrays.toString(rightMax));

        for(int i=1; i<length-1; i++){
            ans = ans + Math.min(leftMax[i], rightMax[i]) - height[i];
        }

        return ans;
    }

    public int trap2(int[] height){
        if(height == null || height.length == 0) return 0;

        int left=0;
        int right = height.length-1;
        int maxLeft=0, maxRight=0;

        int total=0;

        while (left < right){
            if (height[left] < height[right]){
                //새로 max치를 찾으면 max를 교체하고
                if (height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
                    //그게 아니라면 max - 현재높이 만큼 물을 채울 수 있다.
                    total = total + maxLeft - height[left];
                }
                left++;
            }else{
                if (height[right] >= maxRight){
                    maxRight = height[right];
                }else{
                    total = total + maxRight - height[right];
                }

                right--;
            }
            System.out.println("total = " + total);
        }
        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap2(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
        //System.out.println(t.trap2(new int[]{4,2,0,3,2,5}));
        //System.out.println(t.trap2(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
