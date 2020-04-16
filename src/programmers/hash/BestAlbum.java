package programmers.hash;

import java.util.*;

public class BestAlbum {
    // 노래가 가장 많이 재생된 장르를 먼저 수록
    // 장르 내에서 많이 재생된 노래를 먼저 수록
    // 장르 내에서 재생횟수가 같은 노래는 고유 번호가 낮은 노래를 먼저 수록

    //Map<String<List<Integer,Integer> -> classic, {0 ,500} 이런 형태로 담아야 할 듯
    //장르별로 최대로 재생된 노래를 key 값으로 해야하니까 최대로 재생된 노래를 구해야하고
    // 장르별 재생횟수를 내림 차순으로 저장해서, 그거에 대한 인덱스를 반환해야함. (같으면 인덱스 작은거부터)
    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Map<String, Map<Integer,Integer>> album = new HashMap<>(); //전체 담을 map
        Map<String,Integer> sumPlays = new HashMap<>(); //최고 재생 목록 map
        Map<Integer, Integer> indexPlay = null; //인덱스별 재생 횟수 map

        for(int i=0; i<genres.length; i++){

            //장르별 재생 횟수 계산
            if(sumPlays.get(genres[i]) == null){
                sumPlays.put(genres[i], plays[i]);
            }else{
                int value = sumPlays.get(genres[i]) + plays[i];
                sumPlays.put(genres[i], value);
            }

            if(album.containsKey(genres[i])){
                indexPlay = album.get(genres[i]);
            }else{
                indexPlay = new HashMap<>();
            }
            indexPlay.put(i, plays[i]);
            album.put(genres[i],indexPlay);
        }

        System.out.println(album);
        System.out.println(sumPlays);
        System.out.println(indexPlay);

        List<String> sortGenre = new ArrayList<>(sumPlays.keySet());
        System.out.println("정렬 전 장르 : " + sortGenre);

        Collections.sort(sortGenre, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                System.out.println("o1 : "+o1 + "  o2 : "+ o2);
                return sumPlays.get(o2).compareTo(sumPlays.get(o1));
            }
        });

        System.out.println("정렬 후 장르 : " + sortGenre);


        //같은 장르 내에서 재생횟수가 같은 노래는 인덱스가 낮은 노래부터 나오도록 정렬
        List<Integer> temp = new ArrayList<>();

        for(String key : sortGenre){
            List<Map.Entry<Integer,Integer>> list = new ArrayList<>(album.get(key).entrySet());
            System.out.println("정렬 전 list : " + list);
            Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    System.out.println("index o1 : "+o1 + "  o2 : "+ o2);
                    if(o1.getValue() == o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
            });

            System.out.println("정렬 후 list : " + list);

            int index = 0;

            //2개씩만 넣으면 되니까
            for(Map.Entry<Integer, Integer> entrys : list){

                if(index < 2){
                    System.out.println("엔트리 : "+ entrys.getKey());
                    int currentKey = entrys.getKey();

                    temp.add(currentKey);
                    index++;
                }
            }

        }

        answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            answer[i] = temp.get(i);
        }

        return answer;
    }

    public static void main(String[] args) {
        BestAlbum b = new BestAlbum();
        String[] genres = {"classic", "pop", "classic", "classic", "pop"};
        int[] plays = {500, 600, 150, 800, 2500};
        System.out.println(Arrays.toString(b.solution(genres, plays)));
    }
}
