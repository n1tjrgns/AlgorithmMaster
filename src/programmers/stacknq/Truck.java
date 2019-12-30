/*다리를 지나는 트럭
문제 설명
트럭 여러 대가 강을 가로지르는 일 차선 다리를 정해진 순으로 건너려 합니다.
모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 알아내야 합니다.
트럭은 1초에 1만큼 움직이며, 다리 길이는 bridge_length이고 다리는 무게 weight까지 견딥니다.
※ 트럭이 다리에 완전히 오르지 않은 경우, 이 트럭의 무게는 고려하지 않습니다.

예를 들어, 길이가 2이고 10kg 무게를 견디는 다리가 있습니다. 무게가 [7, 4, 5, 6]kg인 트럭이 순서대로 최단 시간 안에 다리를 건너려면 다음과 같이 건너야 합니다.

경과 시간	다리를 지난 트럭	다리를 건너는 트럭	대기 트럭
0	[]	[]	[7,4,5,6]
1~2	[]	[7]	[4,5,6]
3	[7]	[4]	[5,6]
4	[7]	[4,5]	[6]
5	[7,4]	[5]	[6]
6~7	[7,4,5]	[6]	[]
8	[7,4,5,6]	[]	[]
따라서, 모든 트럭이 다리를 지나려면 최소 8초가 걸립니다.

solution 함수의 매개변수로 다리 길이 bridge_length, 다리가 견딜 수 있는 무게 weight, 트럭별 무게 truck_weights가 주어집니다. 이때 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return 하도록 solution 함수를 완성하세요.

제한 조건
bridge_length는 1 이상 10,000 이하입니다.
weight는 1 이상 10,000 이하입니다.
truck_weights의 길이는 1 이상 10,000 이하입니다.
모든 트럭의 무게는 1 이상 weight 이하입니다.
입출력 예
bridge_length	weight	truck_weights	return
2	10	[7,4,5,6]	8
100	100	[10]	101
100	100	[10,10,10,10,10,10,10,10,10,10]	110*/
package programmers.stacknq;

import java.util.LinkedList;
import java.util.Queue;

public class Truck {
    //다리를 지나가는 트럭 무게의 합이 다리가 버티는 무게보다 작아야함
    // -> 인덱스 2개 만큼의 합이 다리 무게를 넘지 않아야함.

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;

        int bridge_weight = 0;
        Queue<Integer> truck_time = new LinkedList<>();
        int idx = 0;

        //{7, 4, 5, 6}
        while(idx < truck_weights.length) {
            answer++;

            int curTruck = truck_weights[idx];

            //무게계산
            if(bridge_weight + curTruck <= weight) {
                idx++;
                bridge_weight = bridge_weight + curTruck;

                //무게 계산을 이미 하고 들어오기 때문에 시간을 계산하기 위한 로직을 별개로 수행 가능
                truck_time.add(0);
            }

            //시간계산
            int queueSize = truck_time.size();

            //큐에 0을 넣어주고 큐에 들어온 크기 만큼 반복, 절대 다리 길이보다 커질 수는 없음
            for(int i = 0; i < queueSize; i++) {
                truck_time.add(truck_time.poll() + 1);
            }

            //다리 끝까지 다 도착했으면, 현재 다리 무게를 0으로 만들어주고, 큐에서 뺀다.
            if(truck_time.peek() == bridge_length) {
                bridge_weight = bridge_weight - truck_weights[idx - truck_time.size()];
                truck_time.poll();
            }

        }

        //마지막 트럭은 반복문을 더이상 타지 않지만 결국 건널 것이므로 다리 길이 만큼 ++
        answer += bridge_length;

        return answer;
    }

    public static void main(String[] args) {
        Truck t = new Truck();
        int bridge = 2;
        int weight = 10;
        int[] t_weight = {7, 4, 5, 6};
        System.out.println(t.solution(bridge, weight, t_weight));
    }
}
