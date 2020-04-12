package programmers.dfsbfs;

import java.util.*;

public class TripRouteDfs {

    List<Stack<String>> result = new ArrayList<>();
    public String[] solution(String[][] tickets) {

        boolean[] visited = new boolean[tickets.length];

        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        dfs(tickets, stack, 0,visited);

        if(result.size() > 1){
            Collections.sort(result, new Comparator<Stack<String>>() {
                @Override
                public int compare(Stack<String> o1, Stack<String> o2) {
                    for(int i=0; i<o1.size(); i++){
                        String s1 = o1.get(i);
                        String s2 = o2.get(i);
                        if(!s1.equals(s2)){
                            return s1.compareTo(s2);
                        }
                    }
                    return 0;
                }
            });
        }

        System.out.println("result : "+ result);
        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];

        for(int i=0; i<res.size(); i++){
            answer[i] = res.get(i);
        }
        return answer;
    }

    private void dfs(String[][] tickets, Stack<String> stack, int cnt, boolean[] visited) {

        if(cnt == tickets.length){
            Stack<String> temp = new Stack<>();
            for(String s : stack){
                temp.push(s);
            }

            result.add(temp);
            return;
        }

        String current = stack.peek();

        for(int i=0; i<tickets.length; i++){
            String[] tempTicket = tickets[i];

            if(!visited[i] && current.equals(tempTicket[0])){
                visited[i] = true;
                stack.push(tempTicket[1]);

                dfs(tickets, stack, cnt+1, visited);
                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        TripRouteDfs t = new TripRouteDfs();
        System.out.println(Arrays.toString(t.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }
}
