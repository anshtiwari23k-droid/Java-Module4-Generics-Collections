# Module 4 Assignment – Generics & Collection Framework

**Name:** Ansh Tiwari  **Roll No:** 36

Theory answers for every question. Coding questions point to their program in `src/`; the output of every program is in `outputs/`.

## Generics

### Q1. What is the purpose of generics in Java, and how do they improve type safety and code reusability?

Generics (added in Java 5) let classes, interfaces and methods take **types as parameters**, e.g. `List<String>` or `Box<T>`.

- **Type safety:** the compiler checks the type of every element you put in. Adding an `Integer` to a `List<String>` is a compile-time error, so `ClassCastException`s at runtime are avoided.
- **No explicit casts:** `String s = list.get(0);` works directly; before generics you had to write `(String) list.get(0)`.
- **Code reusability:** one class such as `Box<T>` or `Stack<T>` works for `Integer`, `String`, `Student`, etc. You write and test the logic once.
- **Generic algorithms:** methods like `Collections.sort(List<T>)` work on any comparable type.
- Generics are implemented by **type erasure**: type information is checked at compile time and removed in the bytecode, so there is no runtime cost.

### Q2. Explain the syntax for creating a user-defined generic class in Java. Provide an example.

The type parameter is written in angle brackets after the class name: `class ClassName<T1, T2, ...> { ... }`. Inside the class, `T` is used like any other type (fields, parameters, return types). When an object is created the real type is supplied: `ClassName<String> obj = new ClassName<>();` (the `<>` diamond lets the compiler infer it).

```java
class Container<T> {
    private T value;
    Container(T value) { this.value = value; }
    T getValue() { return value; }
    void setValue(T value) { this.value = value; }
}
Container<String> name = new Container<>("Ansh");
Container<Integer> roll = new Container<>(36);
```

Common naming conventions: `T` – Type, `E` – Element, `K` – Key, `V` – Value, `N` – Number.

Program: src/generics/Q02_GenericClassSyntax.java

### Q3. How do bounded type parameters work in generics? Write a generic class that accepts only subclasses of Number.

A bounded type parameter restricts which types can be used. `<T extends Number>` (upper bound) means T must be `Number` or a subclass of it (`Integer`, `Double`, `Long` ...). Because the compiler knows T is a `Number`, the methods of `Number` such as `doubleValue()` can be called on T. Multiple bounds are written as `<T extends Number & Comparable<T>>` (class first, then interfaces). Trying `NumberBox<String>` gives a compile-time error.

Program: src/generics/Q03_BoundedType.java

### Q4. What is the difference between ? extends T and ? super T in generics? Provide an example of when to use each.

| | `? extends T` (upper bounded) | `? super T` (lower bounded) |
|---|---|---|
| Accepts | T or any **subclass** of T | T or any **superclass** of T |
| Reading | Safe – elements can be read as T | Elements can only be read as `Object` |
| Writing | Not allowed (except `null`) | Safe – T (and its subclasses) can be added |
| Role | **Producer** – the collection gives you data | **Consumer** – the collection receives data |

Rule of thumb – **PECS: Producer Extends, Consumer Super.**

- Use `? extends Number` for a method that only reads, e.g. `double sumOf(List<? extends Number> list)` works with `List<Integer>` and `List<Double>`.
- Use `? super Integer` for a method that only writes, e.g. `void addNumbers(List<? super Integer> list)` works with `List<Integer>`, `List<Number>` and `List<Object>`.
- `Collections.copy(List<? super T> dest, List<? extends T> src)` uses both.

Program: src/generics/Q04_WildcardsExtendsSuper.java

### Q5. How do raw types differ from parameterized types in generics, and why should raw types be avoided?

A **raw type** is a generic class used without a type argument, e.g. `List list = new ArrayList();`. A **parameterized type** supplies the argument, e.g. `List<String> list = new ArrayList<>();`.

- With a raw type the compiler cannot check element types, so any object can be added and errors show up only at **runtime** as `ClassCastException`.
- Raw types need explicit casts when reading and produce "unchecked" compiler warnings.
- They exist only for backward compatibility with pre-Java-5 code.
- Parameterized types give compile-time checking, no casts and self-documenting code, so raw types should be avoided in new code.

Program: src/generics/Q05_RawVsParameterized.java

### Q6. Write a generic class Pair<K, V> that holds two values of any types, K and V. Include methods to get and set the values.

Program: src/generics/Q06_Pair.java

### Q7. Create a user-defined generic class Box<T> with methods addItem(T item) and getItem(). Demonstrate its usage with String and Integer types.

Program: src/generics/Q07_Box.java

