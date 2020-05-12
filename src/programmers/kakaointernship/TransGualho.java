package programmers.kakaointernship;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;
//https://programmers.co.kr/learn/courses/30/lessons/60058
public class TransGualho {
    /*
    (와 )의 개수가 같으면 균형잡힌 괄호
    개수가 같으면서 짝도 맞는경우 올바른 괄호 문자열열    * */
    public String solution(String p) {
        //빈 문자열 -> 빈 문자열 반환
        // 문자열 p를 최초의 균형잡힌 문자열과(u) 나머지 균형잡힌 문자열로 분리(v)
        // u가 올바른 문자열이면 v를 다시 맨 위부터 실행.
        //u가 올바른 문자열이 아니면,
        // 빈 문자열에 첫 번째 문자로 ( 를 붙임
        // v를 붙임
        // )를 붙임
        // 가공한 u에 대해서 첫번째 문자와 마지막 문자를 제거, 나머지 문자열의 괄호 방향을 뒤집어서 이어 붙이기
        // 생성된 문자열 반환
        if (p.equals("")) {
            return p;
        }
        String answer = "";
        String[] splitP = p.split("");
        List<String> paramList = new ArrayList<>();
        paramList.addAll(Arrays.asList(splitP));
        if(rightCheck(paramList)){ //변환할게 없으면
            return p; //바로 리턴
        }else{
            answer = divideUV(p,"");
        }
        return answer;
    }
    // 문자가 들어오면 u, v 2개로 나누는 메소드
    private String divideUV(String p, String uStr){
        String divideStr = "";
        String[] splitP = p.split("");
        List<String> u = new ArrayList<>();
        List<String> v = new ArrayList<>();
        int index = 0;
        int left = 0;
        int right = 0;
        for (int i = 0; i < splitP.length; i++) {
            if (splitP[i].equals("(")) {
                left++;
            } else {
                right++;
            }
            u.add(splitP[i]);
            //계속 담다가 균형잡히면 그만
            if (left == right) {
                //그만 둔 시점의 인덱스 기억
                index = left + right;
                break;
            }
        }
        for (int i = index; i < splitP.length; i++) {
            v.add(splitP[i]);
        }

        if(rightCheck(u) && !rightCheck(v)){
            StringBuilder sbUCheck = listToString(u);
            System.out.println(sbUCheck.toString());
            StringBuilder sb = listToString(v);
            //divideStr = divideUV(sbU.toString() + sb.toString());
            divideStr = divideUV(sb.toString(), sbUCheck.toString());
        }else if(!rightCheck(u) && rightCheck(v)){
            //StringBuilder sbU = listToString(u);
            divideStr = uStr + addGualho(u,v);
        }

        return divideStr;
    }
    private StringBuilder listToString(List<String> v) {
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<v.size(); i++){
            if (v.get(i).equals("")) continue;
            sb.append(v.get(i));
        }
        return sb;
    }
    private String addGualho(List<String> u, List<String> v) {
        String addStr = "";
        StringBuilder sbCheck = listToString(u);
        StringBuilder sbV = listToString(v);
        StringBuilder sbRemove = new StringBuilder();
        //빈 문자열에 붙인다는게 그냥 아예 별개의 문자인가?
        String newStr = "("+sbV.toString()+")";
        /*u.add(0, "(");
        u.add(u.size(), ")");
        u.add(u.size()/2, sbV.toString());*/
        StringBuilder sbU = listToString(u);
        // ())()(() -> ()()()
        // (()()) -> ()(())()

        for(int i=1; i<sbU.toString().length()-1; i++){
            if(sbU.charAt(i)=='('){
                sbRemove.append(")");
            }else if(sbU.charAt(i)==')'){
                sbRemove.append("(");
            }

        }
        addStr = newStr + sbRemove.toString();
        return addStr;

    }
    // 올바른지 괄호인지 판단하는 메소드
    private boolean rightCheck(List<String> p) {
        Stack<String > stack = new Stack<>();
        for(int i=0; i<p.size(); i++){
            if(p.get(i).equals("(")){
                stack.add(p.get(i));
            }else{
                if(stack.isEmpty()){
                    continue;
                }
                stack.pop();
            }
        }
        if(stack.size() == 0){
            return true;
        }
        return false;
    }
    //
    @Test
    public void 괄호체크() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = ")(";
        String result = "()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
    @Test
    public void 괄호체크2() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = "(()())()";
        String result = "(()())()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
    @Test
    public void 괄호체크3() throws Exception{
        //given
        TransGualho t = new TransGualho();
        String p = "()))((()";
        String result = "()(())()";
        //when
        //then
        Assert.assertEquals(t.solution(p), result);
    }
}