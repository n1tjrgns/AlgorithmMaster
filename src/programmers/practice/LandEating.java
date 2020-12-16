package programmers.practice;

import java.util.Arrays;

/*땅따먹기
문제 설명
땅따먹기 게임을 하려고 합니다. 땅따먹기 게임의 땅(land)은 총 N행 4열로 이루어져 있고,
모든 칸에는 점수가 쓰여 있습니다. 1행부터 땅을 밟으며 한 행씩 내려올 때,
각 행의 4칸 중 한 칸만 밟으면서 내려와야 합니다. 단, 땅따먹기 게임에는 한 행씩 내려올 때,
같은 열을 연속해서 밟을 수 없는 특수 규칙이 있습니다.

예를 들면,

| 1 | 2 | 3 | 5 |

| 5 | 6 | 7 | 8 |

| 4 | 3 | 2 | 1 |

로 땅이 주어졌다면, 1행에서 네번째 칸 (5)를 밟았으면, 2행의 네번째 칸 (8)은 밟을 수 없습니다.

마지막 행까지 모두 내려왔을 때, 얻을 수 있는 점수의 최대값을 return하는 solution 함수를 완성해 주세요. 위 예의 경우, 1행의 네번째 칸 (5), 2행의 세번째 칸 (7), 3행의 첫번째 칸 (4) 땅을 밟아 16점이 최고점이 되므로 16을 return 하면 됩니다.

제한사항
행의 개수 N : 100,000 이하의 자연수
열의 개수는 4개이고, 땅(land)은 2차원 배열로 주어집니다.
점수 : 100 이하의 자연수
입출력 예
land	answer
[[1,2,3,5],[5,6,7,8],[4,3,2,1]]	16
*/
public class LandEating {
    public static void main(String[] args) {
        LandEating l = new LandEating();
        System.out.println(l.solution(new int[][]{{1,2,3,5},{5,6,7,8},{4,3,2,1}}));
    }

    // N행 x 4열로된 땅이 있고, 연속되는 열을 내려갈 수 없을 때 얻을 수 있는 점수의 최대값값
    // 1행에서 가장 큰수
    // 그 다음 행에서 가장 큰수, 단 열이 같을 경우 그 다음으로 큰수
    // 위 과정 반복

    /*
    * | 1 | 2 | 3 | 5 |
      | 5 | 6 | 7 | 8 |
      | 4 | 3 | 2 | 1 |
    *
    * arr[0][0] -> 1,1 / 2,1 / 3,1 -> 7 / 8 / 9
    * arr[1][0] -> 0,1 / 2,1 / 3,1 -> 7 / 9 / 10
    * arr[2][0] -> 0,1 / 1,1 / 3,1 -> 8 / 9 / 11
    * arr[3][0] -> 0,1 / 1,1 / 2,1 -> 10 / 11 / 12 -> O
    *
    * arr[0][1] -> 1,2 / 2,2 / 3,2
    * arr[1][1] -> 0,2 / 2,2 / 3,2
    * arr[2][1] -> 0,2 / 1,2 / 3,2 -> 16 / 15 / 13 -> O
    * arr[3][1] -> 0,2 / 1,2 / 2,2
    *
    * arr[매번 1씩늘어남][한줄이 다 끝나야 1 늘어남]
    * 앞에랑 뒤에 더했을때 가장 큰 값만 뽑아야함.
    * */
    private int solution(int[][] land) {
        int answer = 0;
        System.out.println(land[1][0]);
        for(int i=1; i<land.length; i++){
            for(int j=0; j<4; j++){
                int temp = land[i][j];

                for(int k=0; k<4; k++){

                    if (j==k) continue;
                    else land[i][j] = Math.max(land[i][j], temp + land[i-1][k]);
                    System.out.println("i : "+i+" j :"+j+" k : "+k);
                }
            }
        }

        for (int i=0; i<4; i++){
            answer = Math.max(answer, land[land.length-1][i]);
        }

        return answer;
    }
}
