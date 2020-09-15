package algorithm.sort;

public class InsertionSort {
    //시간 복잡도는 O(n 제곱)
    // 뒤에서부터 앞 자리랑 비교하면서 값을 채워넣는 정렬
    public void insertionSort(int[] arr){
        int tmp;
        for(int i=1; i<arr.length; i++){
            for(int j=i; j>0; j--){
                if(arr[j-1] > arr[j]){
                    tmp = arr[j-1];
                    arr[j-1] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}
