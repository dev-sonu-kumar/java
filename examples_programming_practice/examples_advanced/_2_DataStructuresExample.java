/*
 * PROGRAM OBJECTIVE:
 * This program demonstrates implementation of basic data structures:
 * 1. Stack implementation using array
 * 2. Queue implementation using array
 * 3. Linked List implementation
 * 4. Binary Search Tree (BST) implementation
 * 5. Hash Table with collision handling
 * 6. Graph representation and traversal
 */

import java.util.*;

public class _2_DataStructuresExample {
    public static void main(String[] args) {
        System.out.println("=== Data Structures Implementation ===");
        
        // 1. Stack operations
        System.out.println("\n1. Stack Operations:");
        demonstrateStack();
        
        // 2. Queue operations
        System.out.println("\n2. Queue Operations:");
        demonstrateQueue();
        
        // 3. Linked List operations
        System.out.println("\n3. Linked List Operations:");
        demonstrateLinkedList();
        
        // 4. Binary Search Tree
        System.out.println("\n4. Binary Search Tree:");
        demonstrateBST();
        
        // 5. Hash Table
        System.out.println("\n5. Hash Table:");
        demonstrateHashTable();
        
        // 6. Graph operations
        System.out.println("\n6. Graph Operations:");
        demonstrateGraph();
    }
    
    public static void demonstrateStack() {
        MyStack stack = new MyStack(5);
        
        stack.push(10);
        stack.push(20);
        stack.push(30);
        
        System.out.println("Stack size: " + stack.size());
        System.out.println("Top element: " + stack.peek());
        System.out.println("Popped: " + stack.pop());
        System.out.println("Stack after pop: " + stack);
    }
    
    public static void demonstrateQueue() {
        MyQueue queue = new MyQueue(5);
        
        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);
        
        System.out.println("Queue size: " + queue.size());
        System.out.println("Front element: " + queue.front());
        System.out.println("Dequeued: " + queue.dequeue());
        System.out.println("Queue after dequeue: " + queue);
    }
    
    public static void demonstrateLinkedList() {
        MyLinkedList list = new MyLinkedList();
        
        list.add(10);
        list.add(20);
        list.add(30);
        list.addFirst(5);
        
        System.out.println("List: " + list);
        System.out.println("Size: " + list.size());
        System.out.println("Contains 20: " + list.contains(20));
        list.remove(20);
        System.out.println("After removing 20: " + list);
    }
    
    public static void demonstrateBST() {
        BinarySearchTree bst = new BinarySearchTree();
        
        int[] values = {50, 30, 70, 20, 40, 60, 80};
        for (int value : values) {
            bst.insert(value);
        }
        
        System.out.println("BST Inorder traversal:");
        bst.inorderTraversal();
        System.out.println();
        
        System.out.println("Search 40: " + bst.search(40));
        System.out.println("Search 90: " + bst.search(90));
        
        bst.delete(30);
        System.out.println("After deleting 30:");
        bst.inorderTraversal();
        System.out.println();
    }
    
    public static void demonstrateHashTable() {
        MyHashTable hashTable = new MyHashTable(7);
        
        hashTable.put("apple", 5);
        hashTable.put("banana", 3);
        hashTable.put("orange", 8);
        hashTable.put("grape", 12);
        
        System.out.println("Hash table contents:");
        hashTable.display();
        
        System.out.println("Get 'banana': " + hashTable.get("banana"));
        System.out.println("Get 'mango': " + hashTable.get("mango"));
        
        hashTable.remove("orange");
        System.out.println("After removing 'orange':");
        hashTable.display();
    }
    
    public static void demonstrateGraph() {
        MyGraph graph = new MyGraph(5);
        
        graph.addEdge(0, 1);
        graph.addEdge(0, 4);
        graph.addEdge(1, 2);
        graph.addEdge(1, 3);
        graph.addEdge(1, 4);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        
        System.out.println("Graph adjacency list:");
        graph.printGraph();
        
        System.out.println("BFS from vertex 0:");
        graph.BFS(0);
        
        System.out.println("DFS from vertex 0:");
        graph.DFS(0);
    }
}

