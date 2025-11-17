/*
 * PROBLEM STATEMENT:
 * Given a linked list, swap every two adjacent nodes and return its head. 
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 * 
 * Example 1:
 * Input: head = [1,2,3,4]
 * Output: [2,1,4,3]
 * 
 * Example 2:
 * Input: head = []
 * Output: []
 * 
 * Example 3:
 * Input: head = [1]
 * Output: [1]
 * 
 * Constraints: The number of nodes in the list is in the range [0, 100], 0 ≤ Node.val ≤ 100
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _29_SwapNodesInPairs {
    public static ListNode swapPairs(ListNode head) {
        // Base case: if less than 2 nodes, return as is
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        
        while (prev.next != null && prev.next.next != null) {
            // Nodes to be swapped
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            
            // Swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;
            
            // Move prev to the end of swapped pair
            prev = first;
        }
        
        return dummy.next;
    }
    
    // Recursive approach
    public static ListNode swapPairsRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode second = head.next;
        head.next = swapPairsRecursive(second.next);
        second.next = head;
        
        return second;
    }
    
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    
    public static void main(String[] args) {
        // Create list: 1->2->3->4
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = new ListNode(4);
        
        System.out.print("Original: ");
        printList(head1);
        
        ListNode result1 = swapPairs(head1);
        System.out.print("After swapping pairs: ");
        printList(result1);
        
        // Create odd length list: 1->2->3->4->5
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        head2.next.next = new ListNode(3);
        head2.next.next.next = new ListNode(4);
        head2.next.next.next.next = new ListNode(5);
        
        System.out.print("\nOdd length original: ");
        printList(head2);
        
        ListNode result2 = swapPairsRecursive(head2);
        System.out.print("After swapping pairs (recursive): ");
        printList(result2);
        
        // Single node test
        ListNode head3 = new ListNode(1);
        System.out.print("\nSingle node: ");
        printList(head3);
        
        ListNode result3 = swapPairs(head3);
        System.out.print("After swapping: ");
        printList(result3);
    }
}