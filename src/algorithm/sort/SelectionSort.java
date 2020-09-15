package algorithm.sort;

public class SelectionSort {

    //가장 큰 원소를 찾아서 맨 오른쪽 원소와 교환
    //하나의 원소만 남을 때까지 반복
    //시간복잡도 O(n 제곱)
    public void selectionSortMax(int[] arr){
        int tmp;
        int min;
        for(int i=0; i<arr.length-1; i++){
            min = i;
            for(int j=i+1; j<arr.length; j++){
                if (arr[j] < arr[min]){
                    min = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }

    public void selectionSortMin(int[] arr){
        int tmp;
        int max;

        for(int i=arr.length-1; i>0; i--){
            max = i;
            for(int j=i-1; j>=0; j--){
                if(arr[j] > arr[max]){
                    max = j;
                }
            }
            tmp = arr[i];
            arr[i] = arr[max];
            arr[max] = tmp;
        }
    }
}
