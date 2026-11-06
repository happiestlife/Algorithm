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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode result = null, curResultNode = null;
        // list1, 2 둘 중 하나가 null이 될 때까지 지속적으로 각 노드의 숫자를 비교하여 진행
        while(list1 != null && list2 != null) {
            // 각 연결리스트의 노드를 가져와서 숫자 비교 후 낮은 값을 result에 넣기
            int val1 = list1.val, val2 = list2.val;

            boolean isList1Small = val1 <= val2;
            int selectedVal = isList1Small ? val1 : val2;

            // result가 null이면 result 및 curResultNode에 삽입
            if(result == null) {
                result = curResultNode = new ListNode(selectedVal);
            }
            // 아니라면 현재 노드의 next로 선택한 노드를 넣고, 현재 노드를 next로 변경
            else {
                curResultNode.next = new ListNode(selectedVal);
                curResultNode = curResultNode.next;
            }

            if(isList1Small) {
                list1 = list1.next;
            } else {
                list2 = list2.next;
            }
        }

        // list1, list2를 조회하여 남은 모든 노드를 result에 추가
        if(result == null) {
            result = list1 == null ? list2 : list1;
        } else {
            while(list1 != null) {
                curResultNode.next = new ListNode(list1.val);
                curResultNode = curResultNode.next;
                list1 = list1.next;
            }

            while(list2 != null) {
                curResultNode.next = new ListNode(list2.val);
                curResultNode = curResultNode.next;
                list2 = list2.next;
            }
        }
        
        return result;
    }
}