package programmers.skillchecktest;

import java.util.Arrays;

public class PhoneBook {
    public boolean solution(String[] phone_book) {
        boolean answer = true;

        Arrays.sort(phone_book);


        for(int i=0; i<phone_book.length-1; i++){

            //번호가 앞에게 더 짧을때랑 길 때를 나눠서 해보자
            //startswith 함수를 사용하면 더 간단하게 사용가능함.
            if(phone_book[i].length() <= phone_book[i+1].length()){
                if(phone_book[i].equals(phone_book[i+1].substring(0,phone_book[i].length()))){
                    return false;
                }
            }else{
                if(phone_book[i+1].equals(phone_book[i].substring(0,phone_book[i+1].length()))){
                    return false;
                }
            }
        }

        return answer;
    }
    public static void main(String[] args) {
        PhoneBook p = new PhoneBook();
        //String phone[] = {"119", "97674223", "1195524421"};
        String phone[] = {"1235","88","123"};
        System.out.println(p.solution(phone));
    }
}
