package inflearn.stringarray.sec3LinkedList;

public class AddTwoNumbers {

    //Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
    //두 노드가 있는데, 역순으로 정수를 만들어서 더해서 나온 값을 다시 역순으로 출력
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode current = head;
        int num = 0;

        while (p != null || q != null){
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = num + x + y;

            num = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;

            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }

        if (num > 0){
            current.next = new ListNode(num);
        }

        return head.next;
    }
}