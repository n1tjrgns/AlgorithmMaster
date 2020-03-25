package leetcode.easy.Node;

import java.util.HashSet;
import java.util.Set;

public class IntersectionOfTwoLinkedLists_HashTable {

    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    //같은 값이 없으면 null 리턴

    //각각 가리키는 값이 같으면 그 값을 리턴

    //가리키는 값은 같았지만 정작 교차지점은 그 다음 같은 값인 경우, 그 다음 값을 리턴
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> nodeMap = new HashSet<>();

        ListNode pointerA = headA;

        //4 1 8 4 5
        while(pointerA != null){
            nodeMap.add(pointerA);
            pointerA = pointerA.next;
        }

        if(nodeMap.isEmpty()){
            return null;
        }

        //5 0 1 8 4 5
        ListNode pointerB = headB;
        while(pointerB != null){
            if(nodeMap.contains(pointerB)){
                return pointerB;
            }
            pointerB = pointerB.next;
        }

        return null;
    }
}
