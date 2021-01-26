package leetcode.medium;

import java.util.*;

/**
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number.
 * Return the maximum valued number you could get.
 *
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 108]
 */
public class MaximumSwap {
    //입력받은 수의 2개의 자리를 바꿔 만들 수 있는 가장 큰 수 구하기
    //이미 가장 큰 수 이면 그대로 리턴
    //숫자 2개를 마음대로 바꿀 수 있는게 아니고, 인접한 2개의 자리를 바꾸는게 전부

    /**
     * 1. 2자리 씩 자른다.
     * 2. 자른 2자리 중에 1의 자리가 가장 큰 수를 찾는다.
     * 3. 1의 자리 수가 같다면 10의 자리 수가 큰 수를 찾는다.
     * 4. 수의 숫자를 뒤집어서 출력한다.
     */
    public int maximumSwap(int num) {
        //2736 -> 27, 73, 36 -> 27 -> 7236
        char[] arr = Integer.toString(num).toCharArray();
        int[] temp = new int[10];
        
        for(int i=0; i<arr.length; i++){

            temp[arr[i] - '0'] = i;
        }
        System.out.println("Arrays.toString(arr) = " + Arrays.toString(arr));
        System.out.println("Arrays.toString(temp) = " + Arrays.toString(temp));

        for(int i=0; i<arr.length; i++){
            for(int j=9; j>arr[i]-'0'; j--){
                System.out.println("i = " + i);
                System.out.println("i = " + j);
                System.out.println("arr[i] = " + arr[i]);
                System.out.println("temp[j] = " + temp[j]);
                System.out.println("arr[temp[j]] = " + arr[temp[j]]);
                if (temp[j] > i){

                    char tmp = arr[i];
                    arr[i] = arr[temp[j]];
                    arr[temp[j]] = tmp;
                    return Integer.valueOf(new String(arr));
                }
            }
        }
        return num;




        /*int answer = 0;
        if (num < 10) return num;
        String number = Integer.toString(num);
        String arr[] = number.split("");

        StringBuffer sb = new StringBuffer();

        List<String> list = new ArrayList<>();

        for(int i=0; i<arr.length-1; i++){
            sb.append(arr[i]+arr[i+1]);
            list.add(sb.toString());
            sb.setLength(0);
        }
        System.out.println("list = " + list);

        int temp = 0;

        Map<Integer, Integer> oneMap = new HashMap<>();
        Map<Integer, Integer> tenMap = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            int one = Integer.parseInt(list.get(i)) % 10;
            int ten = Integer.parseInt(list.get(i)) / 10;
            //1의 자리만 큰 수를 어떻게 판별해서 들고있을까???
            //int max = Math.max(temp, one);
            oneMap.putIfAbsent(i, one);
            tenMap.putIfAbsent(i, ten);
            //temp = max;
            //System.out.println("max = " + max);
        }
        System.out.println("oneMap = " + oneMap);
        System.out.println("tenMap = " + tenMap);
        int max = Collections.max(oneMap.values());

        StringBuffer str1 = new StringBuffer();
        for (Integer key : oneMap.keySet()) {
            if (oneMap.get(key) == max) {
                str1.append(list.get(key));
            }
        }
        System.out.println("str1 = " + str1.toString());
        StringBuffer str2 = new StringBuffer();
        for(int i=1; i<list.size(); i++){
            if (i%2 == 0){
                 str2.append(list.get(i));
            }
        }
        String result = "";
        if (max == 0 && "".equals(str2.toString())) {
            result = str2.toString() + str1.toString();
        }else if ("0".equals(str1.toString()) || "".equals(str2.toString())) {
            result = str2.toString() + str1.reverse().toString();
        } else{
            result = str1.reverse().toString() + str2.toString();
        }

        return Integer.parseInt(result);*/
    }

    public static void main(String[] args) {
        MaximumSwap m = new MaximumSwap();
        System.out.println(m.maximumSwap(2736));
        System.out.println(m.maximumSwap(9973));
        System.out.println(m.maximumSwap(10));
        System.out.println(m.maximumSwap(12));
    }
}
