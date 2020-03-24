package leetcode.easy.Node;

//https://leetcode.com/problems/intersection-of-two-linked-lists/submissions/
public class IntersectionOfTwoLinkedLists_TwoPointers {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        //굳이 이걸 한 번 더 담았어야해?
        //변수 담아놓는 느낌인가 ex) int a = arr.length;
        ListNode pointerA = headA;
        ListNode pointerB = headB;

        while( pointerA != pointerB){ //같으면 정답이니까 다를 동안만
            if(pointerA != null){
                pointerA = pointerA.next;
            }else{
                //여기서 같지 않으면 왜 headB로 이동할까?
                pointerA = headB;
            }

            if(pointerB != null){
                pointerB = pointerB.next;
            }else{
                pointerB = headA;
            }
        }

        return pointerA;
    }
}
