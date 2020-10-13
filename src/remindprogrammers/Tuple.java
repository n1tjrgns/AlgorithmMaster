package remindprogrammers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Tuple {
    public int[] solution(String s) {

        s = s.substring(2, s.length()-2).replace("},{","/");
        String[] str = s.split("/");


        Arrays.sort(str, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length() - o2.length();
            }
        });

        System.out.println(Arrays.toString(str));
        List<Integer> list = new ArrayList<>();

        for(String num : str) {
            String[] arr = num.split(",");

            for (int i = 0; i < arr.length; i++) {
                int n = Integer.parseInt(arr[i]);
                if (!list.contains(n)){
                    list.add(n);
                }
            }
        }

        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        Tuple t = new Tuple();
        System.out.println(Arrays.toString(t.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
    }
}
