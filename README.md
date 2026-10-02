# Java Module 4 – Generics & Collection Framework

**Name:** Ansh Tiwari  
**Roll No:** 36  
**Course:** Java Programming – Module 4 Assignment

Solutions to all questions of the Module 4 assignment: Generics, `java.util` & the Collection Framework, List, Set, Map, Queue/Stack, specialized classes, concurrency, the `Collections` utility class, custom comparators, practical use cases and advanced questions.

- **Theory answers:** [THEORY.md](THEORY.md) (every question, in order)
- **Programs:** `src/` – one package per section, one file per question (52 programs)
- **Outputs:** `outputs/` – actual console output of every program

## Project structure

```
src/
  generics/            Generic classes, bounded types, wildcards, Pair, Box, Stack, MinMaxFinder
  collectionframework/ Iterating a list 3 ways, generic printCollection()
  list/                ArrayList, Stack, list operations, ArrayList vs LinkedList, sorting
  set/                 TreeSet, HashSet duplicates & equals/hashCode, LinkedHashSet order
  map/                 TreeMap, HashMap of employees, HashMap vs LinkedHashMap
  queuestack/          Ticket booking queue, PriorityQueue tasks, Stack, ArrayDeque, palindrome
  specialized/         Queue with LinkedList, WeakHashMap vs HashMap
  concurrency/         Vector with threads, ConcurrentHashMap, CopyOnWriteArrayList
  utility/             shuffle/sort, synchronizedList, unmodifiableList, binarySearch, frequency
  comparator/          Sorting Students, sorting a Map by value
  practical/           LRU cache, To-do app, char frequency, grade book, merging PriorityQueues
  advanced/            MultiMap, banking system, WeakHashMap GC, book catalog, product prices
inputs/                Sample input for the 4 interactive (menu-driven) programs
outputs/               Output of every program
```

## How to run (VS Code)

1. Install a JDK (17 or newer) and the **Extension Pack for Java** in VS Code.
2. `File → Open Folder…` and pick this folder.
3. Open any file in `src/` and click **Run** above `main`.

Run everything from a terminal:

```bash
./run_all.sh          # Linux / macOS / Git Bash
.\run_all.ps1         # Windows PowerShell
```

or a single program:

```bash
javac -d bin src/generics/*.java
java -cp bin generics.Q06_Pair
```

## Program index