### Q8. Write a generic method swapElements that swaps two elements in an array. Demonstrate its usage with different data types.

Program: src/generics/Q08_SwapElements.java

### Q9. Develop a user-defined generic class Stack<T> that provides standard stack operations like push(T item), pop(), and peek(). Demonstrate with integers and strings.

Program: src/generics/Q09_GenericStack.java

### Q10. Implement a generic class MinMaxFinder<T extends Comparable<T>> that provides methods findMin() and findMax() to find the minimum and maximum elements in a list. Demonstrate it with a list of integers and strings.

Program: src/generics/Q10_MinMaxFinder.java

## Java.util Package and Collection Framework

### Q1. What is the java.util package, and why is it essential in Java programming?

`java.util` is a core package of the Java standard library that contains utility classes used in almost every program:

- **Collection Framework** – `List`, `Set`, `Queue`, `Map` and their implementations (`ArrayList`, `HashSet`, `HashMap`, `PriorityQueue` ...).
- **Utility classes** – `Collections`, `Arrays`, `Objects`, `Optional`.
- **Date/time & locale (legacy)** – `Date`, `Calendar`, `TimeZone`, `Locale`.
- **Others** – `Scanner` (input), `Random`, `UUID`, `StringTokenizer`, `Iterator`, `Comparator`, `Properties`, `Timer`.
- Sub-packages: `java.util.concurrent` (thread-safe collections, executors), `java.util.function`, `java.util.stream`, `java.util.regex`.

It is essential because it provides ready-made, tested and optimised data structures and algorithms, so developers do not have to write them from scratch.

### Q2. What are the key features of the Collection Framework in java.util?

- **Unified architecture** – common interfaces (`Collection`, `List`, `Set`, `Queue`, `Deque`, `Map`) with many implementations.
- **Ready-made data structures** – dynamic arrays, linked lists, hash tables, trees, heaps.
- **Algorithms** – sorting, searching, shuffling, reversing via the `Collections` class.
- **Dynamic size** – collections grow and shrink automatically.
- **Generics support** – type-safe collections.
- **Iterators** – uniform way to traverse any collection (`Iterator`, `ListIterator`, for-each).
- **Interoperability** – any collection can be passed where its interface is expected, and converted to another (e.g. `new ArrayList<>(set)`).
- **Thread-safe options** – `Collections.synchronizedXxx()` and `java.util.concurrent` classes.
- **Streams & lambdas** (Java 8+) – `stream()`, `forEach`, `removeIf`.

### Q3. Explain the differences between Collection and Collections in java.util.

| `Collection` | `Collections` |
|---|---|
| An **interface** – root of the collection hierarchy | A **utility class** (final, private constructor) |
| Represents a group of objects | Contains only **static methods** that operate on collections |
| Extended by `List`, `Set`, `Queue` | Methods: `sort()`, `shuffle()`, `reverse()`, `max()`, `min()`, `binarySearch()`, `frequency()`, `unmodifiableList()`, `synchronizedList()` |
| Declares methods such as `add()`, `remove()`, `size()`, `contains()`, `iterator()` | Used as `Collections.sort(list)` |

### Q4. What is the role of the Iterator interface in the java.util package?

`Iterator<E>` provides a uniform way to traverse the elements of any collection, one at a time, without knowing its internal structure.

- `hasNext()` – returns true if more elements remain.
- `next()` – returns the next element.
- `remove()` – safely removes the last element returned (the only safe way to remove while iterating; otherwise a `ConcurrentModificationException` is thrown).
- `forEachRemaining(action)` – Java 8 method.

Every collection returns one through `iterator()`. `ListIterator` extends it with bidirectional traversal (`hasPrevious()`, `previous()`), `set()` and `add()`.

### Q5. What is the purpose of the Comparator and Comparable interfaces in the java.util package?

Both define how objects are **ordered** (used by `Collections.sort`, `TreeSet`, `TreeMap`, `PriorityQueue`).

| `Comparable<T>` (java.lang) | `Comparator<T>` (java.util) |
|---|---|
| Defines the **natural ordering** of a class | Defines a **custom / external ordering** |
| Implemented by the class itself | Implemented in a separate class, lambda or anonymous class |
| Method: `int compareTo(T o)` | Method: `int compare(T a, T b)` |
| Only one ordering per class | Any number of orderings (by name, by marks ...) |
| e.g. `String`, `Integer` implement it | e.g. `Comparator.comparing(Student::getName).reversed()` |

Both return a negative number, zero or a positive number for less than, equal to and greater than.

### Q6. What are the key interfaces in the Java Collection Framework, and how are they related?

