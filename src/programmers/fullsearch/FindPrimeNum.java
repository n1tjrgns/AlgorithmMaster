/*문제 설명
한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.

각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.

제한사항
numbers는 길이 1 이상 7 이하인 문자열입니다.
numbers는 0~9까지 숫자만으로 이루어져 있습니다.
013은 0, 1, 3 숫자가 적힌 종이 조각이 흩어져있다는 의미입니다.
입출력 예
numbers	return
17	3
011	2
입출력 예 설명
예제 #1
[1, 7]으로는 소수 [7, 17, 71]를 만들 수 있습니다.

예제 #2
[0, 1, 1]으로는 소수 [11, 101]를 만들 수 있습니다.

11과 011은 같은 숫자로 취급합니다.*/

package programmers.fullsearch;

import java.util.HashSet;

public class FindPrimeNum {
    //Todo 우선 String으로 만들 수 있는 모든 조합을 만들기
    //0으로 시작하는 경우는 0을 빼기
    public int solution(String numbers) {

        //문자 앞에 0이 붙어 같은 숫자를 방지하기위해 set으로 중복 제거
        HashSet<Integer> set = new HashSet<>();
        permutation("", numbers, set);

        int answer = 0;
        while(set.iterator().hasNext()){
            int next = set.iterator().next();
            set.remove(next);
            System.out.println("next : " + next);
            if(next == 2){
                // 2는 따로 카운트
                answer++;
            }
            if(next % 2 !=0 && isPrime(next)){
                answer++;
            }
        }

        return answer;
    }

    private boolean isPrime(int next) {
        if(next == 0 || next == 1){
            return false;
        }
        //에라토스테네스의 체
        //
        for(int i=3; i<=Math.sqrt(next); i=i+2){
            if(next%i == 0){
               return false;
            }
        }
        return true;
    }

    private void permutation(String prefix, String numbers, HashSet<Integer> set) {
        int len = numbers.length();

        System.out.println("prefix : "+ prefix);

        if(!prefix.equals(""))
            set.add(Integer.valueOf(prefix));

        System.out.println("set : "+ set);

        // 173
        // first 0: {" ", 173} -> {1, 73}, {7, 13}, {3, 17} => insert 0
        // sec 0: {1, 73} ->  {17, 3}, {13, 7} =>  insert 1 (1)
        //     1: {7, 13} ->  {71, 3}, {73, 1} =>  insert 1 (7)
        //     2: {3, 17} ->  {31, 7}, {37, 1} =>  insert 1 (3)
        // th 0: {17, 3} -> {173, ""} => insert 1 (17)
        //    1: {13, 7} -> {137, ""} => insert 1 (13)
        //    2: {71, 3} -> {713, ""} => insert 1 (71)
        //    3: {73, 1} -> {731, ""} => insert 1 (73)
        //    4: {31, 7} -> {317, ""} => insert 1 (31)
        //    5: {37, 1} -> {371, ""} => insert 1 (37)
        // fo 0: {173, ""} -> {173, ""} => insert 1 (173) return

        //173
        for(int i=0; i<len; i++){
            permutation(prefix + numbers.charAt(i), numbers.substring(0, i) + numbers.substring(i+1, len), set);
            /*System.out.println(" i : "+ i);
            System.out.println("prefix + numbers.charAt(i) : "+prefix + numbers.charAt(i));
            System.out.println("numbers.substring(0, i) : "+numbers.substring(0, i));
            System.out.println("numbers.substring(i+1, len) : "+numbers.substring(i+1, len));
            System.out.println("+++++++++ : " + numbers.substring(0, i) + numbers.substring(i+1, len));*/
        }
    }

    public static void main(String[] args) {
        FindPrimeNum f = new FindPrimeNum();
        String a = "173";
        System.out.println(f.solution(a));
    }


}


/*이 문제는 주어진 문자열에 적힌 숫자를 하나씩 자른 다음 그 숫자들을 조합했을 때 만들 수 있는 숫자의 모든 경우의 수를 구해야 하는데 숫자들을 조합하는 순서에 따라 다른 숫자가 만들어지므로 순열 알고리즘을 사용해야 한다.

순열 알고리즘을 통해 숫자의 조합을 만들어 가다가 조합을 완성하면 소수인지 검사한 후 소수라면 결과 값을 1씩 증가시켜 준다.

다만, 테스트 케이스 "011" 처럼 같은 숫자가 있는 경우 순열 알고리즘을 사용하더라도 순서상으로는 다른 조합이지만 중복된 숫자가 만들어질 수 있고 "01", "011" 처럼 숫자 앞에 "0" 이 붙은 경우 문자열을 숫자로 변환했을때 중복된 숫자가 만들어지기 때문에 검사한 숫자를 Set 으로 저장하여 중복된 숫자를 걸러주어야 한다.

숫자의 조합이 만들어질 때마다 중복을 검사하는 과정에서 Set 에 저장된 요소들과 비교연산을 하게 되므로 좀 더 효율적으로 하기 위해 ArrayList 대신 HashSet 을 사용했다.

소수 판별 알고리즘은 <프로그래밍 대회에서 배우는 알고리즘 문제 해결 전략> 책에 있는 알고리즘을 참고했는데 여기서 나오는 제곱근을 이용하는 방법은 종종 다른 알고리즘 풀이에도 사용할 수 있었다.

이 방법은 어떤 숫자 n 이 p * q 일때 p 와 q 중 하나는 항상 n 의 제곱근 이하의 값을 갖고 하나는 항상 제곱근 이상의 값을 갖는다는 성질을 이용한 것이다.

예를 들어 숫자 n 이 24 라고 할때 24의 제곱근은 4.xxxx 이므로 한 쪽은 항상 4.xxxx 이하의 값을 갖게 되고 한 쪽은 항상 4.xxxx 이상의 값을 갖게 되는 것이다.

24를 두 수의 곱으로 나타내보면 [ 1x24, 2x12, 3x8, 4x6 ], [ 6x4, 8x3, 12x2, 24x1 ] 으로 나타낼 수 있는데 왼쪽이 제곱근 이하의 값일땐 오른쪽이 항상 제곱근 이상의 값이고 반대의 경우에도 같은 성질을 갖는것을 확인할 수 있다.

이러한 성질을 이용하면 1과 자기 자신외에 다른 약수를 가지지 않는지 검사를 할 때 그 수의 제곱근까지만 검사를 하면 모든 약수를 검사할 수 있게 되어 연산을 크게 줄일 수 있게 된다.

 */