| Section | Program | Output |
|---|---|---|
| Generics | [`Q02_GenericClassSyntax`](src/generics/Q02_GenericClassSyntax.java) | [output](outputs/generics.Q02_GenericClassSyntax.txt) |
| Generics | [`Q03_BoundedType`](src/generics/Q03_BoundedType.java) | [output](outputs/generics.Q03_BoundedType.txt) |
| Generics | [`Q04_WildcardsExtendsSuper`](src/generics/Q04_WildcardsExtendsSuper.java) | [output](outputs/generics.Q04_WildcardsExtendsSuper.txt) |
| Generics | [`Q05_RawVsParameterized`](src/generics/Q05_RawVsParameterized.java) | [output](outputs/generics.Q05_RawVsParameterized.txt) |
| Generics | [`Q06_Pair`](src/generics/Q06_Pair.java) | [output](outputs/generics.Q06_Pair.txt) |
| Generics | [`Q07_Box`](src/generics/Q07_Box.java) | [output](outputs/generics.Q07_Box.txt) |
| Generics | [`Q08_SwapElements`](src/generics/Q08_SwapElements.java) | [output](outputs/generics.Q08_SwapElements.txt) |
| Generics | [`Q09_GenericStack`](src/generics/Q09_GenericStack.java) | [output](outputs/generics.Q09_GenericStack.txt) |
| Generics | [`Q10_MinMaxFinder`](src/generics/Q10_MinMaxFinder.java) | [output](outputs/generics.Q10_MinMaxFinder.txt) |
| Java.util Package and Collection Framework | [`Q11_IterateList`](src/collectionframework/Q11_IterateList.java) | [output](outputs/collectionframework.Q11_IterateList.txt) |
| Java.util Package and Collection Framework | [`Q12_PrintAnyCollection`](src/collectionframework/Q12_PrintAnyCollection.java) | [output](outputs/collectionframework.Q12_PrintAnyCollection.txt) |
| List Interface | [`Q03_ArrayListDemo`](src/list/Q03_ArrayListDemo.java) | [output](outputs/list.Q03_ArrayListDemo.txt) |
| List Interface | [`Q05_StackClassDemo`](src/list/Q05_StackClassDemo.java) | [output](outputs/list.Q05_StackClassDemo.txt) |
| List Interface | [`Q06_ListOperations`](src/list/Q06_ListOperations.java) | [output](outputs/list.Q06_ListOperations.txt) |
| List Interface | [`Q07_ArrayListVsLinkedList`](src/list/Q07_ArrayListVsLinkedList.java) | [output](outputs/list.Q07_ArrayListVsLinkedList.txt) |
| List Interface | [`Q08_SortStrings`](src/list/Q08_SortStrings.java) | [output](outputs/list.Q08_SortStrings.txt) |
| Set Interface | [`Q03_TreeSetSorted`](src/set/Q03_TreeSetSorted.java) | [output](outputs/set.Q03_TreeSetSorted.txt) |
| Set Interface | [`Q04_HashSetDuplicates`](src/set/Q04_HashSetDuplicates.java) | [output](outputs/set.Q04_HashSetDuplicates.txt) |
| Set Interface | [`Q06_HashSetUniqueness`](src/set/Q06_HashSetUniqueness.java) | [output](outputs/set.Q06_HashSetUniqueness.txt) |
| Set Interface | [`Q07_TreeSetOperations`](src/set/Q07_TreeSetOperations.java) | [output](outputs/set.Q07_TreeSetOperations.txt) |
| Set Interface | [`Q08_LinkedHashSetOrder`](src/set/Q08_LinkedHashSetOrder.java) | [output](outputs/set.Q08_LinkedHashSetOrder.txt) |
| Map Interface | [`Q04_TreeMapSortKeys`](src/map/Q04_TreeMapSortKeys.java) | [output](outputs/map.Q04_TreeMapSortKeys.txt) |
| Map Interface | [`Q06_EmployeeHashMap`](src/map/Q06_EmployeeHashMap.java) | [output](outputs/map.Q06_EmployeeHashMap.txt) |
| Map Interface | [`Q07_TreeMapUnsortedInput`](src/map/Q07_TreeMapUnsortedInput.java) | [output](outputs/map.Q07_TreeMapUnsortedInput.txt) |
| Map Interface | [`Q08_HashMapVsLinkedHashMap`](src/map/Q08_HashMapVsLinkedHashMap.java) | [output](outputs/map.Q08_HashMapVsLinkedHashMap.txt) |
| Queue and Stack | [`Q01_TicketBookingQueue`](src/queuestack/Q01_TicketBookingQueue.java) | [output](outputs/queuestack.Q01_TicketBookingQueue.txt) |
| Queue and Stack | [`Q02_PriorityTasks`](src/queuestack/Q02_PriorityTasks.java) | [output](outputs/queuestack.Q02_PriorityTasks.txt) |
| Queue and Stack | [`Q03_StackClassOps`](src/queuestack/Q03_StackClassOps.java) | [output](outputs/queuestack.Q03_StackClassOps.txt) |
| Queue and Stack | [`Q04_ArrayDequeOps`](src/queuestack/Q04_ArrayDequeOps.java) | [output](outputs/queuestack.Q04_ArrayDequeOps.txt) |
| Queue and Stack | [`Q05_PalindromeDeque`](src/queuestack/Q05_PalindromeDeque.java) | [output](outputs/queuestack.Q05_PalindromeDeque.txt) |
| Specialized Classes | [`Q04_LinkedListQueue`](src/specialized/Q04_LinkedListQueue.java) | [output](outputs/specialized.Q04_LinkedListQueue.txt) |
| Specialized Classes | [`Q05_WeakHashMapVsHashMap`](src/specialized/Q05_WeakHashMapVsHashMap.java) | [output](outputs/specialized.Q05_WeakHashMapVsHashMap.txt) |
| Concurrency and Thread-Safety | [`Q02_VectorThreadSafe`](src/concurrency/Q02_VectorThreadSafe.java) | [output](outputs/concurrency.Q02_VectorThreadSafe.txt) |
| Concurrency and Thread-Safety | [`Q04_ConcurrentHashMapDemo`](src/concurrency/Q04_ConcurrentHashMapDemo.java) | [output](outputs/concurrency.Q04_ConcurrentHashMapDemo.txt) |
| Concurrency and Thread-Safety | [`Q06_CopyOnWriteArrayListDemo`](src/concurrency/Q06_CopyOnWriteArrayListDemo.java) | [output](outputs/concurrency.Q06_CopyOnWriteArrayListDemo.txt) |
| Utility Methods in Collections Class | [`Q02_ShuffleAndSort`](src/utility/Q02_ShuffleAndSort.java) | [output](outputs/utility.Q02_ShuffleAndSort.txt) |
| Utility Methods in Collections Class | [`Q03_SynchronizedCollection`](src/utility/Q03_SynchronizedCollection.java) | [output](outputs/utility.Q03_SynchronizedCollection.txt) |
| Utility Methods in Collections Class | [`Q04_UnmodifiableList`](src/utility/Q04_UnmodifiableList.java) | [output](outputs/utility.Q04_UnmodifiableList.txt) |
| Utility Methods in Collections Class | [`Q05_BinarySearch`](src/utility/Q05_BinarySearch.java) | [output](outputs/utility.Q05_BinarySearch.txt) |
| Utility Methods in Collections Class | [`Q06_Frequency`](src/utility/Q06_Frequency.java) | [output](outputs/utility.Q06_Frequency.txt) |
| Custom Comparator | [`Q01_SortStudents`](src/comparator/Q01_SortStudents.java) | [output](outputs/comparator.Q01_SortStudents.txt) |
| Custom Comparator | [`Q02_SortMapByValue`](src/comparator/Q02_SortMapByValue.java) | [output](outputs/comparator.Q02_SortMapByValue.txt) |
| Practical Use Cases | [`Q01_LruCache`](src/practical/Q01_LruCache.java) | [output](outputs/practical.Q01_LruCache.txt) |
| Practical Use Cases | [`Q02_TodoList`](src/practical/Q02_TodoList.java) | [output](outputs/practical.Q02_TodoList.txt) |
| Practical Use Cases | [`Q03_CharFrequency`](src/practical/Q03_CharFrequency.java) | [output](outputs/practical.Q03_CharFrequency.txt) |
| Practical Use Cases | [`Q04_StudentGrades`](src/practical/Q04_StudentGrades.java) | [output](outputs/practical.Q04_StudentGrades.txt) |
| Practical Use Cases | [`Q05_MergePriorityQueues`](src/practical/Q05_MergePriorityQueues.java) | [output](outputs/practical.Q05_MergePriorityQueues.txt) |
| Advanced Questions | [`Q01_MultiMap`](src/advanced/Q01_MultiMap.java) | [output](outputs/advanced.Q01_MultiMap.txt) |
| Advanced Questions | [`Q02_BankingSystem`](src/advanced/Q02_BankingSystem.java) | [output](outputs/advanced.Q02_BankingSystem.txt) |
| Advanced Questions | [`Q03_WeakHashMapGC`](src/advanced/Q03_WeakHashMapGC.java) | [output](outputs/advanced.Q03_WeakHashMapGC.txt) |
| Advanced Questions | [`Q04_BookCatalog`](src/advanced/Q04_BookCatalog.java) | [output](outputs/advanced.Q04_BookCatalog.txt) |
| Advanced Questions | [`Q05_ProductPrices`](src/advanced/Q05_ProductPrices.java) | [output](outputs/advanced.Q05_ProductPrices.txt) |
