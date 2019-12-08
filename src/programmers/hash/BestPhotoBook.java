/*베스트앨범
문제 설명
스트리밍 사이트에서 장르 별로 가장 많이 재생된 노래를 두 개씩 모아 베스트 앨범을 출시하려 합니다. 노래는 고유 번호로 구분하며, 노래를 수록하는 기준은 다음과 같습니다.

속한 노래가 많이 재생된 장르를 먼저 수록합니다.
장르 내에서 많이 재생된 노래를 먼저 수록합니다.
장르 내에서 재생 횟수가 같은 노래 중에서는 고유 번호가 낮은 노래를 먼저 수록합니다.
노래의 장르를 나타내는 문자열 배열 genres와 노래별 재생 횟수를 나타내는 정수 배열 plays가 주어질 때, 베스트 앨범에 들어갈 노래의 고유 번호를 순서대로 return 하도록 solution 함수를 완성하세요.

제한사항
genres[i]는 고유번호가 i인 노래의 장르입니다.
plays[i]는 고유번호가 i인 노래가 재생된 횟수입니다.
genres와 plays의 길이는 같으며, 이는 1 이상 10,000 이하입니다.
장르 종류는 100개 미만입니다.
장르에 속한 곡이 하나라면, 하나의 곡만 선택합니다.
모든 장르는 재생된 횟수가 다릅니다.
입출력 예
genres	plays	return
[classic, pop, classic, classic, pop]	[500, 600, 150, 800, 2500]	[4, 1, 3, 0]
입출력 예 설명
classic 장르는 1,450회 재생되었으며, classic 노래는 다음과 같습니다.

고유 번호 3: 800회 재생
고유 번호 0: 500회 재생
고유 번호 2: 150회 재생
pop 장르는 3,100회 재생되었으며, pop 노래는 다음과 같습니다.

고유 번호 4: 2,500회 재생
고유 번호 1: 600회 재생
따라서 pop 장르의 [4, 1]번 노래를 먼저, classic 장르의 [3, 0]번 노래를 그다음에 수록합니다.

※ 공지 - 2019년 2월 28일 테스트케이스가 추가되었습니다.*/

package programmers.hash;

import java.util.*;

public class BestPhotoBook {

    // 요구사항 정리
    // 1. 가장 많이 재생된 장르를 찾는다
    // 2. 같은 장르의 노래가 여러개 있으면 앞의 인덱스에 있는 노래가 먼저 재생된다.
    // 3. 먼저 선택된 장르의 인덱스, 그 인덱스에 해당하는 재생 횟수의 인덱스를 반환해야한다.
    public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String,Integer> topPlay = new HashMap<>();
        Map<String,Map<Integer,Integer>> firstSong = new HashMap<>();
        //Map<Integer,Integer> countList = new HashMap<>();

        int genLength = genres.length;

        for(int i=0; i<genLength; i++){
            //1번 요구사항을 구하기 위해, 같은 장르이면 +
            if(topPlay.get(genres[i]) == null){
                topPlay.put(genres[i], plays[i]);
            }else{
                topPlay.put(genres[i], topPlay.get(genres[i])+plays[i]);
            }
            //topPlay.put(genres[i], topPlay.containsKey(genres[i]) ? topPlay.get(genres[i])+plays[i] : plays[i]) ;

            Map<Integer,Integer> countList = firstSong.containsKey(genres[i]) ? firstSong.get(genres[i]) : new HashMap<>();
            countList.put(i,plays[i]);
            firstSong.put(genres[i],countList);
        }
        //HashMap을 TreeMap 생성자에 담으면 key 순서로 오름차순 정렬되어 Entry가 정렬된다.
        TreeMap<String,Integer> sortTopPlay = new TreeMap<>(topPlay);
        TreeMap<String,Map<Integer,Integer>> sortFinalMap = new TreeMap<>(firstSong);

        String lastKey = sortTopPlay.firstKey();
        String firstKey = sortTopPlay.lastKey();

        List<Integer> firstPlayList = new ArrayList<>(sortFinalMap.get(firstKey).keySet());
        List<Integer> lastPlayList = new ArrayList<>(sortFinalMap.get(lastKey).keySet());

        answer = new int[]{firstPlayList.get(firstPlayList.size() - 1), firstPlayList.get(0), lastPlayList.get(lastPlayList.size() - 1), lastPlayList.get(0)};

        return answer;
    }

    public static void main(String[] args) {
        BestPhotoBook b = new BestPhotoBook();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        //classic : 1450 pop : 3100
        System.out.println(b.solution(genres, plays));

    }
}
