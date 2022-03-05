package Day12_doublePointer2;

public class Solution {

    /**
     * 输入两个递增排序的链表，合并这两个链表并使新链表中的节点仍然是递增排序的。
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(-1);
        ListNode dummy = new ListNode(-1);
        head = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
            dummy = dummy.next;
        }
        if (l1 == null) {
            dummy.next = l2;
        } else {
            dummy.next = l1;
        }
        return head.next;
    }

    /**
     * 输入两个链表，找出它们的第一个公共节点。
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode nodeA = headA;
        ListNode nodeB = headB;
        while (nodeA != nodeB) {
            nodeA = nodeA == null ? headB : nodeA.next;
            nodeB = nodeB == null ? headA : nodeB.next;
        }
        return nodeA;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(4);
        node1.next = node2;
        node2.next = node3;

        ListNode node4 = new ListNode(1);
        ListNode node5 = new ListNode(3);
        ListNode node6 = new ListNode(4);
        node4.next = node5;
        node5.next = node6;
        System.out.println(solution.mergeTwoLists(node1, node4));
    }
}
