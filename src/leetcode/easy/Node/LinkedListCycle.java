package leetcode.easy.Node;

/*Given a linked list, determine if it has a cycle in it.

To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.



Example 1:

Input: head = [3,2,0,-4], pos = 1
Output: true
Explanation: There is a cycle in the linked list, where tail connects to the second node.*/
public class LinkedListCycle {
    // TODO 원형 링크드리스트가 순회가능한 구조인지 판별하는 문제
    //  pos가 -1이면 false
    //  pos는 링크드리스트가 맨 끝에 도달했을 때 사이클 돌 지점을 가리키는 index

    // refs #프로그래머스 Song
    //이런 문제를 Floyd's Cycle-Finding Algorithm 이라고 부른다.
    //리스트의 구조가 순환 형태인지 아닌지 알아내는 방법
    //시간 복잡도 O(n)
    //속도가 다른 두 개의 포인터를 루프에 진입시켜 진행 하다보면 순환 일 경우 결국 같은 노드를 가르킨다.
    class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public boolean hasCycle(ListNode head) {
        //유효성 검사
        if(head == null || head.next == null){
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;

        boolean loop = false;

        while(slow != null && fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                loop = true;
                break;
            }
        }
        return loop;
    }
}
