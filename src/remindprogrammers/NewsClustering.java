package remindprogrammers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class NewsClustering {
    public int solution(String str1, String str2) {
        //자카드 유사도
        //1. 문자열을 2 글자씩 끊어서 집합의 원소로 만든다.
        //2. 원소에 공백, 숫자, 특수 문자가 있으면 그 글자 쌍을 버린다.
        //3. 대소문자는 무시한다.(같다고 본다)
        //4. 두 문자열의 교집합 갯수 / 합집합 갯수 * 65536 후 소수점 아래 버린다.

        str1 = str1.toUpperCase();
        str2 = str2.toUpperCase();
        List<String> list1 = new ArrayList<>();
        List<String> list2 = new ArrayList<>();

        for(int i=0; i<str1.length()-1; i++){
            char c1 = str1.charAt(i);
            char c2 = str1.charAt(i+1);

            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z' ){
                list1.add(c1+""+c2);
            }

        }

        for(int i=0; i<str2.length()-1; i++){
            char c1 = str2.charAt(i);
            char c2 = str2.charAt(i+1);

            if (c1 >= 'A' && c1 <= 'Z' && c2 >= 'A' && c2 <= 'Z' ){
                list2.add(c1+""+c2);
            }
        }

        List<String> all = new ArrayList<>();
        List<String> common = new ArrayList<>();

        Collections.sort(list1);
        Collections.sort(list2);

        for (String s1 : list1) {
            if(list2.contains(s1)){
                list2.remove(s1);
                common.add(s1);
            }
            all.add(s1);
        }

        all.addAll(list2);


        //이렇게 숫자로 계산해버리면 문자가 같은경우 인식이 안됨....
        //double sum = list1.size() + list2.size() - common;

        if (all.size() == 0){
            return 65536;
        }else{
            return (int) (((double)common.size()/(double)all.size() * 100/100.0) * 65536);
        }
    }



    public static void main(String[] args) {
        NewsClustering n = new NewsClustering();
        System.out.println(n.solution("FRANCE", "french"));
        System.out.println(n.solution("aa1+aa2", "AAAA12"));
        System.out.println(n.solution("aa1+aa2", "AAAA12"));
    }
}
