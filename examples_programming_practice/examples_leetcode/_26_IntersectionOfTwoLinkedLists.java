/*
 * PROBLEM STATEMENT:
 * Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect.
 * If the two linked lists have no intersection at all, return null.
 * 
 * Example 1:
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], skipA = 2, skipB = 3
 * Output: Intersected at '8'
 * 
 * Example 2:
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5]
 * Output: No intersection
 * 
 * Constraints: The number of nodes of listA is in the m, The number of nodes of listB is in the n
 */

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class _26_IntersectionOfTwoLinkedLists {
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        
        // When one pointer reaches end, redirect to other list's head
        while (pointerA != pointerB) {
            pointerA = (pointerA == null) ? headB : pointerA.next;
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        
        return pointerA; // Either intersection node or null
    }
    
    public static void main(String[] args) {
        // Create intersection node
        ListNode intersection = new ListNode(8);
        intersection.next = new ListNode(4);
        intersection.next.next = new ListNode(5);
        
        // Create listA: 4->1->8->4->5
        ListNode headA = new ListNode(4);
        headA.next = new ListNode(1);
        headA.next.next = intersection;
        
        // Create listB: 5->6->1->8->4->5
        ListNode headB = new ListNode(5);
        headB.next = new ListNode(6);
        headB.next.next = new ListNode(1);
        headB.next.next.next = intersection;
        
        ListNode result = getIntersectionNode(headA, headB);
        System.out.println("Intersection at: " + (result != null ? result.val : "No intersection"));
        
        // Test with no intersection
        ListNode listC = new ListNode(2);
        listC.next = new ListNode(6);
        listC.next.next = new ListNode(4);
        
        ListNode listD = new ListNode(1);
        listD.next = new ListNode(5);
        
        ListNode result2 = getIntersectionNode(listC, listD);
        System.out.println("No intersection case: " + (result2 != null ? result2.val : "No intersection"));
    }
}