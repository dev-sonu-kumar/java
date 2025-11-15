# Java Collections Complete Guide 🚀

## 1. ArrayList

### Definition
Dynamic array that can grow/shrink. Implements List interface with resizable array.

### Internal Implementation
- Uses Object[] array internally
- Default capacity: 10
- Grows by 50% when full: `newCapacity = oldCapacity + (oldCapacity >> 1)`

### Time Complexity
- **Access**: O(1)
- **Insert/Delete at end**: O(1) amortized
- **Insert/Delete at middle**: O(n)
- **Search**: O(n)

### Memory Usage
- Lower overhead (only stores elements)
- Capacity > size (some unused space)

### When to Use
- Frequent random access by index
- More reads than writes
- Single-threaded environment

---

## 2. LinkedList

### Definition
Doubly-linked list where each node contains data and references to next/previous nodes.

### Internal Implementation
- Node structure: `{E item, Node<E> next, Node<E> prev}`
- Maintains first and last node references
- No backing array

### Time Complexity
- **Access**: O(n)
- **Insert/Delete at ends**: O(1)
- **Insert/Delete at middle**: O(n) to find + O(1) to modify
- **Search**: O(n)

### Memory Usage
- Higher overhead (stores extra pointers)
- No wasted space (exact size)

### When to Use
- Frequent insertions/deletions
- Unknown size variations
- Queue/Stack operations
- Deque implementation

---

## 3. Vector

### Definition
Legacy synchronized dynamic array. Thread-safe version of ArrayList.

### Internal Implementation
- Similar to ArrayList with Object[] array
- All methods synchronized
- Default capacity: 10
- Grows by 100% (doubles) when full

### Time Complexity
- **Access**: O(1)
- **Insert/Delete**: Same as ArrayList but with synchronization overhead
- **Search**: O(n)

### Memory Usage
- Similar to ArrayList
- Additional synchronization overhead

### When to Use
- Multi-threaded environment (legacy approach)
- Thread safety required
- **Note**: Use Collections.synchronizedList(ArrayList) or ConcurrentHashMap instead

---

## 4. Stack

### Definition
LIFO (Last In First Out) data structure. Extends Vector class.

### Internal Implementation
- Extends Vector (inherits array-based implementation)
- Adds stack-specific methods on top of Vector

### Time Complexity
- **Push**: O(1)
- **Pop**: O(1)
- **Peek**: O(1)
- **Search**: O(n)

### Memory Usage
- Same as Vector (inherits overhead)

### When to Use
- LIFO operations needed
- Expression evaluation
- Undo operations
- **Note**: Use ArrayDeque instead for better performance

---

## 5. CopyOnWriteArrayList

### Definition
Thread-safe variant where all mutative operations create a fresh copy of underlying array.

### Internal Implementation
- Uses volatile Object[] array
- Write operations create new array copy
- Reads happen on current array without locking

### Time Complexity
- **Read**: O(1)
- **Write**: O(n) - creates full copy
- **Search**: O(n)

### Memory Usage
- High memory usage during writes (temporary double storage)
- Multiple array copies in memory

### When to Use
- Many concurrent readers, few writers
- Iteration more frequent than modification
- Thread safety without external synchronization
- Fail-safe iterators needed

---

## Performance Comparison Table

| Operation | ArrayList | LinkedList | Vector | Stack | CopyOnWriteArrayList |
|-----------|-----------|------------|--------|-------|---------------------|
| Get(i) | O(1) | O(n) | O(1) | O(1) | O(1) |
| Add(end) | O(1)* | O(1) | O(1)* | O(1)* | O(n) |
| Add(middle) | O(n) | O(n) | O(n) | O(n) | O(n) |
| Remove(end) | O(1) | O(1) | O(1) | O(1) | O(n) |
| Remove(middle) | O(n) | O(n) | O(n) | O(n) | O(n) |
| Contains | O(n) | O(n) | O(n) | O(n) | O(n) |

*Amortized time complexity

---

## Memory Usage Comparison

| Collection | Memory Overhead | Thread Safety | Capacity Management |
|------------|----------------|---------------|-------------------|
| ArrayList | Low | No | 50% growth |
| LinkedList | High (pointers) | No | Exact size |
| Vector | Low | Yes (synchronized) | 100% growth |
| Stack | Low | Yes (extends Vector) | 100% growth |
| CopyOnWriteArrayList | Very High | Yes (copy-on-write) | Dynamic copying |

---

## Best Practices & Recommendations

### Use ArrayList when:
- Random access needed
- More reads than writes
- Single-threaded or externally synchronized

### Use LinkedList when:
- Frequent insertions/deletions at arbitrary positions
- Size varies significantly
- Implementing Queue/Deque

### Use Vector when:
- Legacy code compatibility required
- **Better alternative**: Collections.synchronizedList(new ArrayList<>())

### Use Stack when:
- LIFO operations needed
- **Better alternative**: ArrayDeque (faster, not synchronized)

### Use CopyOnWriteArrayList when:
- High read-to-write ratio
- Thread safety without blocking reads
- Fail-safe iteration required

---

## Code Examples Summary

**📁 Study in this sequence:**
1. `_1_ArrayListExample.java` - **START HERE** - Basic ArrayList operations
2. `_2_LinkedListExample.java` - LinkedList with Queue/Stack usage
3. `_3_VectorExample.java` - Vector with thread-safe operations
4. `_4_StackExample.java` - Stack LIFO operations
5. `_5_CopyOnWriteArrayListExample.java` - Thread-safe concurrent access
6. `_6_ComparatorExample.java` - Sorting with different approaches
7. `_7_PersonComparatorExample.java` - Custom object sorting

---

## Modern Java Recommendations

1. **ArrayList** - Default choice for most scenarios
2. **ArrayDeque** - Instead of Stack/LinkedList for Queue operations
3. **ConcurrentHashMap** - Instead of Vector for thread-safe maps
4. **Collections.synchronizedList()** - Instead of Vector for thread-safe lists
5. **Stream API** - For functional-style operations on collections