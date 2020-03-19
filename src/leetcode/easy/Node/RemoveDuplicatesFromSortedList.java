package leetcode.easy.Node;
/*Given a sorted linked list, delete all duplicates such that each element appear only once.

Example 1:

Input: 1->1->2
Output: 1->2
Example 2:

Input: 1->1->2->3->3
Output: 1->2->3*/
public class RemoveDuplicatesFromSortedList {
    // # Refs leetcode MergeTowSortedLists 문제와 비슷
     public class ListNode {
        int val;
        ListNode next;
        ListNode(int x) { val = x; }
     }
    class Solution {
        public ListNode deleteDuplicates(ListNode head) {
            ListNode current = head;

            //현재 head가 null이 아닐동안
            while(current != null && current.next != null){
                //현재값과 다음 값이 같으면 ex) 1->1
                if(current.val == current.next.val){
                    //다음값에 다다음 값을 넣는다
                    //1->1
                    //1->1->2
                    //1->2
                    current.next = current.next.next;
                }else{
                    //현재값과 다음값이 같지않으면 그 값을 바로 head로 저장한다.
                    current = current.next;
                }
            }
            //현재 값이 null이면 바로 return
            return head;

        }
    }
}
