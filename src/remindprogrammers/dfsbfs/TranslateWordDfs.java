package remindprogrammers.dfsbfs;

public class TranslateWordDfs {
    int min=0;
    public int solution(String begin, String target, String[] words) {

        //가장 짧은과정.
        //탐색을 하고 나온 결과를 이전의 횟수와 min으로 비교를 하는 과정이 필요함
        //단어 배열의 깊이만큼 돌면서 시작단어의 끝과 다음 단어의 첫부분이 같은지 체크
        //같다면 거기서 다시 전체 배열을 탐색
        //매 단계마다 카운
        boolean[] visited = new boolean[words.length];
            dfs(begin,target,words,min,visited);

        return min;
    }

    private void dfs(String begin, String target, String[] words, int answer, boolean[] visited) {
        //빠른 탈출
        if (begin.equals(target)){
            min = answer;
        }else{
            min = Math.min(min,answer);
        }

        for(int i=0; i<words.length; i++){
            if (!visited[i] && diffCheck(begin, words[i])){
                visited[i] = true;
                dfs(words[i],target,words,answer+1,visited);
                visited[i] = false; //다시 전체를 탐색해야하기때문에 false가 필요해
            }
        }
    }

    private boolean diffCheck(String begin, String word) {
        int cnt=0;
        for(int i=0; i<begin.length(); i++){
            if (begin.charAt(i) != word.charAt(i)){
                cnt++;
                if (cnt > 1){
                    cnt = 0;
                    break;
                }
            }
        }
        if(cnt == 1) return true;
        return false;
    }

    public static void main(String[] args) {
        TranslateWordDfs t = new TranslateWordDfs();
        System.out.println(t.solution("hit","cog", new String[]{"hot","dot","dog","lot","log","cog"}));
    }
}
