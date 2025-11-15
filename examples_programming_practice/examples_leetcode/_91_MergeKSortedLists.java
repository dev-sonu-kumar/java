/*
 * PROBLEM STATEMENT:
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example 1:
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * 
 * Example 2:
 * Input: lists = []
 * Output: []
 * 
 * Example 3:
 * Input: lists = [[]]
 * Output: []
 * 
 * Constraints: k == lists.length, 0 ≤ k ≤ 10^4, 0 ≤ lists[i].length ≤ 500, -10^4 ≤ lists[i][j] ≤ 10^4
 */

import java.util.*;

public class _91_MergeKSortedLists {
    // Divide and conquer approach - O(n log k) time
    public static ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        
        while (lists.length > 1) {
            List<ListNode> mergedLists = new ArrayList<>();
            
            for (int i = 0; i < lists.length; i += 2) {
                ListNode l1 = lists[i];
                ListNode l2 = (i + 1 < lists.length) ? lists[i + 1] : null;
                mergedLists.add(mergeTwoLists(l1, l2));
            }
            
            lists = mergedLists.toArray(new ListNode[0]);
        }
        
        return lists[0];
    }
    
    private static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                current.next = l1;
                l1 = l1.next;
            } else {
                current.next = l2;
                l2 = l2.next;
            }
            current = current.next;
        }
        
        current.next = (l1 != null) ? l1 : l2;
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
        // Create test lists
        ListNode list1 = new ListNode(1);
        list1.next = new ListNode(4);
        list1.next.next = new ListNode(5);
        
        ListNode list2 = new ListNode(1);
        list2.next = new ListNode(3);
        list2.next.next = new ListNode(4);
        
        ListNode list3 = new ListNode(2);
        list3.next = new ListNode(6);
        
        ListNode[] lists = {list1, list2, list3};
        ListNode merged = mergeKLists(lists);
        
        System.out.print("Merged k sorted lists: ");
        printList(merged);
    }
}