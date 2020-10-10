package remindprogrammers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class WordKungkungdda {
    public int[] solution(int n, String[] words) {
        int[] answer = new int[2];
        Set<String> set = new HashSet<>();
        boolean flag = true;

        for(int i=0; i<words.length; i++){

            if (set.contains(words[i])){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                flag = false;
                break;
            }

            set.add(words[i]);

            if (i>0 && words[i-1].charAt(words[i-1].length()-1) != words[i].charAt(0)){
                answer[0] = i%n + 1;
                answer[1] = i/n + 1;
                flag = false;
                break;
            }
        }

        if (flag){
            answer[0] = 0;
            answer[1] = 0;
        }

        return answer;
    }

    public static void main(String[] args) {
        WordKungkungdda w = new WordKungkungdda();

        System.out.println(Arrays.toString(w.solution(3, new String[]{"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank"})));
        System.out.println(Arrays.toString(w.solution(5, new String[]{"hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure", "establish","hang","gather","refer","reference","estimate","executive"})));
        System.out.println(Arrays.toString(w.solution(2, new String[]{"hello", "one", "even", "never", "now", "world", "draw"})));
    }
}
