package inflearn.stringarray.sec2StringArray2;

public class TrappingRainWater {
    public int trap(int[] height) {
        //max 높이 - 현재 높이 = 물의 높이
        if (height == null || height.length == 0) return 0;

        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight= 0;
        int total = 0;

        while (left < right){
            if (height[left] < height[right]){
                if (height[left] >= maxLeft){
                    maxLeft = height[left];
                }else{
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
        }

        return total;
    }

    public static void main(String[] args) {
        TrappingRainWater t = new TrappingRainWater();
        System.out.println(t.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
