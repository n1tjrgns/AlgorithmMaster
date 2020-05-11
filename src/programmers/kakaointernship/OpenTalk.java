package programmers.kakaointernship;

import java.util.*;

public class OpenTalk {
    /* 닉네임 변경 방법
     1. 채팅방을 나간 후 새로운 닉네임으로 들어간다
     2. 채팅방에서 닉네임을 변경한다 -> 기존 채팅방 닉네임도 전부 변경된다.
        - 닉네임은 중복 허용한다.
        - 결과값은 최종 결과를 출력한다.
    * */
    public String[] solution(String[] record) {
        String[] answer = {};

        // enter, leave, change 입장 상태값
        // uid : 아이디 고유값
        // 닉네임
        List<String> list = new ArrayList<>();
        Map<String,String> map = new HashMap<>();

        //이 문제의 핵심 : 모든 기록이 처리된 후, 최종적으로 방을 개설한 사람이 보게 되는 메시지
        // 닉네임 변경은 기록되지 않는다. 다만 변경될 경우 입, 퇴장 아이디역시 변한 값으로 보여야한다.

        //방을 나간 경우, 입장이라는 조건이 선행되어야 하기 때문에 uid만 알면된다.
        //leave를 뺀 나머지를 map에 담는다.
        for(String r : record){
            String temp[] = r.split(" ");
            if(!temp[0].equals("Leave")){
                map.put(temp[1], temp[2]);
            }
        }

        for(String r : record){
            String temp[] = r.split(" ");
            if(temp[0].equals("Enter")){
                list.add(map.get(temp[1])+"님이 들어왔습니다");
            }else if(temp[0].equals("Leave")){
                list.add(map.get(temp[1])+"님이 나갔습니다");
            }
        }

        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
       return answer;
    }

    public static void main(String[] args) {
        OpenTalk o = new OpenTalk();
        System.out.println(Arrays.toString(o.solution(new String[]{"Enter uid1234 Muzi", "Enter uid4567 Prodo","Leave uid1234","Enter uid1234 Prodo","Change uid4567 Ryan"})));
    }
}
