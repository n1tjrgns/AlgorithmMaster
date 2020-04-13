package programmers.dfsbfs;

import java.util.*;

public class TripRoute {
    List<Stack<String>> result;

    public String[] solution(String[][] tickets) {
        result = new ArrayList<>();

        boolean[] visited = new boolean[tickets.length];
        Stack<String> stack = new Stack<>();
        stack.push("ICN");

        dfs(visited, stack, tickets, 0);

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

        Stack<String> res = result.remove(0);
        String[] answer = new String[res.size()];

        for(int i=0; i<answer.length; i++){
            answer[i] = res.get(i);
        }

        return answer;
    }

    private void dfs(boolean[] visited, Stack<String> stack, String[][] ticket, int cnt) {

        //끝까지 다 돌았을 때
        if(cnt == ticket.length){
            Stack<String> temp = new Stack<>();
            for(String s : stack){
                temp.push(s);
            }

            result.add(temp);
            return;
        }

        String current = stack.peek();


        for(int i=0; i<ticket.length; i++){
            String[] tempTicket = ticket[i];
            System.out.println("current : "+current);
            System.out.println("ticket["+i+"] : "+Arrays.toString(ticket[i]));
            System.out.println("tempTicket["+i+"] : "+Arrays.toString(tempTicket));


            if(!visited[i] && current.equals(tempTicket[0])){
                System.out.println("current : "+current + " tempTicket[0] : "+ tempTicket[0]);
                System.out.println("push : "+tempTicket[1]);
                stack.push(tempTicket[1]);
                visited[i] = true;

                dfs(visited, stack, ticket, cnt+1);

                visited[i] = false;
                stack.pop();
            }
        }
    }

    public static void main(String[] args) {
        TripRoute t = new TripRoute();
        System.out.println(Arrays.toString(t.solution(new String[][]{{"ICN", "SFO"}, {"ICN", "ATL"}, {"SFO", "ATL"}, {"ATL", "ICN"}, {"ATL", "SFO"}})));
    }
}