- `Iterable<T>` – root; anything that can be used in a for-each loop.
- `Collection<E>` extends `Iterable` – basic operations for a group of elements.
  - `List<E>` – ordered, index-based, allows duplicates (`ArrayList`, `LinkedList`, `Vector`, `Stack`).
  - `Set<E>` – no duplicates (`HashSet`, `LinkedHashSet`).
    - `SortedSet<E>` → `NavigableSet<E>` – sorted set (`TreeSet`).
  - `Queue<E>` – elements held for processing, usually FIFO (`LinkedList`, `PriorityQueue`).
    - `Deque<E>` – double-ended queue (`ArrayDeque`, `LinkedList`).
- `Map<K,V>` – key–value pairs; **not** a sub-interface of `Collection` (`HashMap`, `LinkedHashMap`, `Hashtable`).
  - `SortedMap<K,V>` → `NavigableMap<K,V>` – sorted by key (`TreeMap`).
- Supporting interfaces: `Iterator`, `ListIterator`, `Comparable`, `Comparator`.

```
Iterable
   └── Collection
         ├── List   (ArrayList, LinkedList, Vector → Stack)
         ├── Set    (HashSet → LinkedHashSet)
         │     └── SortedSet → NavigableSet (TreeSet)
         └── Queue  (PriorityQueue)
               └── Deque (ArrayDeque, LinkedList)
Map (HashMap → LinkedHashMap, Hashtable, WeakHashMap)
   └── SortedMap → NavigableMap (TreeMap)
```

### Q7. What is the difference between Collection and Map interfaces in Java?

| `Collection` | `Map` |
|---|---|
| Stores **individual elements** | Stores **key–value pairs** (entries) |
| Extends `Iterable`, can be used directly in for-each | Does not extend `Collection` or `Iterable` |
| `add(e)`, `remove(e)`, `contains(e)` | `put(k, v)`, `get(k)`, `remove(k)`, `containsKey(k)` |
| Duplicates depend on type (List yes, Set no) | Keys are unique; values can repeat |
| Iterated directly | Iterated through views: `keySet()`, `values()`, `entrySet()` |
| e.g. `ArrayList`, `HashSet` | e.g. `HashMap`, `TreeMap` |

### Q8. Explain the differences between Set, List, and Queue in the Collection Framework.

| Feature | List | Set | Queue |
|---|---|---|---|
| Order | Insertion order kept | No order (`HashSet`), insertion (`LinkedHashSet`) or sorted (`TreeSet`) | FIFO (or priority order in `PriorityQueue`) |
| Duplicates | Allowed | Not allowed | Allowed |
| Index access | Yes – `get(i)`, `set(i, e)` | No | No – only head |
| Null | Allowed | One null (`HashSet`); not in `TreeSet` | Mostly not allowed |
| Key methods | `add`, `get`, `set`, `remove(i)` | `add`, `contains`, `remove` | `offer`, `poll`, `peek` |
| Use case | Ordered list of items | Unique items | Tasks waiting to be processed |

### Q9. What is the significance of the Iterable interface, and how is it used in the Collection Framework?

`java.lang.Iterable<T>` is the top-level interface of the framework. It has one abstract method, `Iterator<T> iterator()`, plus the default methods `forEach(Consumer)` and `spliterator()`.

- Any class implementing `Iterable` can be used in the **enhanced for loop** (`for (T x : obj)`); the compiler turns the loop into `iterator()`, `hasNext()` and `next()` calls.
- `Collection` extends `Iterable`, so every `List`, `Set` and `Queue` is iterable.
- User-defined classes can implement `Iterable` to become usable in for-each loops.

### Q10. What are the benefits of using the Collection Framework over arrays?

| Arrays | Collection Framework |
|---|---|
| Fixed size, set at creation | Dynamic size – grows/shrinks automatically |
| Only basic operations (index access) | Rich API: add, remove, contains, sort, search |
| No built-in data structures beyond the array | Lists, sets, queues, maps, trees, heaps |
| Duplicates and order must be handled manually | Sets remove duplicates, TreeSet/TreeMap keep sorted order |
| Holds primitives and objects | Holds objects only (autoboxing handles primitives) |
| Insert/delete in middle needs manual shifting | Handled by `add(i, e)` / `remove(i)` |

Other benefits: less code, better performance through optimised implementations, interoperability through common interfaces, generics for type safety, and thread-safe variants.

### Q11. Write a program to iterate over a List of integers using (a) a simple for loop, (b) an enhanced for loop, (c) a while loop with an Iterator.

Program: src/collectionframework/Q11_IterateList.java

### Q12. Write a generic method to print all elements of any Collection (e.g., List, Set, Queue).

