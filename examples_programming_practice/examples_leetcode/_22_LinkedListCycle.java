/*
 * PROBLEM STATEMENT:
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer.
 * Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.
 * 
 * Return true if there is a cycle in the linked list. Otherwise, return false.
 * 
 * Example 1:
 * Input: head = [3,2,0,-4], pos = 1
 * Output: true
 * Explanation: There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
 * 
 * Example 2:
 * Input: head = [1,2], pos = 0
 * Output: true
 * 
 * Example 3:
 * Input: head = [1], pos = -1
 * Output: false
 * 
 * Constraints: The number of the nodes in the list is in the range [0, 10^4], -10^5 ≤ Node.val ≤ 10^5, pos is -1 or a valid index in the linked-list.
 */

public class _22_LinkedListCycle {
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return true;
    }
    
    public static void main(String[] args) {
        // Create list with cycle: 3->2->0->-4->2 (cycle)
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(-4);
        head.next.next.next.next = head.next; // Create cycle
        
        System.out.println("List has cycle: " + hasCycle(head));
        
        // Create list without cycle: 1->2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println("List2 has cycle: " + hasCycle(head2));
    }
}