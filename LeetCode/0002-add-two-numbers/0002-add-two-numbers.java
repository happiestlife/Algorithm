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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return calc(l1, l2, false);
    }

    public ListNode calc(ListNode l1, ListNode l2, boolean addOne) {
        if(l1 == null && l2 == null) {
            if (addOne) {
                return new ListNode(1, null);
            }
            else {
                return null;
            }
        }

        int l1Num = 0, l2Num = 0;
        ListNode nextL1Node = null, nextL2Node = null;
        if(l1 != null) {
            l1Num = l1.val;
            nextL1Node = l1.next;
        }
        if(l2 != null) {
            l2Num = l2.val;
            nextL2Node = l2.next;
        }
        int plusOne = addOne ? 1 : 0;

        int rawCurNum = l1Num + l2Num + plusOne;
        int curNum = (rawCurNum) % 10;


        boolean isOver10 = (rawCurNum / 10) == 1;
        ListNode nextNode = calc(nextL1Node, nextL2Node, isOver10);
        return new ListNode(curNum, nextNode);
    }

}