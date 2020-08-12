### Collection
----
- TreeMap：基于红黑树实现。
- HashMap：基于哈希表实现。
    - 存储结构
    
        内部包含了一个 Entry 类型的数组 table。
        ````
        transient Entry[] table;
        ````
        每个Entry存储着键值对。它包含了四个字段，从next字段我们可以看出Entry是一个链表。即数组中的每个位置 `table的值` 被当作一个桶，一个桶存放一个链表。
        HashMap使用拉链法来解决冲突，同一个链表中（桶内）存放哈希值相同的Entry。
        ````
        static class Entry<K,V> implements Map.Entry<K,V> {
            final K key;
            V value;
            Entry<K,V> next;
            int hash;
        
            Entry(int h, K k, V v, Entry<K,V> n) {
                value = v;
                next = n;
                key = k;
                hash = h;
            }
        
            public final K getKey() {
                return key;
            }
        
            public final V getValue() {
                return value;
            }
        
            public final V setValue(V newValue) {
                V oldValue = value;
                value = newValue;
                return oldValue;
            }
        
            public final boolean equals(Object o) {
                if (!(o instanceof Map.Entry))
                    return false;
                Map.Entry e = (Map.Entry)o;
                Object k1 = getKey();
                Object k2 = e.getKey();
                if (k1 == k2 || (k1 != null && k1.equals(k2))) {
                    Object v1 = getValue();
                    Object v2 = e.getValue();
                    if (v1 == v2 || (v1 != null && v1.equals(v2)))
                        return true;
                }
                return false;
            }
        
            public final int hashCode() {
                return Objects.hashCode(getKey()) ^ Objects.hashCode(getValue());
            }
        
            public final String toString() {
                return getKey() + "=" + getValue();
            }
        }
        ````
    - 拉链法的工作原理
        ````
        HashMap<String, String> map = new HashMap<>();
        map.put("K1", "V1");
        map.put("K2", "V2");
        map.put("K3", "V3");
        ````
        - 新建一个HashMap,默认大小为16;
        - 插入Entry<K1,V1>键值对，先计算出K1的hashCode为115，使用除留余数法得到所在桶下标 115%16=3。
        - 插入Entry<K2,V2>键值对，先计算出K2的hashCode为118，使用除留余数法得到所在桶下标 118%16=6。
        - 插入Entry<K3,V3>键值对，先计算出K3的hashCode为118，使用除留余数法得到所在桶下标 118%16=6，插在<K2,V2>前面。
        
        应该注意到这里桶内的链表的插入是以头插法方式进行的，例如上面的<K3,V3>不是插在<K2,V2>后面，而是插入在链表头部。
        
        查找需要分成两步进行：
        - 通过hashCode计算键值对所在的桶;
        - 通过equals方法对链表中的键值对进行顺序查找，找到目标键值对
        > 链表上顺序查找，时间复杂度显然和链表的长度成正比。
    - put操作
    
        ````
        public V put(K key, V value) {
            if (table == EMPTY_TABLE) {
                inflateTable(threshold);
            }
            // 键为 null 单独处理
            if (key == null)
                return putForNullKey(value);
            int hash = hash(key);
            // 确定桶下标
            int i = indexFor(hash, table.length);
            // 先找出是否已经存在键为 key 的键值对，如果存在的话就更新这个键值对的值为 value
            for (Entry<K,V> e = table[i]; e != null; e = e.next) {
                Object k;
                if (e.hash == hash && ((k = e.key) == key || key.equals(k))) {
                    V oldValue = e.value;
                    e.value = value;
                    e.recordAccess(this);
                    return oldValue;
                }
            }
        
            modCount++;
            // 插入新键值对
            addEntry(hash, key, value, i);
            return null;
        }
        ````
        HashMap 允许插入键为 null 的键值对。但是因为无法调用 null 的 hashCode() 方法，也就无法确定该键值对的桶下
                标，只能通过强制指定一个桶下标来存放。HashMap 使用第 0 个桶存放键为 null 的键值对。
                

- HashTable：和 HashMap 类似，但它是线程安全的，这意味着同一时刻多个线程可以同时写入 HashTable 并且不
会导致数据不一致。它是遗留类，不应该去使用它。现在可以使用 ConcurrentHashMap 来支持线程安全，并且
ConcurrentHashMap 的效率会更高，因为 ConcurrentHashMap 引入了分段锁。
    - HashTable与HashMap比较
        - HashTable 使用 synchronized 来进行同步。
        - HashMap 可以插入键为 null 的 Entry。
        - HashMap 的迭代器是 fail-fast 迭代器。
        - HashMap 不能保证随着时间的推移 Map 中的元素次序是不变的。
    - ConcurrentHashMap
        - ConcurrentHashMap 和 HashMap 实现上类似，最主要的差别是 ConcurrentHashMap 采用了分段锁（Segment），每个
          分段锁维护着几个桶（HashEntry），多个线程可以同时访问不同分段锁上的桶，从而使其并发度更高（并发度就是
          Segment 的个数）。
- LinkedHashMap：使用双向链表来维护元素的顺序，顺序为插入顺序或者最近最少使用（LRU）顺序。