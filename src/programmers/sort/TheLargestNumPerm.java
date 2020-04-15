package programmers.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
//1차 풀이, 순열을 사용한 완탐으로 풀었지만 숫자가 넘 커져서 실패
public class TheLargestNumPerm {
    private int[] numbers;
    private List<Integer> list = new ArrayList<>();

    public String solution(int[] numbers){
        this.numbers = numbers;
        list.add(Integer.MIN_VALUE);
        perm(numbers, 0, numbers.length);


        //System.out.println(list);
        //return Integer.toString(Collections.max(list));
        return Integer.toString(list.get(0));
    }

    private void perm(int[] numbers, int depth, int length) {
        if(depth == length){
            makeNumber(numbers, length);
        }else{
            for(int i=depth; i<numbers.length; i++){
                swap(numbers, i, depth);
                perm(numbers, depth+1, length);
                swap(numbers, i, depth);
            }
        }
    }

    private void swap(int[] numbers, int i, int j) {
        int temp = numbers[i];
        numbers[i] = numbers[j];
        numbers[j] = temp;
    }

    private void makeNumber(int[] numbers, int length) {
        String num = "";
        //숫자로 하려니 배열 안의 값이 2자리 넘어가면 값이 꼬여버림 -> String으로 더하자
        System.out.println("numbers: " + Arrays.toString(numbers));
        int temp = Integer.MIN_VALUE;
        for(int i=0; i<length; i++){
            num = num + numbers[i];
        }
        /*for(int i=0; i<length; i++){
            num = (int) (num + numbers[i] * Math.pow(10, length-i-1));
        }*/

        //temp = Math.max(temp, Integer.parseInt(num));
        //set에 다 넣는거는 너무 비효율적이야

        //set.add(temp);
        if(list.get(0) >= Integer.parseInt(num)){

        }else{
            list.remove(0);
            list.add(Integer.parseInt(num));
        }
    }

    /*private void checkMax(String num) {
        int temp = Integer.MIN_VALUE;

        temp = Math.max(num, temp);

        set.add(temp);
    }*/

    public static void main(String[] args) {
        TheLargestNumPerm t = new TheLargestNumPerm();
        //System.out.println(t.solution(new int[]{6,10,2})); //"6210"
        System.out.println(t.solution(new int[]{3,34,30})); //"6210"
        //System.out.println(t.solution(new int[]{0, 9, 8, 7, 96})); //"996870"
        //System.out.println(t.solution(new int[]{3,30,34,5,9})); //"9534330"
    }

}