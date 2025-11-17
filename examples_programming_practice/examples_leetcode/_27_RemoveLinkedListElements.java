/*
 * PROBLEM STATEMENT:
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.
 * 
 * Example 1:
 * Input: head = [1,2,6,3,4,5,6], val = 6
 * Output: [1,2,3,4,5]
 * 
 * Example 2:
 * Input: head = [], val = 1
 * Output: []
 * 
 * Example 3:
 * Input: head = [7,7,7,7], val = 7
 * Output: []
 * 
 * Constraints: The number of nodes in the list is in the range [0, 10^4], 1 ≤ Node.val ≤ 50, 0 ≤ val ≤ 50
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _27_RemoveLinkedListElements {
    public static ListNode removeElements(ListNode head, int val) {
        // Create dummy node to handle edge cases
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null) {
            if (current.val == val) {
                prev.next = current.next;
            } else {
                prev = current;
            }
            current = current.next;
        }
        
        return dummy.next;
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create list: 1->2->6->3->4->5->6
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(6);
        head1.next.next.next = new ListNode(3);
        head1.next.next.next.next = new ListNode(4);
        head1.next.next.next.next.next = new ListNode(5);
        head1.next.next.next.next.next.next = new ListNode(6);
        
        System.out.print("Original: ");
        printList(head1);
        
        ListNode result1 = removeElements(head1, 6);
        System.out.print("After removing 6: ");
        printList(result1);
        
        // Create list with all same values: 7->7->7->7
        ListNode head2 = new ListNode(7);
        head2.next = new ListNode(7);
        head2.next.next = new ListNode(7);
        head2.next.next.next = new ListNode(7);
        
        System.out.print("All 7s: ");
        printList(head2);
        
        ListNode result2 = removeElements(head2, 7);
        System.out.print("After removing all 7s: ");
        printList(result2);
    }
}