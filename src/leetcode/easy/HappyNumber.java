package leetcode.easy;
//https://leetcode.com/problems/happy-number/
public class HappyNumber {

    public boolean isHappy(int n) {
        int slow, fast;
        slow = fast = n;
        do{
            slow = calculateDigit(slow);
            fast = calculateDigit(fast);
            fast = calculateDigit(fast);
            if(fast == 1) return true;
        }while(slow != fast);
        return false;
    }

    private int calculateDigit(int n) {
        int sum = 0 , tmp;
        while (n!=0){
            tmp = n% 10;
            sum = sum + tmp * tmp;
            n /= 10;
        }

        return sum;
    }

    public static void main(String[] args) {
        HappyNumber h = new HappyNumber();
        System.out.println(h.isHappy(19));;
    }
}
