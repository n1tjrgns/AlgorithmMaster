package programmers.dfsbfs;

public class TransString {
    int min = 0;
    public int solution(String begin, String target, String[] words) {

        //한 번에 한 단어만 변환 가능
        //변환 할 수 없으면 0 return

        // 바꿀 수 있는 조건
        // 하나의 단어만 달라야한다. -> 하나만 다르면 그 단어로 replace
        // -> 단어 비교는 어떻게?
        // 단어의 길이만큼 돌면서 DFS로 하나만 단어가 다른 경우 다른 단어로 replace하면서 카운트
        // 변환을 할 수 있는 만큼 했는데 target과 다르면 0을 리턴


        boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, min, visited);

        return min;
    }
    //https://artineer.tistory.com/123
    private int dfs(String begin, String target, String[] words, int answer, boolean[] visited) {
        // 시작, 타겟이 같으면 리턴 -> 빠른 탈출
        if(begin.equals(target)) {
            if(min == 0){
                min = answer;
            }else{
                min = Math.min(min, answer);
            }
        }
        //if ( begin.equals(target))
            //return answer;

        for(int i=0; i<words.length; i++){
            if(begin.equals(words[i])) continue; //같은 단어가 오면 continue
            // 아직 방문하지 않았고, 다른 단어의 수가 1개이면
            if (!visited[i] && diffCheck(begin, words[i])){
                visited[i] = true;
                dfs(words[i], target, words, answer+1, visited);
                visited[i] = false;
            }
        }

        return min;
    }

    //다른 단어가 1개이면 true, 1개 이상이면 false
    private boolean diffCheck(String begin, String word) {
        int cnt = 0;
        for(int i=0; i<begin.length(); i++){
            if(begin.charAt(i) != word.charAt(i)){
                cnt++;
                // 단어 하나만 다른 경우를 찾기
                if(cnt > 1){
                    cnt = 0;
                    break;
                }
            }
        }
        if (cnt == 1) return true;
        return false;
    }


    public static void main(String[] args) {
        TransString t = new TransString();
        System.out.println(t.solution("hit","cog",new String[]{"hot","dog","dog","lot","log","cog"}));
    }
}
