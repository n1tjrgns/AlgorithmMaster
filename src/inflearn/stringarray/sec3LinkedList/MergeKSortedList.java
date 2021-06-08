package inflearn.stringarray.sec3LinkedList;

import java.util.*;

//https://leetcode.com/problems/merge-k-sorted-lists/solution/
public class MergeKSortedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //연결리스트를 오름차순 정렬하기.
    public ListNode mergeKLists(ListNode[] lists) {
        //1. brute force -> 전부 list에 담아서 오름차순 정렬 후 다시 노드에 담기
        List<Integer> list = new ArrayList<>();

        for (ListNode listNode : lists) {
            while (listNode != null){
                list.add(listNode.val);
                listNode = listNode.next;
            }
        }

        Collections.sort(list);

        ListNode head = new ListNode(0);
        ListNode h = head;

        for (Integer integer : list) {
            ListNode t = new ListNode(integer);
            h.next = t;
            h = h.next;
        }
        h.next = null;
        return head.next;
    }

    //우선순위 큐를 사용한 merge
    Comparator<ListNode> comp = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode o1, ListNode o2) {
            return o1.val - o2.val; //오름 차순 정렬
        }
    };
    public ListNode mergeKListsPriorityQue(ListNode[] lists) {
        ListNode newNode = new ListNode(0); //더미 데이터를 만들어놓고 해당 노드 .next에 데이터를 연결 하는 방식
        ListNode p = newNode;

        PriorityQueue<ListNode> que = new PriorityQueue<>(comp);
        for (ListNode list : lists) {
            if (list != null){
                que.add(list);
            }
        }

        while (!que.isEmpty()){
            ListNode poll = que.poll();
            p.next = poll;
            p = p.next;
            if (poll.next != null){
                que.add(poll.next);
            }
        }

        return newNode.next;
    }
}