Program: src/collectionframework/Q12_PrintAnyCollection.java

## List Interface

### Q1. What is the List interface, and how does it differ from the Set interface?

`List<E>` is an ordered collection (sequence) in which every element has an index. It allows duplicates and multiple nulls and supports positional access: `get(i)`, `set(i, e)`, `add(i, e)`, `remove(i)`, `indexOf(e)`, `subList()`, `listIterator()`. Implementations: `ArrayList`, `LinkedList`, `Vector`, `Stack`.

| List | Set |
|---|---|
| Ordered (insertion order) | Usually unordered (except `LinkedHashSet`, `TreeSet`) |
| Duplicates allowed | Duplicates not allowed |
| Index-based access | No index |
| Many nulls allowed | At most one null |
| `ListIterator` (both directions) | Only `Iterator` |

### Q2. What is the difference between ArrayList and LinkedList in terms of performance and usage?

| Operation / aspect | ArrayList | LinkedList |
|---|---|---|
| Internal structure | Resizable array | Doubly linked list |
| `get(i)` / `set(i)` | O(1) – fast | O(n) – must traverse |
| Add at end | Amortised O(1) | O(1) |
| Add/remove at beginning | O(n) – shifts elements | O(1) |
| Add/remove in middle | O(n) shift | O(n) to find + O(1) to link |
| Memory | Less (only the data) | More (two extra references per node) |
| Implements | `List`, `RandomAccess` | `List`, `Deque` |
| Best for | Frequent reads / random access | Frequent insert/remove at the ends, queue/deque use |

### Q3. Write a program to demonstrate the use of ArrayList for storing and iterating over elements.

Program: src/list/Q03_ArrayListDemo.java

### Q4. What is the role of the Vector class, and how does it differ from ArrayList?

`Vector` is a legacy (Java 1.0) resizable array that implements `List`. All its methods are **synchronized**, so it is thread-safe.

| Vector | ArrayList |
|---|---|
| Synchronized – thread-safe | Not synchronized |
| Slower due to locking | Faster in single-threaded code |
| Grows by 100% (doubles) when full | Grows by 50% |
| Legacy class; also has `Enumeration` | Part of the Collection Framework (Java 1.2) |
| Iterator and `Enumeration` | Only `Iterator` / `ListIterator` |

Today `ArrayList` (with `Collections.synchronizedList()` or `CopyOnWriteArrayList` when thread safety is needed) is preferred.

### Q5. How is the Stack class implemented, and how does it relate to the List interface?

`java.util.Stack<E>` is a LIFO (last-in, first-out) structure that **extends `Vector`**. Internally it stores elements in Vector's array; the top of the stack is the end of the array. It adds the methods `push(e)`, `pop()`, `peek()`, `empty()` and `search(o)`.

Because `Stack extends Vector` and `Vector implements List`, a `Stack` **is a `List`**: index methods like `get(i)` and `add(i, e)` work on it too (which breaks pure stack behaviour). Its methods are synchronized like Vector's. For new code, `Deque<E> stack = new ArrayDeque<>()` is recommended instead.

Program: src/list/Q05_StackClassDemo.java

### Q6. Create a List of strings and perform the following operations: (a) add elements, (b) remove an element by value and index, (c) replace an element at a specific index, (d) print the list after each operation.

Program: src/list/Q06_ListOperations.java

### Q7. Write a program to compare the performance of ArrayList and LinkedList for (a) adding elements at the beginning, (b) removing elements from the middle, (c) iterating through the list.

Program: src/list/Q07_ArrayListVsLinkedList.java

### Q8. Write a program to sort an ArrayList of strings alphabetically and reverse alphabetically.

Program: src/list/Q08_SortStrings.java

## Set Interface

### Q1. What is the Set interface, and how is it different from List?

`Set<E>` is a collection that **does not allow duplicate elements** (it models the mathematical set). It has no index-based methods. Implementations: `HashSet` (no order), `LinkedHashSet` (insertion order), `TreeSet` (sorted). `add()` returns `false` if the element is already present.

Differences from List: no duplicates (List allows), no index access (List has `get(i)`), order not guaranteed (List keeps insertion order), and at most one null.

### Q2. What is the difference between HashSet, LinkedHashSet, and TreeSet in Java?

| | HashSet | LinkedHashSet | TreeSet |
|---|---|---|---|
| Internal structure | Hash table (backed by `HashMap`) | Hash table + doubly linked list | Red-black tree (backed by `TreeMap`) |
| Order | No guaranteed order | Insertion order | Sorted (natural or `Comparator`) |
| add / remove / contains | O(1) | O(1) (slightly slower) | O(log n) |
| Null | One null allowed | One null allowed | Not allowed |
| Extra methods | – | – | `first()`, `last()`, `floor()`, `ceiling()`, `headSet()`, `tailSet()` |
| Use when | Fast lookups, order not needed | Unique items in insertion order | Unique items in sorted order |

