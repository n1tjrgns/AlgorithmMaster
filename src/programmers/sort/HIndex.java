package programmers.sort;

import java.util.Arrays;

public class HIndex {
    public int solution(int [] citations){

        int[] copy;
        int answer = 0;

        Arrays.sort(citations);
        System.out.println(Arrays.toString(citations));
        for(int i=0; i<citations.length; i++){
            int h = citations.length - i;
            System.out.println("h : "+ h);
            if(citations[i] >= h){
                answer = h;
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        HIndex h = new HIndex();
        System.out.println(h.solution(new int[]{3,0,6,1,5}));
    }
}
