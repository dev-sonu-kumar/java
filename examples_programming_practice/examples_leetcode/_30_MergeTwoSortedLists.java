/*
 * PROBLEM STATEMENT:
 * You are given the heads of two sorted linked lists list1 and list2.
 * Merge the two lists in a one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * Return the head of the merged linked list.
 * 
 * Example 1:
 * Input: list1 = [1,2,4], list2 = [1,3,4]
 * Output: [1,1,2,3,4,4]
 * 
 * Example 2:
 * Input: list1 = [], list2 = []
 * Output: []
 * 
 * Example 3:
 * Input: list1 = [], list2 = [0]
 * Output: [0]
 * 
 * Constraints: The number of nodes in both lists is in the range [0, 50], -100 ≤ Node.val ≤ 100
 */

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

public class _30_MergeTwoSortedLists {
    // Iterative approach
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }
        
        // Attach remaining nodes
        current.next = (list1 != null) ? list1 : list2;
        
        return dummy.next;
    }
    
    // Recursive approach
    public static ListNode mergeTwoListsRecursive(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        
        if (list1.val <= list2.val) {
            list1.next = mergeTwoListsRecursive(list1.next, list2);
            return list1;
        } else {
            list2.next = mergeTwoListsRecursive(list1, list2.next);
            return list2;
        }
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
        // Create list1: 1->2->4
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(2);
        list1.next.next = new ListNode(4);
        
        // Create list2: 1->3->4
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        System.out.print("List1: ");
        printList(list1);
        System.out.print("List2: ");
        printList(list2);
        
        ListNode merged = mergeTwoLists(list1, list2);
        System.out.print("Merged (iterative): ");
        printList(merged);
        
        // Test with empty lists
        ListNode list3 = null;
        ListNode list4 = new ListNode(0);
        
        System.out.print("\nEmpty list1, list2 = [0]: ");
        ListNode merged2 = mergeTwoListsRecursive(list3, list4);
        printList(merged2);
        
        // Test with different lengths
        ListNode list5 = new ListNode(-1);
        list5.next = new ListNode(5);
        list5.next.next = new ListNode(11);
        
        ListNode list6 = new ListNode(6);
        list6.next = new ListNode(10);
        
        System.out.print("List5: ");
        printList(list5);
        System.out.print("List6: ");
        printList(list6);
        
        ListNode merged3 = mergeTwoListsRecursive(list5, list6);
        System.out.print("Merged (recursive): ");
        printList(merged3);
    }
}