package programmers.hash;

import java.util.HashMap;
import java.util.Map;

//https://programmers.co.kr/learn/courses/30/lessons/42578
public class CamoRemind {
    public int solution(String[][] clothes) {
        //하루 하나는 무조건 입어야 함
        // [옷 이름][옷 카테고리]
        // 겹치는 옷 이름은 없음

        //우선 카테고리 별, 옷의 개수를 Map에 저장해야 함.
        HashMap<String, Integer> map = new HashMap<>();

        for(int i=0; i<clothes.length; i++){
            if(map.get(clothes[i][1])  == null ){
                map.put(clothes[i][1], 1);
            }else{
                int value = map.get(clothes[i][1]) + 1;
                map.put(clothes[i][1], value);
            }
        }
        System.out.println(map);

        //이제 저장한 옷의 카테고리 별 갯수로 나올 수 있는 조합을 구해서 리턴해줘야 함.
        //경우의 수 공식 : 합의 법칙 + 곱의 법칙 (n + r) + (n * r)
        // (1+2) + (1*2)

        int answer = 0;
        for(Map.Entry<String, Integer> clothCount : map.entrySet()){
            answer = (answer + map.get(clothCount.getKey())) + answer * map.get(clothCount.getKey());
        }
        return answer;
    }

    public static void main(String[] args) {
        CamoRemind c = new CamoRemind();
        System.out.println(c.solution(new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}}));
    }

}
