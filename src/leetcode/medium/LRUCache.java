package medium;

import java.util.HashMap;
import java.util.Map;

public class LRUCache {

    private Map<Integer, node> nodeMap;
    private int capacity;
    private node head;
    private node tail;

    private class node{
        private int key;
        private int value;
        private node prev;
        private node next;

        public node(int key, int value){
            this.key = key;
            this.value = value;
            this.next = null;
            this.prev = null;
        }
    }

    public LRUCache(int capacity){
        this.nodeMap = new HashMap<>();
        this.capacity = capacity;
        head = new node(0,0);
        tail = new node(0,0);
        head.next = tail;
        tail.prev = head;
    }

    public void put(int key, int value){
        node newNode = new node(key, value);
        if(nodeMap.containsKey(key)){
            node oldNode = nodeMap.get(key);
            remove(oldNode);
        }else{
            if(nodeMap.size() >= this.capacity){
                node delNode = tail.prev;
                remove(delNode);
            }
        }

        insertToHead(newNode);
    }

    public int get(int key){
        if(!nodeMap.containsKey(key)) return -1;

        node getNode = nodeMap.get(key);
        remove(getNode);
        insertToHead(getNode);
        return getNode.value;
    }

    private void remove(node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;

        nodeMap.remove(node.key);
    }

    private void insertToHead(node node) {
        this.head.next.prev = node;
        node.next = this.head.next;
        node.prev = this.head;
        this.head.next = node;

        nodeMap.put(node.key, node);
    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
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
