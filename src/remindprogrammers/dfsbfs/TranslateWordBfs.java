package remindprogrammers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class TranslateWordBfs {
    class Node{
        String next;
        int edge;

        Node(String next, int edge){
            this.next = next;
            this.edge = edge;
        }
    }
    public int solution(String begin, String target, String[] words) {
        int min = 0;
        int length = words.length;

        boolean[] visited = new boolean[words.length];

        Queue<Node> que = new LinkedList<>();
        que.add(new Node(begin, 0)); //시작점 0부터 시작

        while(!que.isEmpty()){
            Node current = que.poll();
            System.out.println("current : " + current.next);
            if(current.next.equals(target)){ //빠른 탈출
                min = current.edge;
                break;
            }

            for(int i=0; i<length; i++){
                if(!visited[i] && diffCheck(current.next, words[i])){
                    visited[i] = true;
                    que.add(new Node(words[i], current.edge+1));
                }
            }
        }

        return min;
    }

    private boolean diffCheck(String next, String word) {
        int cnt=0;
        for(int i=0; i<next.length(); i++){
            if (next.charAt(i) != word.charAt(i)){
                cnt++;
                if (cnt > 1){
                    cnt = 0;
                    break;
                }
            }
        }
        if (cnt == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        TranslateWordBfs t = new TranslateWordBfs();
        System.out.println(t.solution("hit","cog", new String[]{"hot","dot","dog","lot","log","cog"}));
    }
}
