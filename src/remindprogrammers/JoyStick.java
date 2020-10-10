package remindprogrammers;

public class JoyStick {
    public int solution(String name) {
        int answer = 0;
        //위 아래로 움직이는 최소 비교와 양 좌우로 움직이는 최소를 비교해야함
        // 한 글자를 변경완료 한 후 옆 글자로 갈 때 + 1
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<name.length(); i++){
            sb.append("A");
        }
        //Arrays.fill로 대체 가능

        String def = sb.toString();
        System.out.println("def = " + def);
        for(int i=0; i<def.length(); i++){
            if(Math.abs(name.charAt(i) - def.charAt(i)) > 13){
                answer = answer + 26 - Math.abs(name.charAt(i) - def.charAt(i));
            }else{
                answer = answer + Math.abs(name.charAt(i) - def.charAt(i));
            }
        }

        System.out.println("answer = " + answer);

        int minMove = name.length()-1;
        for(int i=0; i<name.length(); i++){
            if (name.charAt(i) != 'A'){
                int next = i+1;

                while (next < name.length() && name.charAt(next) == 'A'){
                    next++;
                }

                int count = i * 2 + name.length() - next;
                minMove = Math.min(minMove, count);
            }
        }

        System.out.println("minMove = " + minMove);

        return answer + minMove;
    }

    public static void main(String[] args) {
        JoyStick j = new JoyStick();
        System.out.println(j.solution("JAZ"));
        System.out.println(j.solution("JEROEN"));
        System.out.println(j.solution("JAN"));
    }
}
