package leetcode.easy.Node;

public class IntersectionOfTwoLinkedLists_BruteForce {

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

        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while(pointerA != null){
            for(pointerB = headB; pointerB !=null; pointerB = pointerB.next){
                if (pointerA == pointerB) {
                    return pointerA;
                }
            }
            pointerA = pointerA.next;
        }
        return null;
    }
}
