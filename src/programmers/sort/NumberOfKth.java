package programmers.sort;

import java.util.Arrays;

public class NumberOfKth {
    public int[] solution(int[] array, int[][] commands) {

        int[] answer = new int[commands.length];

        for(int i=0; i<commands.length; i++){
            int first = commands[i][0];
            int end = commands[i][1];
            int place = commands[i][2];

            int[] temp =  new int[end-first+1];

            /*System.arraycopy(array1, 0 , array2, 0, array1.length)
            * array1의 0번째 값을 array2의 0번째로 array1의 길이만큼 복사*/
            System.arraycopy(array, first-1, temp, 0, temp.length);
            Arrays.sort(temp);
            answer[i] = temp[place-1];
        }
        return answer;
    }

    public static void main(String[] args) {
        NumberOfKth n = new NumberOfKth();
        System.out.println(Arrays.toString(n.solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})));
    }
}
