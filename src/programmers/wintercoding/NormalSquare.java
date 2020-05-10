package programmers.wintercoding;

public class NormalSquare {
    // 숫자는 1억까지
    public long solution(long w, long h) {
        if(w == 0 || h == 0 ){
            return 0;
        }

        //반복 되는 하나의 패턴의 넓이 = w + h - 1
       long gcd = gcd(w, h);

        return (w * h) - (w + h - gcd);
    }

    private long gcd(long w, long h) {
        if(h == 0){
            return w;
        }else{
            return gcd(h, w%h);
        }
    }
        public static void main(String[] args) {
            NormalSquare n = new NormalSquare();

        System.out.println(n.solution(8, 12));
    }
}
