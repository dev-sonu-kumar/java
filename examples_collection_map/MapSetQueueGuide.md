# Java Collections Complete Guide - Maps, Sets & Queues 🚀

## 📚 Learning Path (Recommended Order)

**Start with these fundamentals:**
1. **HashMap** - Most important, used everywhere
2. **LinkedHashMap** - Builds on HashMap concepts
3. **TreeMap** - Introduces sorting concepts
4. **HashSet** - Understand Set operations
5. **TreeSet** - Sorted sets

**Then advanced topics:**
6. **ArrayDeque** - Modern Stack/Queue
7. **PriorityQueue** - Heap-based operations
8. **ConcurrentHashMap** - Thread-safety (advanced)

---

## 1. HashMap

### Definition
Hash table based implementation of Map interface. Uses key-value pairs with no ordering guarantee.

### Internal Implementation
- Array of buckets (Node[] table)
- Default capacity: 16, load factor: 0.75
- Uses hashCode() and equals() for key operations
- Handles collisions with chaining (linked list → red-black tree when > 8 nodes)

### Time Complexity
- **Get/Put/Remove**: O(1) average, O(n) worst case
- **ContainsKey**: O(1) average
- **Iteration**: O(capacity + size)

### Memory Usage
- Moderate overhead (hash table structure)
- Load factor determines space vs time trade-off

### When to Use
- Fast key-based access needed
- No ordering required
- Single-threaded environment
- Most common Map choice

---

## 2. LinkedHashMap

### Definition
HashMap with predictable iteration order. Maintains insertion order or access order.

### Internal Implementation
- Extends HashMap with doubly-linked list
- Each entry has before/after pointers
- Two modes: insertion-order and access-order

### Time Complexity
- **Get/Put/Remove**: O(1) average
- **Iteration**: O(size) - faster than HashMap
- **Ordering maintenance**: O(1)

### Memory Usage
- Higher than HashMap (extra pointers)
- More predictable iteration performance

### When to Use
- Need predictable iteration order
- LRU cache implementation
- Maintaining insertion sequence important

---

## 3. TreeMap

### Definition
Red-black tree based NavigableMap implementation. Keys sorted in natural order or by Comparator.

### Internal Implementation
- Self-balancing binary search tree (Red-Black tree)
- Each node: key, value, color, left, right, parent
- Maintains sorted order automatically

### Time Complexity
- **Get/Put/Remove**: O(log n)
- **FirstKey/LastKey**: O(log n)
- **Range operations**: O(log n + k) where k is result size

### Memory Usage
- Higher overhead (tree node structure)
- No wasted space (exact size)

### When to Use
- Need sorted keys
- Range queries required
- NavigableMap operations needed
- Keys implement Comparable or custom Comparator

---

## 4. ConcurrentHashMap

### Definition
Thread-safe HashMap implementation using segment-based locking and lock-free reads.

### Internal Implementation
- Segmented hash table (Java 7) → CAS + synchronized (Java 8+)
- Lock-free reads, minimal locking for writes
- Uses CAS operations for atomic updates

### Time Complexity
- **Get**: O(1) lock-free
- **Put/Remove**: O(1) average with minimal contention
- **Bulk operations**: Parallel processing

### Memory Usage
- Similar to HashMap with thread-safety overhead
- Additional metadata for concurrency control

### When to Use
- Multi-threaded environment
- High concurrency requirements
- Better than synchronized HashMap
- Lock-free read operations needed

---

## 5. HashSet

### Definition
Set implementation backed by HashMap. No duplicate elements, no ordering guarantee.

### Internal Implementation
- Uses HashMap internally (key = element, value = dummy PRESENT object)
- Inherits HashMap's hash table structure
- Set operations delegate to underlying HashMap

### Time Complexity
- **Add/Remove/Contains**: O(1) average, O(n) worst case
- **Size/IsEmpty**: O(1)
- **Iteration**: O(capacity + size)

### Memory Usage
- Similar to HashMap
- Extra dummy object overhead per element

### When to Use
- Need unique elements only
- Fast membership testing
- No ordering required
- Set operations (union, intersection, difference)

---

## 6. TreeSet

### Definition
NavigableSet implementation based on TreeMap. Elements sorted in natural order or by Comparator.

### Internal Implementation
- Uses TreeMap internally (key = element, value = dummy PRESENT object)
- Red-black tree structure
- Maintains sorted order

### Time Complexity
- **Add/Remove/Contains**: O(log n)
- **First/Last**: O(log n)
- **Range operations**: O(log n + k)

### Memory Usage
- Higher overhead (tree structure)
- No duplicate storage

### When to Use
- Need sorted unique elements
- Range queries on sets
- NavigableSet operations required
- Elements implement Comparable

---

## 7. ArrayDeque

### Definition
Resizable array implementation of Deque interface. Can be used as Stack or Queue.

### Internal Implementation
- Circular array with head and tail pointers
- Grows by doubling when full
- No capacity restrictions

### Time Complexity
- **AddFirst/AddLast**: O(1) amortized
- **RemoveFirst/RemoveLast**: O(1)
- **Get by index**: Not supported
- **Size**: O(1)

