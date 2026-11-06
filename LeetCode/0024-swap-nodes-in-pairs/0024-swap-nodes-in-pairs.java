/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode swapPairs(ListNode head) {
        int index = 0;
        ListNode result = null, prevNode = null;
        while(head != null) {
            index++;
             
            // 짝수번째라면 스킵
            if(index % 2 == 0) {
                prevNode = head;
                head = head.next;
                continue;
            }
            // 홀수번째인데 다음 노드가 없다면 종료
            else if(head.next == null) break;

            ListNode curNode = head;
            ListNode nextNode = curNode.next;

            // 1. 이전노드 -> 다음노드 가리키도록 수정
            // 이전노드가 없다면 다음노드가 result가 됨
            if(prevNode == null) {
                result = prevNode = nextNode;
            } else {
                prevNode.next = nextNode;
            }


            // 2. 다음노드 -> 현재 노드를 가리키도록 수정
            curNode.next = nextNode.next;
            nextNode.next = curNode;

            head = nextNode.next;
        }

        if(result == null && head != null) {
            result = head;
        }

        return result;
    }
}