### Q3. Write a program to demonstrate the use of TreeSet for storing sorted elements.

Program: src/set/Q03_TreeSetSorted.java

### Q4. How does HashSet handle duplicate elements? Explain with an example.

`HashSet` is backed by a `HashMap`; each element is stored as a key (with a dummy value). When `add(e)` is called:

1. `e.hashCode()` is computed to find the bucket.
2. If the bucket already has elements, each one is compared with `e.equals()`.
3. If an equal element is found, the element is **not added** and `add()` returns `false`; otherwise it is stored and `add()` returns `true`.

Example: `set.add("Java")` → true, `set.add("Python")` → true, `set.add("Java")` → false; the set contains only `[Java, Python]`. For user-defined classes this works only if `equals()` and `hashCode()` are overridden (see the program).

Program: src/set/Q04_HashSetDuplicates.java

### Q5. What is the significance of equals() and hashCode() methods in HashSet?

- `hashCode()` decides **which bucket** an object goes into; `equals()` decides whether two objects in the same bucket are **the same element**.
- Contract: if `a.equals(b)` is true, then `a.hashCode() == b.hashCode()` must also be true (equal hash codes do not imply equal objects – that is a collision).
- If a class does not override them, `Object`'s versions compare memory addresses, so two `Student(36, "Ansh")` objects are treated as different and both get stored – duplicates appear.
- Overriding only `equals()` is also wrong: equal objects may land in different buckets and never be compared.
- Fields used in `hashCode()` should not change after the object is added, or the object becomes unreachable in the set.

The program for Q4 shows size 2 without the overrides and size 1 with them.

### Q6. Write a program to demonstrate the uniqueness property of HashSet by attempting to add duplicate elements.

Program: src/set/Q06_HashSetUniqueness.java

### Q7. Create a TreeSet of integers and perform the following operations: (a) add elements, (b) find the smallest and largest elements, (c) remove a specific element.

Program: src/set/Q07_TreeSetOperations.java

### Q8. Write a program to iterate over a LinkedHashSet and explain its order-preserving property.

`LinkedHashSet` extends `HashSet` but its entries are also linked in a **doubly linked list** in the order they were inserted. Iteration follows this list, so elements come out in insertion order. Re-inserting an existing element does not change its position. It still has O(1) add/contains and no duplicates.

Program: src/set/Q08_LinkedHashSetOrder.java

## Map Interface

### Q1. What is the Map interface in Java, and how is it different from Collection?

`Map<K, V>` stores **key–value pairs**. Each key is unique and maps to at most one value; values may repeat. Main methods: `put`, `get`, `remove`, `containsKey`, `containsValue`, `getOrDefault`, `putIfAbsent`, `keySet()`, `values()`, `entrySet()`. Implementations: `HashMap`, `LinkedHashMap`, `TreeMap`, `Hashtable`, `WeakHashMap`, `ConcurrentHashMap`.

It differs from `Collection` because it is not part of the `Collection` hierarchy and does not extend `Iterable`; it holds pairs instead of single elements, uses `put`/`get` by key instead of `add`, and is iterated through its key, value or entry views.

### Q2. What is the difference between HashMap, LinkedHashMap, and TreeMap?

| | HashMap | LinkedHashMap | TreeMap |
|---|---|---|---|
| Structure | Hash table (array of buckets) | Hash table + doubly linked list | Red-black tree |
| Order | No order | Insertion order (or access order) | Sorted by key |
| get/put | O(1) average | O(1) average | O(log n) |
| Null key | One allowed | One allowed | Not allowed (with natural ordering) |
| Extra features | – | `removeEldestEntry()` for LRU caches | `firstKey()`, `lastKey()`, `headMap()`, `tailMap()`, `floorKey()` |

### Q3. How does HashMap handle collisions?

A collision happens when two different keys map to the same bucket index (`index = hash(key) & (n - 1)`).

1. **Chaining** – each bucket stores a linked list of nodes (key, value, hash, next). A colliding entry is appended to the list. `get()` goes to the bucket and uses `equals()` to find the right key.
2. **Treeification (Java 8+)** – when one bucket holds more than 8 entries (and the table has at least 64 buckets), the list is converted to a **red-black tree**, so the worst-case lookup becomes O(log n) instead of O(n). It turns back into a list when it shrinks below 6.
3. **Hash spreading** – `hash()` XORs the high 16 bits into the low bits (`h ^ (h >>> 16)`) to spread keys more evenly.
4. **Resizing** – when size exceeds capacity × load factor (default 16 × 0.75 = 12), the table doubles and entries are redistributed, which shortens chains.