### Memory Usage
- Lower overhead than LinkedList
- Some unused capacity (like ArrayList)

### When to Use
- Stack operations (better than Stack class)
- Queue operations (better than LinkedList)
- Deque operations needed
- No null elements allowed

---

## 8. PriorityQueue

### Definition
Heap-based priority queue. Elements ordered by natural ordering or Comparator.

### Internal Implementation
- Binary heap using array representation
- Min-heap by default (smallest element at root)
- Dynamic resizing like ArrayList

### Time Complexity
- **Add**: O(log n)
- **Poll/Remove**: O(log n)
- **Peek**: O(1)
- **Contains**: O(n)

### Memory Usage
- Array-based storage
- Compact representation (no pointers)

### When to Use
- Need elements in priority order
- Heap operations required
- Task scheduling
- Finding min/max efficiently

---

## Performance Comparison Table

| Operation | HashMap | LinkedHashMap | TreeMap | ConcurrentHashMap | HashSet | TreeSet | ArrayDeque | PriorityQueue |
|-----------|---------|---------------|---------|-------------------|---------|---------|------------|---------------|
| Get/Contains | O(1) | O(1) | O(log n) | O(1) | O(1) | O(log n) | N/A | O(n) |
| Put/Add | O(1) | O(1) | O(log n) | O(1) | O(1) | O(log n) | O(1) | O(log n) |
| Remove | O(1) | O(1) | O(log n) | O(1) | O(1) | O(log n) | O(1) | O(log n) |
| Iteration | O(n+k) | O(n) | O(n) | O(n) | O(n+k) | O(n) | O(n) | O(n) |

*k = capacity, n = size*

---

## Memory Usage Comparison

| Collection | Memory Overhead | Thread Safety | Ordering | Null Values |
|------------|----------------|---------------|----------|-------------|
| HashMap | Low | No | None | Allowed |
| LinkedHashMap | Medium | No | Insertion/Access | Allowed |
| TreeMap | High | No | Sorted | Not allowed |
| ConcurrentHashMap | Medium | Yes | None | Not allowed |
| HashSet | Low | No | None | One null allowed |
| TreeSet | High | No | Sorted | Not allowed |
| ArrayDeque | Low | No | FIFO/LIFO | Not allowed |
| PriorityQueue | Low | No | Priority | Not allowed |

---

## Use Case Guidelines

### Choose HashMap when:
- Fast key-value access needed
- No ordering requirements
- Single-threaded or externally synchronized

### Choose LinkedHashMap when:
- Predictable iteration order needed
- LRU cache implementation
- Insertion order matters

### Choose TreeMap when:
- Sorted keys required
- Range operations needed
- NavigableMap functionality required

### Choose ConcurrentHashMap when:
- Multi-threaded environment
- High concurrency needed
- Lock-free reads important

### Choose HashSet when:
- Unique elements only
- Fast membership testing
- Set operations needed

### Choose TreeSet when:
- Sorted unique elements
- Range queries on sets
- NavigableSet operations

### Choose ArrayDeque when:
- Stack/Queue operations
- Better performance than Stack/LinkedList
- Double-ended queue needed

### Choose PriorityQueue when:
- Priority-based processing
- Heap operations
- Min/Max element access

---

## Interview Key Points

### HashMap Internals:
- Load factor 0.75 balances time vs space
- Rehashing occurs when size > capacity * load factor
- Java 8: Linked list → Red-Black tree when bucket size > 8

### ConcurrentHashMap vs Hashtable:
- ConcurrentHashMap: Segment-based locking, better performance
- Hashtable: Full synchronization, legacy

### TreeMap vs HashMap:
- TreeMap: O(log n), sorted, NavigableMap
- HashMap: O(1), unsorted, faster

### ArrayDeque vs LinkedList:
- ArrayDeque: Array-based, better performance, no null
- LinkedList: Node-based, allows null, implements List

---

## Code Examples Summary (Learning Order)

**📁 Study in this sequence:**
1. `_1_HashMapExample.java` - **START HERE** - HashMap operations and Java 8 features
2. `_2_LinkedHashMapExample.java` - Insertion order and LRU cache
3. `_3_TreeMapExample.java` - Sorted maps and NavigableMap operations
4. `_4_HashSetExample.java` - Set operations and uniqueness
5. `_5_TreeSetExample.java` - Sorted sets and NavigableSet
6. `_6_ArrayDequeExample.java` - Stack, Queue, and Deque operations
7. `_7_PriorityQueueExample.java` - Priority-based processing
8. `_8_ConcurrentHashMapExample.java` - **ADVANCED** - Thread-safe operations

---

## Modern Java Best Practices

1. **HashMap** - Default choice for key-value storage
2. **ConcurrentHashMap** - For thread-safe maps
3. **ArrayDeque** - Instead of Stack/LinkedList for queues
4. **EnumSet/EnumMap** - For enum-based collections
5. **Stream API** - For functional operations on collections
6. **Collections.unmodifiable*()** - For immutable views
7. **Map.of(), Set.of()** - For small immutable collections (Java 9+)