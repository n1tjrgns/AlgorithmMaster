package remindprogrammers.hash;


import java.util.*;

public class BestAlbum {
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> maxPlayGenre = new HashMap<>(); //가장 많이 재생된 장르
        //장르별 재생된 노래횟수, 인덱스
        Map<String, Map<Integer,Integer>> genreCountIndex = new HashMap<>();
        Map<Integer,Integer> countPlayIndex = new HashMap<>(); //노래횟수, 인덱스

        for(int i=0; i<genres.length; i++){
            if(maxPlayGenre.get(genres[i]) == null){
                maxPlayGenre.put(genres[i], plays[i]);
            }else{
                maxPlayGenre.put(genres[i], maxPlayGenre.get(genres[i]) + plays[i]);
            }


            if(genreCountIndex.containsKey(genres[i])){
                countPlayIndex = genreCountIndex.get(genres[i]);
            }else{
                countPlayIndex = new HashMap<>();
            }

            countPlayIndex.put(i, plays[i]);
            genreCountIndex.put(genres[i], countPlayIndex);
        }

        /*List<Map.Entry<String, Integer>> sortGenre = new ArrayList<>(maxPlayGenre.entrySet());
        Collections.sort(sortGenre, new Comparator<Map.Entry<String, Integer>>() {
            @Override
            public int compare(Map.Entry<String, Integer> o1, Map.Entry<String, Integer> o2) {
                return o2.getValue().compareTo(o1.getValue());
            }
        });*/
        List<String> sortGenre = new ArrayList<>(maxPlayGenre.keySet());
        Collections.sort(sortGenre, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return maxPlayGenre.get(o2).compareTo(maxPlayGenre.get(o1));
            }
        });

        List<Integer> temp = new ArrayList<>();
        for(String key : sortGenre){
            List<Map.Entry<Integer,Integer>> sortGenreCountIndex = new ArrayList<>(genreCountIndex.get(key).entrySet());
            Collections.sort(sortGenreCountIndex, new Comparator<Map.Entry<Integer, Integer>>() {
                @Override
                public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
                    if (o1.getValue() == o2.getValue()){
                        return o1.getKey().compareTo(o2.getKey());
                    }else{
                        return o2.getValue().compareTo(o1.getValue());
                    }
                }
            });


            int index = 0;
            for(Map.Entry<Integer,Integer> map : sortGenreCountIndex){
                if(index < 2){
                    temp.add(map.getKey());
                    index++;
                }
            }
        }

        int[] result = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
            result[i] = temp.get(i);
        }
        return result;
    }

    public static void main(String[] args) {
        BestAlbum b = new BestAlbum();
        System.out.println(Arrays.toString(b.solution(new String[]{"classic","pop","classic","classic","pop"},new int[]{500,600,150,800,2500})));
    }
}


/*public int[] solution(String[] genres, int[] plays) {
        int[] answer = {};
        Map<String,Integer> topPlay = new HashMap<>();
        Map<String,Map<Integer,Integer>> firstSong = new HashMap<>();
        Map<Integer,Integer> countList = null;
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

            if(firstSong.containsKey(genres[i])){
                countList = firstSong.get(genres[i]);
            }else{
                countList = new HashMap<>();
            }
            //Map<Integer,Integer> countList = firstSong.containsKey(genres[i]) ? firstSong.get(genres[i]) : new HashMap<>();

            countList.put(i,plays[i]);
            firstSong.put(genres[i],countList);
        }

        //System.out.println(topPlay);

        //리스트에 map의 키 값 담기
        /*List<String> topPlayKey = new ArrayList<>(topPlay.keySet());

        Collections.sort(topPlayKey, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                //내림차순, value 값으로 정렬
                return topPlay.get(o2).compareTo(topPlay.get(o1));
                //오름차순
                // return topPlay.get(o1).compareTo(topPlay.get(o2));
            }
        });*/

    //System.out.println("firstSong : " + firstSong);
    //키값을 정렬했으니 키 값 순서대로 그 안의 map을 정렬하면된다.
    /*List<Integer> temp = new ArrayList<>();
        for (String key : topPlay.keySet()) {
                //System.out.println("key : " + key);
            /*Map<Integer, Integer> tempMap   = new HashMap<>(firstSong.get(key));
            System.out.println("firstSong.get(key) : " + firstSong.get(key));
            System.out.println("firstSong.get(key) : " + firstSong.get(key).get(0));
            list.add(tempMap);*/
         //       List<Map.Entry<Integer, Integer>> list = new ArrayList<>(firstSong.get(key).entrySet());
        //System.out.println("list : " + list);

       /* Collections.sort(list, new Comparator<Map.Entry<Integer, Integer>>() {
@Override
public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
        if (o1.getValue() == o2.getValue()){
        return o1.getKey().compareTo(o2.getKey());
        }else{
        return o2.getValue().compareTo(o1.getValue());
        }
        }
        });
        Map<Integer,Integer> map = new HashMap<>();
        map.entrySet().toArray();
        //System.out.println("list : " + list);


        int index = 0;
        for (Map.Entry<Integer, Integer> entrys : list)
        {

        if(index < 2){
        int ekey = entrys.getKey();

        temp.add(ekey);
        index++;
        }
        }
        //System.out.println("temp : " + temp);
        }
        //System.out.println(temp.size());
        answer = new int[temp.size()];
        for(int i=0; i<temp.size(); i++){
        answer[i] = temp.get(i);
        }

        return answer;
        }*/