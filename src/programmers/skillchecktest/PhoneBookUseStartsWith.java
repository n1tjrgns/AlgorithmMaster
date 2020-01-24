package programmers.skillchecktest;

import java.util.Arrays;

public class PhoneBookUseStartsWith {
        public boolean solution(String[] phone_book) {
            boolean answer = true;

            Arrays.sort(phone_book);

            for(int i=0; i<phone_book.length; i++){
                if(phone_book[i+1].startsWith(phone_book[i])){
                    return false;
                }
            }
            return answer;
        }
        public static void main(String[] args) {
            PhoneBookUseStartsWith p = new PhoneBookUseStartsWith();
            //String phone[] = {"119", "97674223", "1195524421"};
            String phone[] = {"1235","88","123"};
            System.out.println(p.solution(phone));
        }
}
