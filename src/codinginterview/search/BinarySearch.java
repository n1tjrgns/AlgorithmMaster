package codinginterview.search;

public class BinarySearch {

    public int solution(int[] arr, int x){
        int low = 0;
        int high = arr.length - 1;
        int mid;

        while(low <= high){
            mid = (low + high) / 2;
            if(arr[mid] < x){
                low = mid + 1;
            }else if(arr[mid] > x){
                high = mid - 1;
            }else{
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        BinarySearch b = new BinarySearch();
        int []arr = {1,2,3,4,5};
        int x = 4;

        System.out.println(b.solution(arr, x));
    }

}
