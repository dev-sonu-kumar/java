/*
 * PROBLEM STATEMENT:
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Example 1:
 * Input: head = [1,2,2,1]
 * Output: true
 * 
 * Example 2:
 * Input: head = [1,2]
 * Output: false
 * 
 * Constraints: The number of nodes in the list is in the range [1, 10^5], 0 ≤ Node.val ≤ 9
 */

public class _25_PalindromeLinkedList {
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        
        // Find middle of the list
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        
        // Reverse second half
        ListNode secondHalf = reverseList(slow.next);
        
        // Compare first half with reversed second half
        ListNode firstHalf = head;
        while (secondHalf != null) {
            if (firstHalf.val != secondHalf.val) {
                return false;
            }
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }
        
        return true;
    }
    
    private static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode current = head;
        
        while (current != null) {
            ListNode nextTemp = current.next;
            current.next = prev;
            prev = current;
            current = nextTemp;
        }
        
        return prev;
    }
    
    public static void main(String[] args) {
        // Create palindrome list: 1->2->2->1
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(2);
        head1.next.next.next = new ListNode(1);
        
        System.out.println("List [1,2,2,1] is palindrome: " + isPalindrome(head1));
        
        // Create non-palindrome list: 1->2
        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(2);
        
        System.out.println("List [1,2] is palindrome: " + isPalindrome(head2));
    }
}