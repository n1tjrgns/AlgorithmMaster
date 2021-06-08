package inflearn.stringarray.sec2StringArray2;

import java.util.HashSet;
import java.util.Set;

public class UniqueEmailAddresses {
    //로컬네임과 도메인 네임은 비어있지 않음
    // @는 반드시 포함
    // .이 나오면 뒤의 문자를 이어붙임 , +가 나오면 뒤의 문자를 무시
    // 도메인네임의 경우 .이 나와도 해당 도메인이기 때문에 무시하면 안됨
    // 로컬 이름에 규칙을 적용한 후 set에 넣어서 set의 수를 카운트 하면 될듯
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String email : emails) {
            String[] strings = email.split("@");
            String[] strings1 = strings[0].split("\\+");
            set.add(strings1[0].replaceAll("\\.","") + "@" + strings[1]);
        }
        return set.size();
    }

    public static void main(String[] args) {
        UniqueEmailAddresses u = new UniqueEmailAddresses();
        System.out.println(u.numUniqueEmails(new String[]{"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"}));
    }
}
