package codinginterview.search;

public class BinarySearchRecursive {

    private int solution(int[] arr, int x, int low, int high) {
        int mid = (low + high) / 2;

        if(arr[mid] < x){
            return solution(arr, x, mid + 1, high);
        }else if(arr[mid] > x){
            return solution(arr, x, low, mid - 1);
        }else{
            return mid;
        }
    }

    public static void main(String[] args) {
        BinarySearchRecursive b = new BinarySearchRecursive();
        int []arr = {1,2,3,4,5};
        int x = 4;
        int low = 0;
        int high = arr.length - 1;

        System.out.println(b.solution(arr, x, low, high));
    }
}
