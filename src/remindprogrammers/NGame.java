package remindprogrammers;

public class NGame {
    public String solution(int n, int t, int m, int p) {

        //숫자는 0부터 1씩 증가
        //숫자를 진법 변환
        //10 넘어가면 진법에 맞게 변환
        //순서에 맞을때만 출력
        String answer = "";
        int len = t * m;

        StringBuffer transStr = new StringBuffer();


        for(int i=0; i<len; i++){
            StringBuffer convertStr = convert(i, n);
            transStr.append(convertStr.toString());
        }

        StringBuffer result = new StringBuffer();

        int cnt = 0;
        for(int i=0; i<transStr.length(); i++){
            // 1 0 1 0
            // 1 1 1 1 1 1 1 1 1

            if(((i+1) % m) == (p%m)) {
                if (t == cnt) break;
                result.append(transStr.charAt(i));
                cnt++;

            }
        }

        return result.toString();
    }

    // 숫자, 진법
    private StringBuffer convert(int i, int n) {
        StringBuffer sb = new StringBuffer();
        if (i==0){
            sb.append(0);
        }

        while( i != 0){
            int nmg = i%n;

            if (nmg >= 10){
                int temp = 'A' + (nmg - 10);
                sb.append((char)temp);
            }else{
                sb.append(nmg);
            }
            i=i/n;
        }

        return sb.reverse();
    }


    public static void main(String[] args) {
        NGame n = new NGame();
        System.out.println(n.solution(2,4,2,1));
        System.out.println(n.solution(16,16,2,1));
    }

    /*@Test
    public void 정답() {
        Assert.assertEquals("0111", solution(2, 4, 2, 1));
        Assert.assertEquals("02468ACE11111111", solution(16, 16, 2, 1));

    }*/
}
