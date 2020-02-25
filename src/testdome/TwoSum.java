package testdome;

import java.util.HashMap;

/*리스트와 목표 합계를 통과했을 때, 사용된 시간과 관련하여 효율적으로 반환되는 함수를 작성한다.
두 개의 숫자 중 어느 두 개의 뚜렷한 0 기반 색인이 목표 합계와 같다.
두 숫자가 없으면 함수는 null로 반환해야 한다.

예를 들어 find TwoSum(새 int[] { 3, 1, 5, 7, 5, 9 }}, 10)은 두 가지 요소를 포함하는
단일 치수 배열을 반환해야 하며 다음 두 가지 지수 쌍 중 하나를 포함해야 한다.

3 + 7 = 10으로 0 및 3(또는 3 및 0)
1과 5(또는 5와 1)는 1 + 9 = 10
5 + 5 = 10으로 2와 4(또는 4와 2)*/
public class TwoSum {
    public static int[] findTwoSum(int[] list, int sum) {
        //TODO 일반 2중 반복문으로 풀었더니 시간 초과가 발생
        // HashMap을 사용해야함
        //
        /*for(int i=0; i<list.length-1; i++){
            for(int j=i+1; j<list.length; j++){
                if(list[i]+list[j] == sum){
                    return new int[]{i,j};
                }
            }
        }*/
        HashMap<Integer, Integer> map = new HashMap<>();
        //3, 1, 5, 7, 5, 9
        //와 이걸 어떻게 생각하지
        System.out.println(map);
        for(int i=0; i<list.length; i++){
            int find = sum - list[i];
            if(map.get(find) != null){
                return new int[]{i, map.get(find)};
            }
            map.put(list[i], i);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = findTwoSum(new int[] { 3, 1, 5, 7, 5, 9 }, 10);
        if(indices != null) {
            System.out.println(indices[0] + " " + indices[1]);
        }
    }
}