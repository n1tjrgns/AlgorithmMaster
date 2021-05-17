package inflearn.stringarray.sec1;

import java.util.Arrays;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        int answer[] = new int[T.length];
        int idx=0;
        for(int i=0; i<T.length-1; i++){
            for (int j=i+1; j<T.length; j++){
                System.out.println("T[j] : " + T[j] + " :: T[i] : " + T[i] );
                if (T[j] - T[i] > 0){
                    answer[idx++] = j-i;
                    break;
                }
                if (j == T.length-1 && T[j] - T[i] <= 0){
                    answer[idx++] = 0;
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        DailyTemperatures dailyTemperatures = new DailyTemperatures();
        System.out.println(Arrays.toString(dailyTemperatures.dailyTemperatures(new int[] {73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
