package algorithm.sort;

import java.util.Arrays;

public class QuickSort {
    //최악의 경우 O(n제곱)
    //그렇지않고서는 O(nlogn)
    public int[] quickSort(int[] arr, int start, int end) {
        if (start < end){
            int pivot = partition(arr, start, end);
            quickSort(arr, start, pivot-1);
            quickSort(arr, pivot, end);
        }

        return arr;
    }

    private int partition(int[] arr, int start, int end) {
        int pivot = arr[(start+end) / 2];
        while (start <= end){
            while (arr[start] < pivot) start++;
            while (arr[end] > pivot) end--;
            if (start <= end){
                swap(arr, start, end);
                start++;
                end--;
            }
        }

        return start;
    }

    private void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    public static void main(String[] args) {
        QuickSort q = new QuickSort();
        System.out.println(Arrays.toString(q.quickSort(new int[]{31, 8, 48, 73, 11, 3, 20, 29, 65, 15}, 0, 9)));
    }
}
