/*
 * PROBLEM STATEMENT:
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * Return the linked list sorted as well.
 * 
 * Example 1:
 * Input: head = [1,1,2]
 * Output: [1,2]
 * 
 * Example 2:
 * Input: head = [1,1,2,3,3]
 * Output: [1,2,3]
 * 
 * Constraints: The number of nodes in the list is in the range [0, 300], -100 ≤ Node.val ≤ 100, The list is guaranteed to be sorted in ascending order.
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _16_RemoveDuplicatesFromSortedList {
    public static ListNode deleteDuplicates(ListNode head) {
        if (head == null) return null;
        
        ListNode current = head;
        
        while (current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next;
            } else {
                current = current.next;
            }
        }
        
        return head;
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create list: 1->1->2->3->3
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(3);
        
        System.out.print("Original: ");
        printList(head);
        
        ListNode result = deleteDuplicates(head);
        System.out.print("After removing duplicates: ");
        printList(result);
    }
}