package programmers.stacknq;

import java.util.Arrays;

public class Top2 {
    public int[] solution(int[] heights) {
        int[] answer = new int[heights.length];

        for(int i=heights.length-1; i>-1; i--){
            for(int j=i-1; j>-1; j--){

                //System.out.println("i : " + heights[i] + " j: "+heights[j]);
                if(heights[i] < heights[j]){
                    answer[i] = j+1;
                    break;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Top2 t = new Top2();
        System.out.println(Arrays.toString(t.solution(new int[]{6, 9, 5, 7, 4})));
    }
}
