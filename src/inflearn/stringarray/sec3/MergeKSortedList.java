package inflearn.stringarray.sec3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
}
