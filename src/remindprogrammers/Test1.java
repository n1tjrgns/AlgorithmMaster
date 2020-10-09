package remindprogrammers;

public class Test1 {
    public String solution(int n, int t, int m, int p) {
        StringBuilder allNumber = new StringBuilder();
        StringBuilder result= new StringBuilder();
        int len = t*m;

        for(int i=0; i<len; i++){
            StringBuilder sb = convert(i, n);
            System.out.println(sb.toString());
            allNumber.append(sb.toString());
        }
        System.out.println("answer = " + allNumber.toString());

        int count = 0;
        // m== 2
        // i%m = 0 1 0 1 0 1 0 1
        //       1   1   1   1

        //m == 3
        //i%m == 0 1 2 0 1 2 0 1 2
        //       1     1     1

        //m == 4
        //i%m == 0 1 2 3 0 1 2 3 0 1 2 3
        //       1       1       1
        for(int i=0; i<allNumber.length(); i++){
            if((i%m) == (m%p)){
                result.append(allNumber.charAt(i));
                count++;
                if (count == t) break;
            }
        }

        return result.toString();
    }

    //진수 변환
    private StringBuilder convert(int i, int n) {
        StringBuilder sb = new StringBuilder();
        if (i == 0){
            sb.append(0);
        }
        while (i != 0){
            int mod = i%n;
            if (mod >= 10){
                int temp = 'A' + (mod-10);
                sb.append((char)temp);
            }else{
                sb.append(mod);
            }
            i=i/n;
        }

        return sb.reverse();
    }

    public static void main(String[] args) {
        Test1 t = new Test1();
        System.out.println(t.solution(2,4,2,1));
        System.out.println(t.solution(16,16,2,1));
        System.out.println(t.solution(16,16,2,2));
    }
}