// Stack implementation using array
class MyStack {
    private int[] arr;
    private int top;
    private int capacity;
    
    public MyStack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }
    
    public void push(int item) {
        if (top == capacity - 1) {
            throw new RuntimeException("Stack overflow");
        }
        arr[++top] = item;
    }
    
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Stack underflow");
        }
        return arr[top--];
    }
    
    public int peek() {
        if (isEmpty()) {
            throw new RuntimeException("Stack is empty");
        }
        return arr[top];
    }
    
    public boolean isEmpty() {
        return top == -1;
    }
    
    public int size() {
        return top + 1;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= top; i++) {
            sb.append(arr[i]);
            if (i < top) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

// Queue implementation using array
class MyQueue {
    private int[] arr;
    private int front, rear, size, capacity;
    
    public MyQueue(int capacity) {
        this.capacity = capacity;
        arr = new int[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }
    
    public void enqueue(int item) {
        if (size == capacity) {
            throw new RuntimeException("Queue overflow");
        }
        rear = (rear + 1) % capacity;
        arr[rear] = item;
        size++;
    }
    
    public int dequeue() {
        if (isEmpty()) {
            throw new RuntimeException("Queue underflow");
        }
        int item = arr[front];
        front = (front + 1) % capacity;
        size--;
        return item;
    }
    
    public int front() {
        if (isEmpty()) {
            throw new RuntimeException("Queue is empty");
        }
        return arr[front];
    }
    
    public boolean isEmpty() {
        return size == 0;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < size; i++) {
            sb.append(arr[(front + i) % capacity]);
            if (i < size - 1) sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }
}

// Linked List implementation
class MyLinkedList {
    private Node head;
    private int size;
    
    private class Node {
        int data;
        Node next;
        
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    
    public void add(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }
    
    public void addFirst(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }
    
    public boolean remove(int data) {
        if (head == null) return false;
        
        if (head.data == data) {
            head = head.next;
            size--;
            return true;
        }
        
        Node current = head;
        while (current.next != null && current.next.data != data) {
            current = current.next;
        }
        
        if (current.next != null) {
            current.next = current.next.next;
            size--;
            return true;
        }
        return false;
    }
    
    public boolean contains(int data) {
        Node current = head;
        while (current != null) {
            if (current.data == data) {
                return true;
            }
            current = current.next;
        }
        return false;
    }
    
    public int size() {
        return size;
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Node current = head;
        while (current != null) {
            sb.append(current.data);
            if (current.next != null) sb.append(", ");
            current = current.next;
        }
        sb.append("]");
        return sb.toString();
    }
}

// Binary Search Tree implementation
class BinarySearchTree {
    private TreeNode root;
    
    private class TreeNode {
        int data;
        TreeNode left, right;
        
        TreeNode(int data) {
            this.data = data;
            left = right = null;
        }
    }
    
    public void insert(int data) {
        root = insertRec(root, data);
    }
    
    private TreeNode insertRec(TreeNode root, int data) {
        if (root == null) {
            return new TreeNode(data);
        }
        
        if (data < root.data) {
            root.left = insertRec(root.left, data);
        } else if (data > root.data) {
            root.right = insertRec(root.right, data);
        }
        
        return root;
    }
    
    public boolean search(int data) {
        return searchRec(root, data);
    }
    
    private boolean searchRec(TreeNode root, int data) {
        if (root == null) return false;
        if (root.data == data) return true;
        
        return data < root.data ? searchRec(root.left, data) : searchRec(root.right, data);
    }
    
    public void delete(int data) {
        root = deleteRec(root, data);
    }
    
    private TreeNode deleteRec(TreeNode root, int data) {
        if (root == null) return root;
        
        if (data < root.data) {
            root.left = deleteRec(root.left, data);
        } else if (data > root.data) {
            root.right = deleteRec(root.right, data);
        } else {
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;
            
            root.data = minValue(root.right);
            root.right = deleteRec(root.right, root.data);
        }
        return root;
    }
    
    private int minValue(TreeNode root) {
        int minValue = root.data;
        while (root.left != null) {
            minValue = root.left.data;
            root = root.left;
        }
        return minValue;
    }
    
    public void inorderTraversal() {
        inorderRec(root);
    }
    
    private void inorderRec(TreeNode root) {
        if (root != null) {
            inorderRec(root.left);
            System.out.print(root.data + " ");
            inorderRec(root.right);
        }
    }
}

// Hash Table with chaining for collision resolution
class MyHashTable {
    private LinkedList<Entry>[] table;
    private int capacity;
    
    private class Entry {
        String key;
        int value;
        
        Entry(String key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    
    @SuppressWarnings("unchecked")
    public MyHashTable(int capacity) {
        this.capacity = capacity;
        table = new LinkedList[capacity];
        for (int i = 0; i < capacity; i++) {
            table[i] = new LinkedList<>();
        }
    }
    
    private int hash(String key) {
        return Math.abs(key.hashCode()) % capacity;
    }
    
    public void put(String key, int value) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        
        bucket.add(new Entry(key, value));
    }
    
    public Integer get(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        for (Entry entry : bucket) {
            if (entry.key.equals(key)) {
                return entry.value;
            }
        }
        return null;
    }
    
    public boolean remove(String key) {
        int index = hash(key);
        LinkedList<Entry> bucket = table[index];
        
        Iterator<Entry> iterator = bucket.iterator();
        while (iterator.hasNext()) {
            Entry entry = iterator.next();
            if (entry.key.equals(key)) {
                iterator.remove();
                return true;
            }
        }
        return false;
    }
    
    public void display() {
        for (int i = 0; i < capacity; i++) {
            if (!table[i].isEmpty()) {
                System.out.print("Bucket " + i + ": ");
                for (Entry entry : table[i]) {
                    System.out.print("[" + entry.key + ":" + entry.value + "] ");
                }
                System.out.println();
            }
        }
    }
}

// Graph implementation using adjacency list
class MyGraph {
    private int vertices;
    private LinkedList<Integer>[] adjList;
    
    @SuppressWarnings("unchecked")
    public MyGraph(int vertices) {
        this.vertices = vertices;
        adjList = new LinkedList[vertices];
        for (int i = 0; i < vertices; i++) {
            adjList[i] = new LinkedList<>();
        }
    }
    
    public void addEdge(int src, int dest) {
        adjList[src].add(dest);
        adjList[dest].add(src); // For undirected graph
    }
    
    public void printGraph() {
        for (int i = 0; i < vertices; i++) {
            System.out.print("Vertex " + i + ": ");
            for (Integer vertex : adjList[i]) {
                System.out.print(vertex + " ");
            }
            System.out.println();
        }
    }
    
    public void BFS(int start) {
        boolean[] visited = new boolean[vertices];
        Queue<Integer> queue = new LinkedList<>();
        
        visited[start] = true;
        queue.add(start);
        
        while (!queue.isEmpty()) {
            int vertex = queue.poll();
            System.out.print(vertex + " ");
            
            for (Integer adjacent : adjList[vertex]) {
                if (!visited[adjacent]) {
                    visited[adjacent] = true;
                    queue.add(adjacent);
                }
            }
        }
        System.out.println();
    }
    
    public void DFS(int start) {
        boolean[] visited = new boolean[vertices];
        DFSUtil(start, visited);
        System.out.println();
    }
    
    private void DFSUtil(int vertex, boolean[] visited) {
        visited[vertex] = true;
        System.out.print(vertex + " ");
        
        for (Integer adjacent : adjList[vertex]) {
            if (!visited[adjacent]) {
                DFSUtil(adjacent, visited);
            }
        }
    }
}