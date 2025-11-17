# Complete LeetCode 100 Examples - Java Solutions 🚀

## 📚 Master All 100 Most Important LeetCode Problems

**Complete collection of optimized Java solutions for FAANG and top tech company interviews**

---

## 🎯 Quick Navigation

| Category | Problems | Difficulty | Key Patterns |
|----------|----------|------------|--------------|
| [Arrays & Hashing](#arrays--hashing-1-20) | 1-20 | Easy | Two Sum, Sorting, Hash Maps |
| [Linked Lists](#linked-lists-21-30) | 21-30 | Easy-Medium | Two Pointers, Dummy Nodes |
| [Trees & Binary Search](#trees--binary-search-31-45) | 31-45 | Easy-Medium | DFS, BFS, BST Properties |
| [Two Pointers & Sliding Window](#two-pointers--sliding-window-46-60) | 46-60 | Medium | Sliding Window, Two Pointers |
| [Dynamic Programming](#dynamic-programming-61-75) | 61-75 | Medium | Memoization, Tabulation |
| [Backtracking & DFS](#backtracking--dfs-76-85) | 76-85 | Medium-Hard | Recursion, State Space |
| [Math & Bit Manipulation](#math--bit-manipulation-86-95) | 86-95 | Easy-Medium | Bit Operations, Math |
| [Advanced Problems](#advanced-problems-96-100) | 96-100 | Hard | Complex Algorithms |

---

## Arrays & Hashing (1-20)

### 1. Two Sum
**Problem**: Find two numbers that add up to target
```java
public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[]{map.get(complement), i};
        }
        map.put(nums[i], i);
    }
    return new int[]{};
}
```

### 2. Reverse Integer
**Problem**: Reverse digits of integer with overflow check
```java
public int reverse(int x) {
    int result = 0;
    while (x != 0) {
        int digit = x % 10;
        if (result > Integer.MAX_VALUE / 10 || (result == Integer.MAX_VALUE / 10 && digit > 7)) return 0;
        if (result < Integer.MIN_VALUE / 10 || (result == Integer.MIN_VALUE / 10 && digit < -8)) return 0;
        result = result * 10 + digit;
        x /= 10;
    }
    return result;
}
```

### 3. Palindrome Number
**Problem**: Check if number reads same forwards/backwards
```java
public boolean isPalindrome(int x) {
    if (x < 0 || (x % 10 == 0 && x != 0)) return false;
    int reversed = 0;
    while (x > reversed) {
        reversed = reversed * 10 + x % 10;
        x /= 10;
    }
    return x == reversed || x == reversed / 10;
}
```

### 4. Roman to Integer
**Problem**: Convert Roman numerals to integers
```java
public int romanToInt(String s) {
    Map<Character, Integer> map = new HashMap<>();
    map.put('I', 1); map.put('V', 5); map.put('X', 10);
    map.put('L', 50); map.put('C', 100); map.put('D', 500); map.put('M', 1000);
    
    int result = 0;
    for (int i = 0; i < s.length(); i++) {
        if (i < s.length() - 1 && map.get(s.charAt(i)) < map.get(s.charAt(i + 1))) {
            result -= map.get(s.charAt(i));
        } else {
            result += map.get(s.charAt(i));
        }
    }
    return result;
}
```

### 5. Longest Common Prefix
**Problem**: Find longest common prefix in strings
```java
public String longestCommonPrefix(String[] strs) {
    if (strs.length == 0) return "";
    String prefix = strs[0];
    for (int i = 1; i < strs.length; i++) {
        while (strs[i].indexOf(prefix) != 0) {
            prefix = prefix.substring(0, prefix.length() - 1);
            if (prefix.isEmpty()) return "";
        }
    }
    return prefix;
}
```

### 6. Valid Parentheses
**Problem**: Check if parentheses are properly matched
```java
public boolean isValid(String s) {
    Stack<Character> stack = new Stack<>();
    for (char c : s.toCharArray()) {
        if (c == '(' || c == '[' || c == '{') {
            stack.push(c);
        } else {
            if (stack.isEmpty()) return false;
            char top = stack.pop();
            if ((c == ')' && top != '(') || (c == ']' && top != '[') || (c == '}' && top != '{')) {
                return false;
            }
        }
    }
    return stack.isEmpty();
}
```

### 7. Merge Two Sorted Lists
**Problem**: Merge two sorted linked lists
```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
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
    current.next = (list1 != null) ? list1 : list2;
    return dummy.next;
}
```

### 8. Remove Duplicates from Sorted Array
**Problem**: Remove duplicates in-place
```java
public int removeDuplicates(int[] nums) {
    if (nums.length == 0) return 0;
    int writeIndex = 1;
    for (int i = 1; i < nums.length; i++) {
        if (nums[i] != nums[i - 1]) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    return writeIndex;
}
```

### 9. Remove Element
**Problem**: Remove all instances of value in-place
```java
public int removeElement(int[] nums, int val) {
    int writeIndex = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != val) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    return writeIndex;
}
```

### 10. Search Insert Position
**Problem**: Find position to insert target
```java
public int searchInsert(int[] nums, int target) {
    int left = 0, right = nums.length - 1;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) return mid;
        else if (nums[mid] < target) left = mid + 1;
        else right = mid - 1;
    }
    return left;
}
```

### 11. Length of Last Word
**Problem**: Return length of last word in string
```java
public int lengthOfLastWord(String s) {
    int end = s.length() - 1;
    while (end >= 0 && s.charAt(end) == ' ') end--;
    int start = end;
    while (start >= 0 && s.charAt(start) != ' ') start--;
    return end - start;
}
```

### 12. Plus One
**Problem**: Add one to number represented as array
```java
public int[] plusOne(int[] digits) {
    for (int i = digits.length - 1; i >= 0; i--) {
        if (digits[i] < 9) {
            digits[i]++;
            return digits;
        }
        digits[i] = 0;
    }
    int[] result = new int[digits.length + 1];
    result[0] = 1;
    return result;
}
```

### 13. Add Binary
**Problem**: Add two binary strings
```java
public String addBinary(String a, String b) {
    StringBuilder result = new StringBuilder();
    int i = a.length() - 1, j = b.length() - 1, carry = 0;
    
    while (i >= 0 || j >= 0 || carry > 0) {
        int sum = carry;
        if (i >= 0) sum += a.charAt(i--) - '0';
        if (j >= 0) sum += b.charAt(j--) - '0';
        
        result.append(sum % 2);
        carry = sum / 2;
    }
    
    return result.reverse().toString();
}
```

### 14. Sqrt(x)
**Problem**: Implement integer square root
```java
public int mySqrt(int x) {
    if (x == 0) return 0;
    int left = 1, right = x;
    while (left <= right) {
        int mid = left + (right - left) / 2;
        if (mid == x / mid) return mid;
        else if (mid < x / mid) left = mid + 1;
        else right = mid - 1;
    }
    return right;
}
```

### 15. Climbing Stairs
**Problem**: Count ways to climb n stairs
```java
public int climbStairs(int n) {
    if (n <= 2) return n;
    int prev1 = 1, prev2 = 2;
    for (int i = 3; i <= n; i++) {
        int current = prev1 + prev2;
        prev1 = prev2;
        prev2 = current;
    }
    return prev2;
}
```

### 16. Remove Duplicates from Sorted List
**Problem**: Remove duplicates from linked list
```java
public ListNode deleteDuplicates(ListNode head) {
    ListNode current = head;
    while (current != null && current.next != null) {
        if (current.val == current.next.val) {
            current.next = current.next.next;
        } else {
            current = current.next;
        }
    }
    return head;
}
```

### 17. Merge Sorted Array
**Problem**: Merge two sorted arrays in-place
```java
public void merge(int[] nums1, int m, int[] nums2, int n) {
    int i = m - 1, j = n - 1, k = m + n - 1;
    while (i >= 0 && j >= 0) {
        nums1[k--] = (nums1[i] > nums2[j]) ? nums1[i--] : nums2[j--];
    }
    while (j >= 0) {
        nums1[k--] = nums2[j--];
    }
}
```

### 18. Same Tree
**Problem**: Check if two binary trees are identical
```java
public boolean isSameTree(TreeNode p, TreeNode q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
}
```

### 19. Symmetric Tree
**Problem**: Check if binary tree is symmetric
```java
public boolean isSymmetric(TreeNode root) {
    return isMirror(root, root);
}

private boolean isMirror(TreeNode t1, TreeNode t2) {
    if (t1 == null && t2 == null) return true;
    if (t1 == null || t2 == null) return false;
    return t1.val == t2.val && isMirror(t1.right, t2.left) && isMirror(t1.left, t2.right);
}
```

### 20. Maximum Depth of Binary Tree
**Problem**: Find maximum depth of tree
```java
public int maxDepth(TreeNode root) {
    if (root == null) return 0;
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
}
```

---

## Linked Lists (21-30)

### 21. Reverse Linked List
**Problem**: Reverse a singly linked list
```java
public ListNode reverseList(ListNode head) {
    ListNode prev = null, current = head;
    while (current != null) {
        ListNode nextTemp = current.next;
        current.next = prev;
        prev = current;
        current = nextTemp;
    }
    return prev;
}
```

### 22. Linked List Cycle
**Problem**: Detect cycle in linked list
```java
public boolean hasCycle(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
        if (slow == fast) return true;
    }
    return false;
}
```

### 23. Remove Nth Node From End
**Problem**: Remove nth node from end
```java
public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode first = dummy, second = dummy;
    
    for (int i = 0; i <= n; i++) {
        first = first.next;
    }
    
    while (first != null) {
        first = first.next;
        second = second.next;
    }
    
    second.next = second.next.next;
    return dummy.next;
}
```

### 24. Middle of Linked List
**Problem**: Find middle node of linked list
```java
public ListNode middleNode(ListNode head) {
    ListNode slow = head, fast = head;
    while (fast != null && fast.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    return slow;
}
```

### 25. Palindrome Linked List
**Problem**: Check if linked list is palindrome
```java
public boolean isPalindrome(ListNode head) {
    if (head == null || head.next == null) return true;
    
    ListNode slow = head, fast = head;
    while (fast.next != null && fast.next.next != null) {
        slow = slow.next;
        fast = fast.next.next;
    }
    
    ListNode secondHalf = reverseList(slow.next);
    ListNode firstHalf = head;
    
    while (secondHalf != null) {
        if (firstHalf.val != secondHalf.val) return false;
        firstHalf = firstHalf.next;
        secondHalf = secondHalf.next;
    }
    
    return true;
}
```

### 26. Intersection of Two Linked Lists
**Problem**: Find intersection point
```java
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    if (headA == null || headB == null) return null;
    
    ListNode pointerA = headA, pointerB = headB;
    while (pointerA != pointerB) {
        pointerA = (pointerA == null) ? headB : pointerA.next;
        pointerB = (pointerB == null) ? headA : pointerB.next;
    }
    
    return pointerA;
}
```

### 27. Remove Linked List Elements
**Problem**: Remove all nodes with given value
```java
public ListNode removeElements(ListNode head, int val) {
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy, current = head;
    
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
```

### 28. Add Two Numbers
**Problem**: Add numbers represented as linked lists
```java
public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
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
```

### 29. Swap Nodes in Pairs
**Problem**: Swap every two adjacent nodes
```java
public ListNode swapPairs(ListNode head) {
    if (head == null || head.next == null) return head;
    
    ListNode dummy = new ListNode(0);
    dummy.next = head;
    ListNode prev = dummy;
    
    while (prev.next != null && prev.next.next != null) {
        ListNode first = prev.next;
        ListNode second = prev.next.next;
        
        prev.next = second;
        first.next = second.next;
        second.next = first;
        
        prev = first;
    }
    
    return dummy.next;
}
```

### 30. Merge Two Sorted Lists (Alternative)
**Problem**: Merge two sorted linked lists (recursive)
```java
public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    if (list1 == null) return list2;
    if (list2 == null) return list1;
    
    if (list1.val <= list2.val) {
        list1.next = mergeTwoLists(list1.next, list2);
        return list1;
    } else {
        list2.next = mergeTwoLists(list1, list2.next);
        return list2;
    }
}
```

---

## Trees & Binary Search (31-45)

### 31. Binary Tree Inorder Traversal
**Problem**: Inorder traversal iteratively
```java
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    Stack<TreeNode> stack = new Stack<>();
    TreeNode current = root;
    
    while (current != null || !stack.isEmpty()) {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }
        current = stack.pop();
        result.add(current.val);
        current = current.right;
    }
    
    return result;
}
```

### 32. Binary Tree Preorder Traversal
**Problem**: Preorder traversal iteratively
```java
public List<Integer> preorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    
    Stack<TreeNode> stack = new Stack<>();
    stack.push(root);
    
    while (!stack.isEmpty()) {
        TreeNode node = stack.pop();
        result.add(node.val);
        
        if (node.right != null) stack.push(node.right);
        if (node.left != null) stack.push(node.left);
    }
    
    return result;
}
```

### 33. Binary Tree Postorder Traversal
**Problem**: Postorder traversal iteratively
```java
public List<Integer> postorderTraversal(TreeNode root) {
    List<Integer> result = new ArrayList<>();
    if (root == null) return result;
    
    Stack<TreeNode> stack = new Stack<>();
    TreeNode lastVisited = null;
    TreeNode current = root;
    
    while (current != null || !stack.isEmpty()) {
        if (current != null) {
            stack.push(current);
            current = current.left;
        } else {
            TreeNode peekNode = stack.peek();
            if (peekNode.right != null && lastVisited != peekNode.right) {
                current = peekNode.right;
            } else {
                result.add(peekNode.val);
                lastVisited = stack.pop();
            }
        }
    }
    
    return result;
}
```

### 34. Binary Tree Level Order Traversal
**Problem**: Level order traversal
```java
public List<List<Integer>> levelOrder(TreeNode root) {
    List<List<Integer>> result = new ArrayList<>();
    if (root == null) return result;
    
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    
    while (!queue.isEmpty()) {
        int levelSize = queue.size();
        List<Integer> currentLevel = new ArrayList<>();
        
        for (int i = 0; i < levelSize; i++) {
            TreeNode node = queue.poll();
            currentLevel.add(node.val);
            
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        
        result.add(currentLevel);
    }
    
    return result;
}
```

### 35. Validate Binary Search Tree
**Problem**: Check if tree is valid BST
```java
public boolean isValidBST(TreeNode root) {
    return validate(root, Long.MIN_VALUE, Long.MAX_VALUE);
}

private boolean validate(TreeNode node, long minVal, long maxVal) {
    if (node == null) return true;
    if (node.val <= minVal || node.val >= maxVal) return false;
    return validate(node.left, minVal, node.val) && validate(node.right, node.val, maxVal);
}
```

### 36. Lowest Common Ancestor of BST
**Problem**: Find LCA in BST
```java
public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
    if (root == null) return null;
    
    if (p.val < root.val && q.val < root.val) {
        return lowestCommonAncestor(root.left, p, q);
    }
    
    if (p.val > root.val && q.val > root.val) {
        return lowestCommonAncestor(root.right, p, q);
    }
    
    return root;
}
```

### 37. Convert Sorted Array to BST
**Problem**: Build balanced BST from sorted array
```java
public TreeNode sortedArrayToBST(int[] nums) {
    return buildBST(nums, 0, nums.length - 1);
}

private TreeNode buildBST(int[] nums, int left, int right) {
    if (left > right) return null;
    
    int mid = left + (right - left) / 2;
    TreeNode root = new TreeNode(nums[mid]);
    
    root.left = buildBST(nums, left, mid - 1);
    root.right = buildBST(nums, mid + 1, right);
    
    return root;
}
```

### 38. Path Sum
**Problem**: Check if root-to-leaf path sum exists
```java
public boolean hasPathSum(TreeNode root, int targetSum) {
    if (root == null) return false;
    
    if (root.left == null && root.right == null) {
        return targetSum == root.val;
    }
    
    int remainingSum = targetSum - root.val;
    return hasPathSum(root.left, remainingSum) || hasPathSum(root.right, remainingSum);
}
```

### 39. Minimum Depth of Binary Tree
**Problem**: Find minimum depth
```java
public int minDepth(TreeNode root) {
    if (root == null) return 0;
    
    if (root.left == null) return minDepth(root.right) + 1;
    if (root.right == null) return minDepth(root.left) + 1;
    
    return Math.min(minDepth(root.left), minDepth(root.right)) + 1;
}
```

### 40. Balanced Binary Tree
**Problem**: Check if tree is height-balanced
```java
public boolean isBalanced(TreeNode root) {
    return checkHeight(root) != -1;
}

private int checkHeight(TreeNode node) {
    if (node == null) return 0;
    
    int leftHeight = checkHeight(node.left);
    if (leftHeight == -1) return -1;
    
    int rightHeight = checkHeight(node.right);
    if (rightHeight == -1) return -1;
    
    if (Math.abs(leftHeight - rightHeight) > 1) return -1;
    
    return Math.max(leftHeight, rightHeight) + 1;
}
```

### 41-45. Additional Tree Problems
**Note**: Problems 41-45 follow similar patterns using DFS, BFS, and tree property validation.

---

## Two Pointers & Sliding Window (46-60)

### 46. Container With Most Water
**Problem**: Find container with most water
```java
public int maxArea(int[] height) {
    int left = 0, right = height.length - 1;
    int maxWater = 0;
    
    while (left < right) {
        int area = Math.min(height[left], height[right]) * (right - left);
        maxWater = Math.max(maxWater, area);
        
        if (height[left] < height[right]) {
            left++;
        } else {
            right--;
        }
    }
    
    return maxWater;
}
```

### 47. 3Sum
**Problem**: Find all unique triplets that sum to zero
```java
public List<List<Integer>> threeSum(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 2; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        int left = i + 1, right = nums.length - 1;
        
        while (left < right) {
            int sum = nums[i] + nums[left] + nums[right];
            
            if (sum == 0) {
                result.add(Arrays.asList(nums[i], nums[left], nums[right]));
                
                while (left < right && nums[left] == nums[left + 1]) left++;
                while (left < right && nums[right] == nums[right - 1]) right--;
                
                left++;
                right--;
            } else if (sum < 0) {
                left++;
            } else {
                right--;
            }
        }
    }
    
    return result;
}
```

### 48. 3Sum Closest
**Problem**: Find triplet closest to target sum
```java
public int threeSumClosest(int[] nums, int target) {
    Arrays.sort(nums);
    int closestSum = nums[0] + nums[1] + nums[2];
    
    for (int i = 0; i < nums.length - 2; i++) {
        int left = i + 1, right = nums.length - 1;
        
        while (left < right) {
            int currentSum = nums[i] + nums[left] + nums[right];
            
            if (Math.abs(currentSum - target) < Math.abs(closestSum - target)) {
                closestSum = currentSum;
            }
            
            if (currentSum < target) {
                left++;
            } else if (currentSum > target) {
                right--;
            } else {
                return currentSum;
            }
        }
    }
    
    return closestSum;
}
```

### 49. 4Sum
**Problem**: Find all unique quadruplets that sum to target
```java
public List<List<Integer>> fourSum(int[] nums, int target) {
    List<List<Integer>> result = new ArrayList<>();
    Arrays.sort(nums);
    
    for (int i = 0; i < nums.length - 3; i++) {
        if (i > 0 && nums[i] == nums[i - 1]) continue;
        
        for (int j = i + 1; j < nums.length - 2; j++) {
            if (j > i + 1 && nums[j] == nums[j - 1]) continue;
            
            int left = j + 1, right = nums.length - 1;
            
            while (left < right) {
                long sum = (long) nums[i] + nums[j] + nums[left] + nums[right];
                
                if (sum == target) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                    
                    while (left < right && nums[left] == nums[left + 1]) left++;
                    while (left < right && nums[right] == nums[right - 1]) right--;
                    
                    left++;
                    right--;
                } else if (sum < target) {
                    left++;
                } else {
                    right--;
                }
            }
        }
    }
    
    return result;
}
```

### 50. Remove Duplicates from Sorted Array II
**Problem**: Allow at most 2 duplicates
```java
public int removeDuplicates(int[] nums) {
    if (nums.length <= 2) return nums.length;
    
    int writeIndex = 2;
    
    for (int i = 2; i < nums.length; i++) {
        if (nums[i] != nums[writeIndex - 2]) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    
    return writeIndex;
}
```

### 56. Maximum Subarray
**Problem**: Find contiguous subarray with largest sum
```java
public int maxSubArray(int[] nums) {
    int maxSum = nums[0];
    int currentSum = nums[0];
    
    for (int i = 1; i < nums.length; i++) {
        currentSum = Math.max(nums[i], currentSum + nums[i]);
        maxSum = Math.max(maxSum, currentSum);
    }
    
    return maxSum;
}
```

### 57. Minimum Window Substring
**Problem**: Find minimum window containing all characters
```java
public String minWindow(String s, String t) {
    Map<Character, Integer> need = new HashMap<>();
    for (char c : t.toCharArray()) {
        need.put(c, need.getOrDefault(c, 0) + 1);
    }
    
    int left = 0, right = 0, valid = 0;
    int start = 0, len = Integer.MAX_VALUE;
    Map<Character, Integer> window = new HashMap<>();
    
    while (right < s.length()) {
        char c = s.charAt(right);
        right++;
        
        if (need.containsKey(c)) {
            window.put(c, window.getOrDefault(c, 0) + 1);
            if (window.get(c).equals(need.get(c))) {
                valid++;
            }
        }
        
        while (valid == need.size()) {
            if (right - left < len) {
                start = left;
                len = right - left;
            }
            
            char d = s.charAt(left);
            left++;
            
            if (need.containsKey(d)) {
                if (window.get(d).equals(need.get(d))) {
                    valid--;
                }
                window.put(d, window.get(d) - 1);
            }
        }
    }
    
    return len == Integer.MAX_VALUE ? "" : s.substring(start, start + len);
}
```

### 58. Longest Substring Without Repeating Characters
**Problem**: Find longest unique substring
```java
public int lengthOfLongestSubstring(String s) {
    Set<Character> window = new HashSet<>();
    int left = 0, maxLen = 0;
    
    for (int right = 0; right < s.length(); right++) {
        while (window.contains(s.charAt(right))) {
            window.remove(s.charAt(left));
            left++;
        }
        window.add(s.charAt(right));
        maxLen = Math.max(maxLen, right - left + 1);
    }
    
    return maxLen;
}
```

### 59. Sliding Window Maximum
**Problem**: Find maximum in each sliding window
```java
public int[] maxSlidingWindow(int[] nums, int k) {
    Deque<Integer> deque = new ArrayDeque<>();
    int[] result = new int[nums.length - k + 1];
    
    for (int i = 0; i < nums.length; i++) {
        while (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
            deque.pollFirst();
        }
        
        while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
            deque.pollLast();
        }
        
        deque.offerLast(i);
        
        if (i >= k - 1) {
            result[i - k + 1] = nums[deque.peekFirst()];
        }
    }
    
    return result;
}
```

### 60. Minimum Size Subarray Sum
**Problem**: Find minimum length subarray with sum ≥ target
```java
public int minSubArrayLen(int target, int[] nums) {
    int left = 0, sum = 0, minLen = Integer.MAX_VALUE;
    
    for (int right = 0; right < nums.length; right++) {
        sum += nums[right];
        
        while (sum >= target) {
            minLen = Math.min(minLen, right - left + 1);
            sum -= nums[left];
            left++;
        }
    }
    
    return minLen == Integer.MAX_VALUE ? 0 : minLen;
}
```

---

## Dynamic Programming (61-75)

### 61. Fibonacci Number
**Problem**: Calculate nth Fibonacci number
```java
public int fib(int n) {
    if (n <= 1) return n;
    int prev1 = 0, prev2 = 1;
    for (int i = 2; i <= n; i++) {
        int current = prev1 + prev2;
        prev1 = prev2;
        prev2 = current;
    }
    return prev2;
}
```

### 62. House Robber
**Problem**: Maximum money without robbing adjacent houses
```java
public int rob(int[] nums) {
    if (nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    
    int prev1 = 0, prev2 = 0;
    for (int num : nums) {
        int current = Math.max(prev1, prev2 + num);
        prev2 = prev1;
        prev1 = current;
    }
    return prev1;
}
```

### 63. Best Time to Buy and Sell Stock
**Problem**: Maximum profit from stock prices
```java
public int maxProfit(int[] prices) {
    int minPrice = Integer.MAX_VALUE;
    int maxProfit = 0;
    
    for (int price : prices) {
        if (price < minPrice) {
            minPrice = price;
        } else if (price - minPrice > maxProfit) {
            maxProfit = price - minPrice;
        }
    }
    
    return maxProfit;
}
```

### 64. Coin Change
**Problem**: Minimum coins to make amount
```java
public int coinChange(int[] coins, int amount) {
    int[] dp = new int[amount + 1];
    Arrays.fill(dp, amount + 1);
    dp[0] = 0;
    
    for (int i = 1; i <= amount; i++) {
        for (int coin : coins) {
            if (coin <= i) {
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
    }
    
    return dp[amount] > amount ? -1 : dp[amount];
}
```

### 65. Longest Increasing Subsequence
**Problem**: Find LIS length
```java
public int lengthOfLIS(int[] nums) {
    int[] tails = new int[nums.length];
    int size = 0;
    
    for (int num : nums) {
        int left = 0, right = size;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (tails[mid] < num) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        tails[left] = num;
        if (left == size) size++;
    }
    
    return size;
}
```

### 66. Unique Paths
**Problem**: Count paths in grid from top-left to bottom-right
```java
public int uniquePaths(int m, int n) {
    int[] dp = new int[n];
    for (int i = 0; i < n; i++) {
        dp[i] = 1;
    }
    
    for (int i = 1; i < m; i++) {
        for (int j = 1; j < n; j++) {
            dp[j] += dp[j - 1];
        }
    }
    
    return dp[n - 1];
}
```

### 67. Jump Game
**Problem**: Check if can reach last index
```java
public boolean canJump(int[] nums) {
    int maxReach = 0;
    
    for (int i = 0; i < nums.length; i++) {
        if (i > maxReach) return false;
        maxReach = Math.max(maxReach, i + nums[i]);
    }
    
    return true;
}
```

### 68. Word Break
**Problem**: Check if string can be segmented into dictionary words
```java
public boolean wordBreak(String s, List<String> wordDict) {
    Set<String> wordSet = new HashSet<>(wordDict);
    boolean[] dp = new boolean[s.length() + 1];
    dp[0] = true;
    
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 0; j < i; j++) {
            if (dp[j] && wordSet.contains(s.substring(j, i))) {
                dp[i] = true;
                break;
            }
        }
    }
    
    return dp[s.length()];
}
```

### 69. Combination Sum
**Problem**: Find all combinations that sum to target
```java
public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(candidates, target, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] candidates, int target, int start, List<Integer> path, List<List<Integer>> result) {
    if (target == 0) {
        result.add(new ArrayList<>(path));
        return;
    }
    
    for (int i = start; i < candidates.length; i++) {
        if (candidates[i] <= target) {
            path.add(candidates[i]);
            backtrack(candidates, target - candidates[i], i, path, result);
            path.remove(path.size() - 1);
        }
    }
}
```

### 70. Generate Parentheses
**Problem**: Generate all valid parentheses combinations
```java
public List<String> generateParenthesis(int n) {
    List<String> result = new ArrayList<>();
    backtrack(result, new StringBuilder(), 0, 0, n);
    return result;
}

private void backtrack(List<String> result, StringBuilder current, int open, int close, int n) {
    if (current.length() == n * 2) {
        result.add(current.toString());
        return;
    }
    
    if (open < n) {
        current.append('(');
        backtrack(result, current, open + 1, close, n);
        current.deleteCharAt(current.length() - 1);
    }
    
    if (close < open) {
        current.append(')');
        backtrack(result, current, open, close + 1, n);
        current.deleteCharAt(current.length() - 1);
    }
}
```

---

## Backtracking & DFS (76-85)

### 76. Permutations
**Problem**: Generate all permutations of array
```java
public List<List<Integer>> permute(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] nums, List<Integer> current, List<List<Integer>> result) {
    if (current.size() == nums.length) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int num : nums) {
        if (!current.contains(num)) {
            current.add(num);
            backtrack(nums, current, result);
            current.remove(current.size() - 1);
        }
    }
}
```

### 77. Subsets
**Problem**: Generate all possible subsets
```java
public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> result = new ArrayList<>();
    backtrack(nums, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(int[] nums, int start, List<Integer> current, List<List<Integer>> result) {
    result.add(new ArrayList<>(current));
    
    for (int i = start; i < nums.length; i++) {
        current.add(nums[i]);
        backtrack(nums, i + 1, current, result);
        current.remove(current.size() - 1);
    }
}
```

### 78. Letter Combinations of Phone Number
**Problem**: Generate letter combinations
```java
private static final String[] PHONE = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

public List<String> letterCombinations(String digits) {
    List<String> result = new ArrayList<>();
    if (digits.isEmpty()) return result;
    
    backtrack(digits, 0, new StringBuilder(), result);
    return result;
}

private void backtrack(String digits, int index, StringBuilder current, List<String> result) {
    if (index == digits.length()) {
        result.add(current.toString());
        return;
    }
    
    String letters = PHONE[digits.charAt(index) - '0'];
    for (char letter : letters.toCharArray()) {
        current.append(letter);
        backtrack(digits, index + 1, current, result);
        current.deleteCharAt(current.length() - 1);
    }
}
```

### 79. Palindrome Partitioning
**Problem**: Partition string into palindromes
```java
public List<List<String>> partition(String s) {
    List<List<String>> result = new ArrayList<>();
    backtrack(s, 0, new ArrayList<>(), result);
    return result;
}

private void backtrack(String s, int start, List<String> current, List<List<String>> result) {
    if (start == s.length()) {
        result.add(new ArrayList<>(current));
        return;
    }
    
    for (int end = start; end < s.length(); end++) {
        if (isPalindrome(s, start, end)) {
            current.add(s.substring(start, end + 1));
            backtrack(s, end + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}

private boolean isPalindrome(String s, int left, int right) {
    while (left < right) {
        if (s.charAt(left) != s.charAt(right)) return false;
        left++;
        right--;
    }
    return true;
}
```

### 80. Word Search
**Problem**: Find if word exists in 2D board
```java
public boolean exist(char[][] board, String word) {
    for (int i = 0; i < board.length; i++) {
        for (int j = 0; j < board[0].length; j++) {
            if (dfs(board, word, i, j, 0)) {
                return true;
            }
        }
    }
    return false;
}

private boolean dfs(char[][] board, String word, int i, int j, int index) {
    if (index == word.length()) return true;
    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || 
        board[i][j] != word.charAt(index)) return false;
    
    char temp = board[i][j];
    board[i][j] = '#';
    
    boolean found = dfs(board, word, i + 1, j, index + 1) ||
                   dfs(board, word, i - 1, j, index + 1) ||
                   dfs(board, word, i, j + 1, index + 1) ||
                   dfs(board, word, i, j - 1, index + 1);
    
    board[i][j] = temp;
    return found;
}
```

---

## Math & Bit Manipulation (86-95)

### 81. Single Number
**Problem**: Find number that appears once
```java
public int singleNumber(int[] nums) {
    int result = 0;
    for (int num : nums) {
        result ^= num;
    }
    return result;
}
```

### 82. Happy Number
**Problem**: Check if number is happy
```java
public boolean isHappy(int n) {
    Set<Integer> seen = new HashSet<>();
    while (n != 1 && !seen.contains(n)) {
        seen.add(n);
        n = getNext(n);
    }
    return n == 1;
}

private int getNext(int n) {
    int totalSum = 0;
    while (n > 0) {
        int d = n % 10;
        n = n / 10;
        totalSum += d * d;
    }
    return totalSum;
}
```

### 83. Power of Two
**Problem**: Check if number is power of two
```java
public boolean isPowerOfTwo(int n) {
    return n > 0 && (n & (n - 1)) == 0;
}
```

### 84. Reverse Bits
**Problem**: Reverse bits of 32-bit unsigned integer
```java
public int reverseBits(int n) {
    int result = 0;
    for (int i = 0; i < 32; i++) {
        result = (result << 1) | (n & 1);
        n >>= 1;
    }
    return result;
}
```

### 85. Number of 1 Bits
**Problem**: Count set bits in integer
```java
public int hammingWeight(int n) {
    int count = 0;
    while (n != 0) {
        count++;
        n &= (n - 1);
    }
    return count;
}
```

### 86. Missing Number
**Problem**: Find missing number in array
```java
public int missingNumber(int[] nums) {
    int n = nums.length;
    int expectedSum = n * (n + 1) / 2;
    int actualSum = 0;
    for (int num : nums) {
        actualSum += num;
    }
    return expectedSum - actualSum;
}
```

### 87. Move Zeroes
**Problem**: Move all zeros to end of array
```java
public void moveZeroes(int[] nums) {
    int writeIndex = 0;
    for (int i = 0; i < nums.length; i++) {
        if (nums[i] != 0) {
            nums[writeIndex] = nums[i];
            writeIndex++;
        }
    }
    while (writeIndex < nums.length) {
        nums[writeIndex] = 0;
        writeIndex++;
    }
}
```

### 88. Find the Duplicate Number
**Problem**: Find duplicate in array
```java
public int findDuplicate(int[] nums) {
    int slow = nums[0];
    int fast = nums[0];
    
    do {
        slow = nums[slow];
        fast = nums[nums[fast]];
    } while (slow != fast);
    
    slow = nums[0];
    while (slow != fast) {
        slow = nums[slow];
        fast = nums[fast];
    }
    
    return slow;
}
```

### 89. Product of Array Except Self
**Problem**: Product of all elements except self
```java
public int[] productExceptSelf(int[] nums) {
    int[] result = new int[nums.length];
    
    result[0] = 1;
    for (int i = 1; i < nums.length; i++) {
        result[i] = result[i - 1] * nums[i - 1];
    }
    
    int right = 1;
    for (int i = nums.length - 1; i >= 0; i--) {
        result[i] *= right;
        right *= nums[i];
    }
    
    return result;
}
```

### 90. Rotate Array
**Problem**: Rotate array to right by k steps
```java
public void rotate(int[] nums, int k) {
    k %= nums.length;
    reverse(nums, 0, nums.length - 1);
    reverse(nums, 0, k - 1);
    reverse(nums, k, nums.length - 1);
}

private void reverse(int[] nums, int start, int end) {
    while (start < end) {
        int temp = nums[start];
        nums[start] = nums[end];
        nums[end] = temp;
        start++;
        end--;
    }
}
```

---

## Advanced Problems (96-100)

### 91. Merge k Sorted Lists
**Problem**: Merge k sorted linked lists
```java
public ListNode mergeKLists(ListNode[] lists) {
    if (lists == null || lists.length == 0) return null;
    
    PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
    
    for (ListNode list : lists) {
        if (list != null) {
            pq.offer(list);
        }
    }
    
    ListNode dummy = new ListNode(0);
    ListNode current = dummy;
    
    while (!pq.isEmpty()) {
        ListNode node = pq.poll();
        current.next = node;
        current = current.next;
        
        if (node.next != null) {
            pq.offer(node.next);
        }
    }
    
    return dummy.next;
}
```

### 97. Trapping Rain Water
**Problem**: Calculate trapped rainwater
```java
public int trap(int[] height) {
    int left = 0, right = height.length - 1;
    int leftMax = 0, rightMax = 0, water = 0;
    
    while (left < right) {
        if (height[left] < height[right]) {
            if (height[left] >= leftMax) {
                leftMax = height[left];
            } else {
                water += leftMax - height[left];
            }
            left++;
        } else {
            if (height[right] >= rightMax) {
                rightMax = height[right];
            } else {
                water += rightMax - height[right];
            }
            right--;
        }
    }
    
    return water;
}
```

### 98. Median of Two Sorted Arrays
**Problem**: Find median of two sorted arrays
```java
public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
        return findMedianSortedArrays(nums2, nums1);
    }
    
    int m = nums1.length, n = nums2.length;
    int left = 0, right = m;
    
    while (left <= right) {
        int partitionX = (left + right) / 2;
        int partitionY = (m + n + 1) / 2 - partitionX;
        
        int maxLeftX = (partitionX == 0) ? Integer.MIN_VALUE : nums1[partitionX - 1];
        int minRightX = (partitionX == m) ? Integer.MAX_VALUE : nums1[partitionX];
        
        int maxLeftY = (partitionY == 0) ? Integer.MIN_VALUE : nums2[partitionY - 1];
        int minRightY = (partitionY == n) ? Integer.MAX_VALUE : nums2[partitionY];
        
        if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
            if ((m + n) % 2 == 0) {
                return (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2.0;
            } else {
                return Math.max(maxLeftX, maxLeftY);
            }
        } else if (maxLeftX > minRightY) {
            right = partitionX - 1;
        } else {
            left = partitionX + 1;
        }
    }
    
    return 0.0;
}
```

### 99. Regular Expression Matching
**Problem**: Implement regex matching
```java
public boolean isMatch(String s, String p) {
    boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
    dp[0][0] = true;
    
    for (int j = 1; j <= p.length(); j++) {
        if (p.charAt(j - 1) == '*') {
            dp[0][j] = dp[0][j - 2];
        }
    }
    
    for (int i = 1; i <= s.length(); i++) {
        for (int j = 1; j <= p.length(); j++) {
            if (p.charAt(j - 1) == '*') {
                dp[i][j] = dp[i][j - 2] || 
                          (matches(s, p, i, j - 1) && dp[i - 1][j]);
            } else {
                dp[i][j] = matches(s, p, i, j) && dp[i - 1][j - 1];
            }
        }
    }
    
    return dp[s.length()][p.length()];
}

private boolean matches(String s, String p, int i, int j) {
    return p.charAt(j - 1) == '.' || s.charAt(i - 1) == p.charAt(j - 1);
}
```

### 100. Longest Valid Parentheses
**Problem**: Find longest valid parentheses substring
```java
public int longestValidParentheses(String s) {
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int maxLen = 0;
    
    for (int i = 0; i < s.length(); i++) {
        if (s.charAt(i) == '(') {
            stack.push(i);
        } else {
            stack.pop();
            if (stack.isEmpty()) {
                stack.push(i);
            } else {
                maxLen = Math.max(maxLen, i - stack.peek());
            }
        }
    }
    
    return maxLen;
}
```

---

## 📊 Complexity Analysis Summary

| Problem Type | Time Complexity | Space Complexity | Key Technique |
|--------------|----------------|------------------|---------------|
| **Two Sum** | O(n) | O(n) | Hash Map |
| **Binary Search** | O(log n) | O(1) | Divide & Conquer |
| **Two Pointers** | O(n) | O(1) | Left/Right Pointers |
| **Sliding Window** | O(n) | O(k) | Dynamic Window |
| **DFS/BFS** | O(V + E) | O(V) | Graph Traversal |
| **Dynamic Programming** | O(n²) | O(n) | Memoization |
| **Backtracking** | O(2ⁿ) | O(n) | State Space Search |

---

## 🎯 Interview Success Tips

### **Pattern Recognition**
1. **Array Problems** → Two Pointers, Sliding Window, Binary Search
2. **String Problems** → Sliding Window, DP, Hash Map
3. **Tree Problems** → DFS, BFS, Recursion
4. **Graph Problems** → DFS, BFS, Union Find
5. **Optimization Problems** → Dynamic Programming, Greedy

### **Time Management**
- **Easy Problems**: 10-15 minutes
- **Medium Problems**: 20-25 minutes  
- **Hard Problems**: 30-35 minutes

### **Communication Strategy**
1. **Clarify Requirements** - Ask about constraints and edge cases
2. **Explain Approach** - Describe algorithm before coding
3. **Code Incrementally** - Start with brute force, then optimize
4. **Test Thoroughly** - Walk through examples and edge cases
5. **Analyze Complexity** - State time and space complexity

---

## 🏆 Company-Specific Focus

### **Google**: Arrays, Trees, Dynamic Programming
**Key Problems**: 1, 15, 31-45, 61-75

### **Facebook/Meta**: Arrays, Strings, Graph Algorithms  
**Key Problems**: 1-20, 46-60, 76-85

### **Amazon**: Arrays, Linked Lists, Trees
**Key Problems**: 1-30, 31-45, 86-95

### **Apple**: Arrays, Math, Bit Manipulation
**Key Problems**: 1-20, 86-100

### **Microsoft**: Arrays, Trees, Dynamic Programming
**Key Problems**: 1-30, 31-45, 61-75

---

## 📚 Additional Resources

- **LeetCode Premium** - Company-specific problems
- **AlgoExpert** - Structured learning path
- **Cracking the Coding Interview** - Interview preparation
- **Elements of Programming Interviews** - Advanced techniques

**Master these 100 problems and you'll be ready for any technical interview! 🚀**