### Q4. Write a program to demonstrate the use of TreeMap for sorting keys.

Program: src/map/Q04_TreeMapSortKeys.java

### Q5. What is the difference between Hashtable and HashMap? Why is Hashtable considered legacy?

| Hashtable | HashMap |
|---|---|
| Synchronized (thread-safe) | Not synchronized |
| No null key or null values | One null key and many null values |
| Slower (every method locks the whole table) | Faster |
| Since Java 1.0, extends `Dictionary` | Since Java 1.2, extends `AbstractMap` |
| Iterated with `Enumeration` (and Iterator) | Iterated with fail-fast `Iterator` |

`Hashtable` is called **legacy** because it pre-dates the Collection Framework, extends the obsolete `Dictionary` class, and its coarse whole-table locking performs poorly. In new code use `HashMap` for single-threaded use and `ConcurrentHashMap` when thread safety is required.

### Q6. Write a program to create a HashMap of employee IDs and names: (a) add new key-value pairs, (b) check if a key exists, (c) iterate through the map using (i) keySet and (ii) entrySet.

Program: src/map/Q06_EmployeeHashMap.java

### Q7. Write a program to demonstrate the sorted order of keys in TreeMap by adding unsorted key-value pairs.

Program: src/map/Q07_TreeMapUnsortedInput.java

### Q8. Write a program to show the difference between HashMap and LinkedHashMap in terms of iteration order.

Program: src/map/Q08_HashMapVsLinkedHashMap.java

## Queue and Stack

### Q1. Implement a simple program using Queue (with LinkedList) to simulate a ticket booking system.

Program: src/queuestack/Q01_TicketBookingQueue.java

### Q2. Use a PriorityQueue to store a list of tasks with priorities. Add tasks, remove the highest-priority task, and print the queue.

Program: src/queuestack/Q02_PriorityTasks.java

### Q3. Write a program to implement a Stack using the Stack class. Perform operations like push, pop, peek, and check if it is empty.

Program: src/queuestack/Q03_StackClassOps.java

### Q4. Implement a deque using the ArrayDeque class: (a) add elements at both ends, (b) remove elements from both ends, (c) peek at both ends.

Program: src/queuestack/Q04_ArrayDequeOps.java

### Q5. Write a program to check if a string is a palindrome using a Deque.

Program: src/queuestack/Q05_PalindromeDeque.java

## Specialized Classes

### Q1. What is the purpose of the PriorityQueue class in Java?

`PriorityQueue<E>` is a queue in which elements are removed according to their **priority**, not their arrival order. By default the smallest element (natural ordering) has the highest priority, i.e. it is a **min-heap**; a `Comparator` can define any other order (e.g. `Collections.reverseOrder()` for a max-heap).

- Implemented as a binary heap in an array: `offer()`/`poll()` are O(log n), `peek()` is O(1).
- Iteration order / `toString()` is the internal heap order, not sorted order; repeatedly calling `poll()` gives sorted output.
- No nulls, not thread-safe (`PriorityBlockingQueue` is the thread-safe version).
- Uses: task scheduling, Dijkstra's shortest path, finding top-k elements, event simulation, merging sorted lists.

### Q2. How is the Deque interface different from the Queue interface?

| Queue | Deque (double-ended queue) |
|---|---|
| Insert at the **tail**, remove from the **head** (FIFO) | Insert and remove at **both ends** |
| `offer`, `poll`, `peek`, `add`, `remove`, `element` | `addFirst/addLast`, `offerFirst/offerLast`, `pollFirst/pollLast`, `peekFirst/peekLast` |
| Works only as a queue | Works as a queue (FIFO) **and** as a stack (LIFO: `push`, `pop`) |
| e.g. `PriorityQueue`, `LinkedList` | `Deque` extends `Queue`; e.g. `ArrayDeque`, `LinkedList` |

### Q3. What is the difference between BlockingQueue and PriorityQueue?

| BlockingQueue (`java.util.concurrent`) | PriorityQueue (`java.util`) |
|---|---|
| Interface for **thread-safe** producer–consumer queues | Class – **not** thread-safe |
| `put()` waits when the queue is full; `take()` waits when it is empty | Never blocks; `poll()` returns null when empty |
| Can be bounded (fixed capacity) | Unbounded (grows automatically) |
| Order depends on the implementation (FIFO in `ArrayBlockingQueue`, `LinkedBlockingQueue`) | Always priority (heap) order |
| Implementations: `ArrayBlockingQueue`, `LinkedBlockingQueue`, `PriorityBlockingQueue`, `DelayQueue` | Single class |
| Used for inter-thread communication | Used for ordering elements by priority in one thread |

