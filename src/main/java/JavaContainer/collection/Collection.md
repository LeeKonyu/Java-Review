### Collection
----
1. Set
- TreeSet：基于红黑树实现，支持有序性操作，例如根据一个范围查找元素的操作。但是查找效率不如HashSet，
HashSet查找的时间复杂度味`O(1)`，TreeSet则为`O(logN)`。
- HashSet：基于哈希表实现，支持快速查找，但不支持有序性操作。并且失去了元素的插入顺序信息，也就是说
  使用 Iterator 遍历 HashSet 得到的结果是不确定的。
- LinkedHashSet：具有 HashSet 的查找效率，且内部使用双向链表维护元素的插入顺序。

2. List
- ArrayList：基于动态数组实现，支持随机访问。
- Vector：和ArrayList类似，但他是线程安全的，因为使用了`synchronized`同步。
    - 与ArrayList相比较：Vector是同步的，所以开销就比ArrayList大，访问速度更慢。最好使用ArrayList而不是Vector，因为同步操作可以由程序员自己来控制。
    - Vector每次扩容请求其大小的2倍空间，而ArrayList是1.5倍
    
    替代方案：可以使用`Collections.synchronizedList();`得到一个线程安全的ArrayList。
    ````
    List<String> list = new ArrayList<>();
    List<String> list = Collections.synchronizedList(list);
    ````
- LinkedList：基于双向链表实现，只能顺序访问，但是可以快速地在链表中间插入和删除元素。不仅如此，
LinkedList，还可以用作栈、队列和双向队列。
    - 与ArrayList相比较：
    1. ArrayList 基于动态数组实现，LinkedList 基于双向链表实现；
    2. ArrayList 支持随机访问，LinkedList 不支持；
    3. LinkedList 在任意位置添加删除元素更快。

3.Queue
- LinkedList：可以用它来实现双向队列。
- PriorityQueue：基于堆结构实现，可以用它来实现优先队列。
