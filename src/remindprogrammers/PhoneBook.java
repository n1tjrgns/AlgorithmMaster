package remindprogrammers;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        Arrays.sort(phone_book);

        for(int i=1; i<phone_book.length; i++){
            if (phone_book[i].startsWith(phone_book[0])){
                return false;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        PhoneBook p = new PhoneBook();
        System.out.println(p.solution(new String[]{"119","97674223","1195524421"}));
    }
}
