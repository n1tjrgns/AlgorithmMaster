package inflearn.stringarray.sec4QueStack;

import java.util.ArrayList;
import java.util.List;

public class BaseballGame {
    public int calPoints(String[] ops) {
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<ops.length; i++){
            if ("+".equals(ops[i])){
                list.add(list.get(list.size()-1) + list.get(list.size()-2));
            }
            else if ("D".equals(ops[i])){
                list.add(list.get(list.size()-1) * 2);
            }
            else if ("C".equals(ops[i])){
                list.remove(list.size()-1);
            } else {
                list.add(Integer.parseInt(ops[i]));
            }
        }

        int sum=0;
        for (Integer integer : list) {
            sum = sum + integer;
        }

        return sum;
    }

    public static void main(String[] args) {
        BaseballGame b = new BaseballGame();
        System.out.println(b.calPoints(new String[]{"5","2","C","D","+"})); // 30
    }
}
