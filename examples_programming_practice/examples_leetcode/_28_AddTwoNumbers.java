/*
 * PROBLEM STATEMENT:
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The digits are stored in reverse order, and each of their nodes contains a single digit. 
 * Add the two numbers and return the sum as a linked list.
 * 
 * Example 1:
 * Input: l1 = [2,4,3], l2 = [5,6,4]
 * Output: [7,0,8]
 * Explanation: 342 + 465 = 807.
 * 
 * Example 2:
 * Input: l1 = [0], l2 = [0]
 * Output: [0]
 * 
 * Example 3:
 * Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * Output: [8,9,9,9,0,0,0,1]
 * 
 * Constraints: The number of nodes in each linked list is in the range [1, 100], 0 ≤ Node.val ≤ 9
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _28_AddTwoNumbers {
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        int carry = 0;
        
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;
            
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }
            
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }
        
        return dummy.next;
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
        // Create l1: 2->4->3 (represents 342)
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);
        
        // Create l2: 5->6->4 (represents 465)
        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);
        
        System.out.print("L1: ");
        printList(l1);
        System.out.print("L2: ");
        printList(l2);
        
        ListNode result = addTwoNumbers(l1, l2);
        System.out.print("Sum: ");
        printList(result);
        
        // Test with carry: 9->9->9->9->9->9->9 + 9->9->9->9
        ListNode l3 = new ListNode(9);
        l3.next = new ListNode(9);
        l3.next.next = new ListNode(9);
        l3.next.next.next = new ListNode(9);
        l3.next.next.next.next = new ListNode(9);
        l3.next.next.next.next.next = new ListNode(9);
        l3.next.next.next.next.next.next = new ListNode(9);
        
        ListNode l4 = new ListNode(9);
        l4.next = new ListNode(9);
        l4.next.next = new ListNode(9);
        l4.next.next.next = new ListNode(9);
        
        System.out.print("\nL3: ");
        printList(l3);
        System.out.print("L4: ");
        printList(l4);
        
        ListNode result2 = addTwoNumbers(l3, l4);
        System.out.print("Sum with carry: ");
        printList(result2);
    }
}