package remindprogrammers;

public class TakeAGroupPicture {

    static char[] line = {'A','C','F','J','M','N','R','T'};
    static char[] position;
    static boolean[] visited;
    static int ans;

    public int solution(int n, String[] data) {

        //네오는 프로도와 나란히, 라이언은 튜브와 3칸 이상
        //1번째 = 조건 제시
        //2번째 = 항상 ~
        //3번째 = 상대방
        //4번째 = =, <, >
        //5번째 = 0 이상 6 이하 문자 (두 프렌즈 사이의 간격을 의미함)

        //1, 3번 누구와 누구 사이의 거리가 5번째만큼

        //R A C F T J M N
        //모든 경우를 나열하는 경우의 수 - 제약조건에 걸리는 경우의 수

        //완전 탐색 문제라, 두 경우를 따로 생각하면 안됨.
        //모든 경우의 수를 찾아보면서 매 경우마다 제약조건에 통과하는지 검사한 후 ++ 해줘야하는 문제
        //순열 + DFS 합쳐진 문제

        position = new char[8];
        visited = new boolean[8];
        ans = 0;

        perm(0, n, data);

        return ans;
    }

    private void perm(int idx, int n, String[] data) {
        if (idx == 8){
            if (isPossible(n, data)){ //조건 만족하는지 판별
                 ans++;
            }
            return;
        }

        //for문 돌면서 position에 line 값 채워넣고, visited로 방문 판별
        for (int i = 0; i < 8; i++) {
            if (!visited[i]){
                visited[i] = true;
                position[idx] = line[i];
                perm(idx+1, n, data);
                visited[i] = false;
            }
        }
    }

    private boolean isPossible(int n, String[] data) {
        for (int i = 0; i < n; i++) {
            char[] arr = data[i].toCharArray();
            int from=0, to=0, gap=0;
            int cond = arr[4] - '0';

            //앞, 뒷 부분 지정하기
            for(int j=0; j<8; j++){
                if (position[j] == arr[0]){
                    from = j;
                }if (position[j] == arr[2]){
                    to = j;
                }
            }

            gap = Math.abs(from - to) -1;
            //아닌 경우 걸러내기
            switch (arr[3]) {
                case '=':
                    if (gap != cond) return false;
                    break;

                case '<':
                    if (gap >= cond) return false;
                    break;

                case '>':
                    if (gap <= cond) return false;
                    break;
            }

        }
        return true;
    }

    public static void main(String[] args) {
        TakeAGroupPicture t= new TakeAGroupPicture();
        System.out.println(t.solution(2, new String[]{"N~F=0", "R~T>2"}));
    }
}
