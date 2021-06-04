package inflearn.stringarray.sec5;

import java.util.*;

//https://leetcode.com/problems/word-ladder/solution/
//단어 변환 문제 BFS
// 프로그래머스에도 같은 문제 있음
public class WordLadder {
    //1 글자만 다름
    //못바꾸면 0, 바꿀 수 있는 경우 몇번만에 바꿨는지 리턴
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {

        //("hit","cog", ("hot","dot","dog","lot","log","cog"
        if (!wordList.contains(endWord)) return 0; // 빠른 탈출
        Set<String> diction = new HashSet<>(wordList);
        Set<String> begin = new HashSet<>();
        Set<String> end = new HashSet<>();
        begin.add(beginWord);
        end.add(endWord);

        int step = 1;
        Set<String> visited = new HashSet<>();

        while (!begin.isEmpty() && !end.isEmpty()) {
            Set<String> temp = new HashSet<>();
            for (String str : begin) {
                char[] chars = str.toCharArray();
                for(int i=0; i<chars.length; i++){
                    for(char c = 'a'; c<='z'; c++){
                        char current = chars[i];
                        chars[i] = c;
                        String word = new String(chars);

                        if (end.contains(word)) return step+1;

                        if (!visited.contains(word) && diction.contains(word)) {
                            temp.add(word);
                            visited.add(word);
                        }
                        chars[i] = current; //다시 원상복구
                    }
                }
            }
            begin = temp;
            step++;
        }

        return 0;
    }

    public static void main(String[] args) {
        WordLadder w = new WordLadder();
        System.out.println(w.ladderLength("hit","cog", new ArrayList<>(Arrays.asList("hot","dot","dog","lot","log","cog"))));
    }
}
