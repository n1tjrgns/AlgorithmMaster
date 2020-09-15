package algorithm.sort;

public class BubbleSort {
    // 시간 복잡도 O(n 제곱)
    public void bubbleSort(int[] input, int length){
        int tmp;
        for(int i=0; i<input.length-1; i++){
            for(int j=0; j<i; j++){
                if(input[j] > input[j+1]){
                    tmp = input[j];
                    input[j] = input[j+1];
                    input[j+1] = tmp;
                }
            }
        }
    }
}
