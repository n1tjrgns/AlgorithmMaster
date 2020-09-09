package medium;

import java.util.LinkedHashMap;
import java.util.Map;

public class LRUCacheLinkedHashMap {
    Map<Integer, Integer> map = new LinkedHashMap<>();
    int size=0;
    public LRUCacheLinkedHashMap(int capacity) {
        this.size = capacity;
    }

    public int get(int key) {
        if(map.containsKey(key)){
            int value = map.remove(key);
            map.put(key, value);
        }
        System.out.println(map.get(key));
        return -1;
    }

    public void put(int key, int value) {

        if(map.containsKey(key)){
            map.remove(key);
        }else if (map.size() + 1 > size){
            System.out.println("iterator : " + map.keySet().iterator().next());
            map.remove(map.keySet().iterator().next());
        }

        map.put(key,value);
        System.out.println(map);
    }

    public static void main(String[] args) {
        LRUCacheLinkedHashMap cache = new LRUCacheLinkedHashMap(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4
    }
}