`PriorityBlockingQueue` combines both: thread-safe, blocking and priority-ordered.

### Q4. Write a program to implement a simple Queue using the LinkedList class.

Program: src/specialized/Q04_LinkedListQueue.java

### Q5. What is the role of WeakHashMap in Java, and how is it different from HashMap?

`WeakHashMap<K, V>` stores its keys as **weak references**. When a key is no longer strongly referenced anywhere else in the program, the garbage collector can reclaim it and the entry is **automatically removed** from the map. It is used for caches and metadata attached to objects, where entries should not keep objects alive and cause memory leaks.

| HashMap | WeakHashMap |
|---|---|
| Strong references to keys | Weak references to keys |
| Entries stay until removed explicitly | Entries vanish after the key is garbage-collected |
| Can cause memory leaks if used as a cache | Memory-friendly cache |
| Size is stable | Size can shrink by itself |
| Keys compared with `equals()` | Works best with keys that use identity `equals()` |

Program: src/specialized/Q05_WeakHashMapVsHashMap.java

## Concurrency and Thread-Safety

### Q1. How is Vector different from ArrayList in terms of thread safety?

Every public method of `Vector` (`add`, `get`, `remove` ...) is `synchronized`, so only one thread can modify it at a time and its internal state stays consistent. `ArrayList` has no synchronization: if several threads add at once, updates can be lost, the size can be wrong, or an `ArrayIndexOutOfBoundsException` may occur. However, Vector is only safe per method call – compound actions like "check then add" still need external locking, and the locking makes it slower. Modern alternatives are `Collections.synchronizedList()` and `CopyOnWriteArrayList`.

### Q2. Write a program to demonstrate the thread-safe nature of Vector by adding elements to it from multiple threads.

Program: src/concurrency/Q02_VectorThreadSafe.java

### Q3. What is the role of ConcurrentHashMap in Java, and how does it achieve thread safety?

`ConcurrentHashMap<K, V>` (`java.util.concurrent`) is a thread-safe, high-performance hash map that many threads can read and write at the same time.

- **Java 7:** the map was split into 16 **segments**, each with its own lock, so threads writing to different segments did not block each other.
- **Java 8+:** segments were removed. It uses **CAS (compare-and-swap)** to insert into an empty bucket and `synchronized` on only the **first node of a bucket** when updating it, so locking is per bucket.
- **Reads are lock-free** – fields are `volatile`, so readers always see the latest completed writes.
- Atomic compound operations: `putIfAbsent`, `compute`, `computeIfAbsent`, `merge`, `replace`.
- Iterators are **weakly consistent** (fail-safe) – they never throw `ConcurrentModificationException`.
- Null keys and null values are not allowed (to avoid ambiguity in concurrent reads).

### Q4. Create a ConcurrentHashMap and demonstrate how it handles concurrent modifications.

Program: src/concurrency/Q04_ConcurrentHashMapDemo.java

### Q5. What are the differences between CopyOnWriteArrayList and ArrayList?

| ArrayList | CopyOnWriteArrayList |
|---|---|
| Not thread-safe | Thread-safe (`java.util.concurrent`) |
| Writes modify the same array | Every write (`add`, `set`, `remove`) makes a **new copy** of the array |
| Iterator is **fail-fast** – throws `ConcurrentModificationException` | Iterator works on a **snapshot** – never throws CME, but does not see later changes |
| Iterator supports `remove()` | Iterator `remove()`/`set()` throw `UnsupportedOperationException` |
| Cheap writes | Expensive writes (O(n) copy), very fast lock-free reads |
| General-purpose | Best when reads/iterations far outnumber writes (e.g. listener lists) |

### Q6. Write a program using CopyOnWriteArrayList to iterate and modify a list safely in a multithreaded environment.

Program: src/concurrency/Q06_CopyOnWriteArrayListDemo.java

### Q7. What is the difference between synchronizedCollection and ConcurrentHashMap?

| `Collections.synchronizedCollection()` / `synchronizedMap()` | `ConcurrentHashMap` |
|---|---|
| A wrapper that adds `synchronized` to every method of an existing collection | A separate class designed for concurrency |
| One lock for the **whole** collection – only one thread at a time | Fine-grained locking per bucket + CAS; reads are lock-free |
| Lower throughput under contention | High throughput with many threads |
| Iteration must be manually wrapped in `synchronized(coll) { }`, otherwise CME | Weakly consistent iterators, no CME, no external lock |
| Allows nulls if the underlying collection does | No null keys or values |
| Works for any `Collection` (List, Set ...) | Only for maps |
| Compound actions need external locking | Atomic `putIfAbsent`, `compute`, `merge` |

