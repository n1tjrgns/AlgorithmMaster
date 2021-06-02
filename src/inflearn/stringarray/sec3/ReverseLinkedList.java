package inflearn.stringarray.sec3;
//https://leetcode.com/problems/reverse-linked-list/
//연결리스트 역순으로 출력하기
public class ReverseLinkedList {
    public class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    //바꾸는 원리
    /*
    * 현재의 next 값을 현재의 null 값으로 바꿔준다.
    * 1, next -> 1, null
    * 1, null의 값의 next를 다음 값으로 가져온다.
    * 2, next
    * 끝까지 반복
    * 3, next
    *
    * 바로 3,next부터 시작하는게 아니다. 거꾸로 시작하는거다.
    * */



    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null){
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
