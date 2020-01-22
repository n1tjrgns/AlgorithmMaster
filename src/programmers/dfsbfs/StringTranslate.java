/*단어 변환
문제 설명
두 개의 단어 begin, target과 단어의 집합 words가 있습니다. 아래와 같은 규칙을 이용하여 begin에서 target으로 변환하는 가장 짧은 변환 과정을 찾으려고 합니다.

1. 한 번에 한 개의 알파벳만 바꿀 수 있습니다.
2. words에 있는 단어로만 변환할 수 있습니다.
예를 들어 begin이 hit, target가 cog, words가 [hot,dot,dog,lot,log,cog]라면 hit -> hot -> dot -> dog -> cog와 같이 4단계를 거쳐 변환할 수 있습니다.

두 개의 단어 begin, target과 단어의 집합 words가 매개변수로 주어질 때, 최소 몇 단계의 과정을 거쳐 begin을 target으로 변환할 수 있는지 return 하도록 solution 함수를 작성해주세요.

제한사항
각 단어는 알파벳 소문자로만 이루어져 있습니다.
각 단어의 길이는 3 이상 10 이하이며 모든 단어의 길이는 같습니다.
words에는 3개 이상 50개 이하의 단어가 있으며 중복되는 단어는 없습니다.
begin과 target은 같지 않습니다.
변환할 수 없는 경우에는 0를 return 합니다.
입출력 예
begin	target	words	return
hit	cog	[hot, dot, dog, lot, log, cog]	4
hit	cog	[hot, dot, dog, lot, log]	0
입출력 예 설명
예제 #1
문제에 나온 예와 같습니다.

예제 #2
target인 cog는 words 안에 없기 때문에 변환할 수 없습니다.*/

package programmers.dfsbfs;

import java.util.LinkedList;
import java.util.Queue;

public class StringTranslate {

    static boolean[] visited;
    public static void main(String[] args) {
        StringTranslate s = new StringTranslate();
        String b = "hit";
        String t = "cog";
        String[] arr = {"hot", "dot", "dog", "lot", "log"};
        System.out.println(s.solution(b,t,arr));
    }

    public int solution(String begin, String target, String[] words) {
        //시작점이 불특정 할 경우에는 Network 문제처럼  for문으로 돌려서 시작하면 되지만,
        //start가 정해져있는 경우에는 for문이 필요없고, index 값또한 필요가 없다.
        visited = new boolean[words.length];
        return BFS(begin, target, words, begin.length());
    }
    public static int BFS(String begin, String target, String [] words, int wordSize)
    {
        int results = 0;
        Queue<String> q = new LinkedList<>();
        q.offer(begin);
        String tempQue ="";
        while (!q.isEmpty())
        {
            String peek = q.peek();
            tempQue = q.poll();

            if (tempQue.equals(target)) return results;
            boolean isAdd = false;

            /**
             *        String b = "hit";
             *         String t = "cog";
             *         String[] arr = {"hot", "dot", "dog", "lot", "log"};
             */

            /**
             * 큐에 쌓이는건 선입선출이기 때문에 아직 남아 있는 것까지 생각해야함.
             * 1) temp:: hit -> hot , result =1, visit[0] = true , que = hot
                * 2) temp:: hot -> dot, lot  , result = 2, visit[0, 1, 3] = true, que = dot, lot
                * 3-1) dot -> dog, log , result = 3, visit[0, 1, 2, 3, 4] = true, que = lot, dog, log
                * 3-2) lot -> "" , result = 2, visit[0, 1, 2, 3, 4] = true, que = dog, log
                * 4-1) dog > "" , result = 1, visit[0, 1, 2, 3, 4] = true, que = log
                * 4-2) log > "" , result = 0, visit[0, 1, 2, 3, 4] = true, que = ""
                */


            /*
            hit	cog	[hot, dot, dog, lot, log, cog]
             */

            /**
             * 1) temp:: hit -> hot , result =1, visit[0] = true , que = hot
             * 2) temp:: hot -> dot, lot  , result = 2, visit[0, 1, 3] = true, que = dot, lot
             * 3-1) dot -> dog result = 3, visit[0, 1, 2, 3] = true, que = lot, dog
             * 3-2) lot -> log , result = 4, visit[0, 1, 2, 3, 4] = true, que = dog, log
             * 3-3) dog -> cog, result = 5, visit[0, 1, 2, 3, 4, 5] = true, que = log
             * 3-3) log -> "", result = 4, visit[0, 1, 2, 3, 4, 5] = true, que = ""
             */

            for (int i = 0; i < words.length; i++)
            {
                if (visited[i]) continue;

                String word = words[i];
                int diff = 0;
                for (int j = 0; j < wordSize; j++)
                    if (tempQue.charAt(j) != word.charAt(j)) diff++;
                if (diff == 1)
                {
                    isAdd = true;
                    visited[i] = true;
                    q.offer(word);
                }
            }

            if (isAdd) results++;
            else results--;
        }
        return 0;
    }
}