## Utility Methods in Collections Class

### Q1. What are some commonly used methods in the Collections utility class?

| Category | Methods |
|---|---|
| Sorting & order | `sort(list)`, `sort(list, comparator)`, `reverse(list)`, `shuffle(list)`, `swap(list, i, j)`, `rotate(list, d)`, `reverseOrder()` |
| Searching | `binarySearch(list, key)`, `max(coll)`, `min(coll)`, `frequency(coll, o)`, `indexOfSubList()` |
| Modifying | `fill(list, o)`, `copy(dest, src)`, `addAll(coll, e...)`, `replaceAll(list, old, new)`, `nCopies(n, o)` |
| Read-only wrappers | `unmodifiableList/Set/Map/Collection()` |
| Thread-safe wrappers | `synchronizedList/Set/Map/Collection()` |
| Special collections | `emptyList()`, `singletonList(o)`, `singleton(o)`, `checkedList()` |
| Comparison | `disjoint(c1, c2)` |

### Q2. Write a program to shuffle and sort an ArrayList using methods from the Collections class.

Program: src/utility/Q02_ShuffleAndSort.java

### Q3. How can you make a collection thread-safe using the Collections class?

Wrap it with one of the `synchronizedXxx` factory methods, which return a view whose every method is synchronized on a common lock:

```java
List<Integer> list = Collections.synchronizedList(new ArrayList<>());
Set<String> set = Collections.synchronizedSet(new HashSet<>());
Map<String, Integer> map = Collections.synchronizedMap(new HashMap<>());
```

Also available: `synchronizedCollection`, `synchronizedSortedSet`, `synchronizedSortedMap`, `synchronizedNavigableSet/Map`. Iterating must still be done inside `synchronized (list) { ... }`, because iteration consists of many separate calls. Always access the collection through the wrapper, never the original reference.

Program: src/utility/Q03_SynchronizedCollection.java

### Q4. Create an unmodifiable List using Collections.unmodifiableList() and show what happens when you try to modify it.

Program: src/utility/Q04_UnmodifiableList.java

### Q5. Write a program to perform a binary search on a List using the Collections.binarySearch() method.

Program: src/utility/Q05_BinarySearch.java

### Q6. Write a program to find the frequency of elements in a list using Collections.frequency().

Program: src/utility/Q06_Frequency.java

## Custom Comparator

### Q1. Write a program to sort a list of custom objects (e.g., Student with name and marks) using a Comparator.

Program: src/comparator/Q01_SortStudents.java

### Q2. Write a program to sort a Map by its values using a custom Comparator.

Program: src/comparator/Q02_SortMapByValue.java

## Practical Use Cases

### Q1. Create a class LruCache<K, V> using LinkedHashMap to implement an LRU (Least Recently Used) cache.

Program: src/practical/Q01_LruCache.java

### Q2. Implement a basic to-do list application using ArrayList to store tasks. Add functionality to add, remove, and display tasks.

Program: src/practical/Q02_TodoList.java

### Q3. Write a program to count the frequency of characters in a string using a HashMap.

Program: src/practical/Q03_CharFrequency.java

### Q4. Create a program to store students' grades in a TreeMap, with student names as keys and grades as values. Allow adding, removing, and querying grades.

Program: src/practical/Q04_StudentGrades.java

### Q5. Write a program to merge two PriorityQueue objects and sort the resulting queue.

Program: src/practical/Q05_MergePriorityQueues.java

## Advanced Questions

### Q1. Create a generic MultiMap<K, V> class that stores multiple values for a single key using a HashMap<K, List<V>>.

Program: src/advanced/Q01_MultiMap.java

### Q2. Write a program to implement a simple banking system using Map to store customer IDs and their account balances.

Program: src/advanced/Q02_BankingSystem.java

### Q3. Use a WeakHashMap to demonstrate how entries are garbage-collected when keys are no longer strongly referenced.

Program: src/advanced/Q03_WeakHashMapGC.java

### Q4. Create a program to implement a book catalog system using HashMap, where book titles are the keys and author names are the values. Allow searching by title.

Program: src/advanced/Q04_BookCatalog.java

### Q5. Write a program to store a list of products and their prices in a TreeMap and display the products in sorted order by name.

Program: src/advanced/Q05_ProductPrices.java
