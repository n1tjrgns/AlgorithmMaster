/*주식가격
문제 설명
초 단위로 기록된 주식가격이 담긴 배열 prices가 매개변수로 주어질 때, 가격이 떨어지지 않은 기간은 몇 초인지를 return 하도록 solution 함수를 완성하세요.

제한사항
prices의 각 가격은 1 이상 10,000 이하인 자연수입니다.
prices의 길이는 2 이상 100,000 이하입니다.
입출력 예
prices	return
[1, 2, 3, 2, 3]	[4, 3, 1, 1, 0]
입출력 예 설명
1초 시점의 ₩1은 끝까지 가격이 떨어지지 않았습니다.
2초 시점의 ₩2은 끝까지 가격이 떨어지지 않았습니다.
3초 시점의 ₩3은 1초뒤에 가격이 떨어집니다. 따라서 1초간 가격이 떨어지지 않은 것으로 봅니다.
4초 시점의 ₩2은 1초간 가격이 떨어지지 않았습니다.
5초 시점의 ₩3은 0초간 가격이 떨어지지 않았습니다.*/
package programmers.stacknq;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.ListIterator;

public class StockPrice {
    public int[] solution(int[] prices) {

        int[] answer = new int[prices.length];

        LinkedList<Integer> stockQue = new LinkedList<>();
        ArrayList<Integer> result = new ArrayList<>();

        for(int p : prices){
            stockQue.add(p);
        }



        int stockSize = stockQue.size();



        while(!stockQue.isEmpty()){
            int current = stockQue.poll();
            //System.out.println("current : "+ current);

            int cnt=0;
            ListIterator it = stockQue.listIterator();
            while(it.hasNext()){
                int next = (int) it.next();
                //System.out.println("next : " + next);

                //그런데 바로 뒤의 인덱스가 조건에 맞지 않을 경우 1이 아닌 0이 나와버리네
                //3 다음에 2가 나온 경우 1초만에 떨어졌으니 이 경우를 1초라고 보는듯
                if(current <= next){
                    //이 경우를 추가 해야함
                    cnt++;
                }else{
                    cnt++;
                    break;
                }
            }

            result.add(cnt);
            //System.out.println(result);

        }

        //배열은 항상 초기화를 해놓아야 에러가 안난다.
        for(int i=0; i<result.size(); i++){
            answer[i] = result.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        StockPrice s = new StockPrice();
        int[] pri = {1,2,3,2,3};
        System.out.println((Arrays.toString(s.solution(pri))));
    }
}


/*
        처음에는 큐 안에서 나머지 비교해야 할 값들을 어떻게 비교해야할지 감이 오지 않아서 리스트로 작성했음.
        하지만 for문 안에서 list의 remove라던지 사이즈의 크기를 줄이는 행위를 하면 인덱스가 잘 안맞아서 원하는 값이 잘 안나온다.

        그걸 잘 우회해서 크기의 값이 유동적으로 바뀌어야하는게 스택/큐 문제의 핵심이다.

        그래서 결국 다시 큐를 사용해서 풀기로 결정.

        while문 안에서 for문을 돌려서 current와 stockQue.get(1)을 비교해서 답을 구해보려했으나
        stockQue.get(1) 값이 제대로 나오지 않았다.
        왜 ??

        구글링을 하다가 생활코딩 사이트를 통해서 알게 되었다.
        linkedlist는 검색에 효율적이지 않다. get을 호출할 때마다 내부적으로 반복문이 실행된된다.

        이런 경우Iterator를 사용하는 것이 좋다. Iterator는 내부적으로 반복 처리된 노드가 무엇인지에 대한 정보를 유지하기 때문입니다.

         그래서 linkedlist의 get을 호출할 때마다 내부적으로 반복이 실행되어 원하지 않는 값이 나올 수 있다.
        그래서 내가 stockQue.get(index)를 하였을 때 원하지 않는 값이 나왔다.



        while(!nums.isEmpty()){
            int num=nums.poll();
            int cnt=0;
                for(int index=totalSize-nums.size();index<totalSize; index++){
                    if(num>stockQue.get(index)){
                        break;
                    }
                    //이하 생략
                }
        }*/
