import java.util.HashMap;

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private HashMap<Integer, Node> cache;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        
        // Dummy head and tail nodes to avoid null checks
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        
        // Connect the head and tail
        head.next = tail;
        tail.prev = head;
    }

    // Move the node to the head (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addNode(node);
    }

    // Add a new node right after the head
    private void addNode(Node node) {
        node.next = head.next;
        node.prev = head;
        
        head.next.prev = node;
        head.next = node;
    }

    // Remove an existing node from the linked list
    private void removeNode(Node node) {
        Node prev = node.prev;
        Node next = node.next;
        
        prev.next = next;
        next.prev = prev;
    }

    // Remove the least recently used node (tail node)
    private Node popTail() {
        Node res = tail.prev;
        removeNode(res);
        return res;
    }

    // Get the value of the key if it exists, otherwise return -1
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;
        }
        Node node = cache.get(key);
        moveToHead(node);
        return node.value;
    }

    // Put the key-value pair into the cache
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            Node node = cache.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addNode(newNode);
            
            if (cache.size() > capacity) {
                Node tailNode = popTail();
                cache.remove(tailNode.key);
            }
        }
    }
}

public class p99 {
    public static void main(String[] args) {
        LRUCache lruCache = new LRUCache(2);
        lruCache.put(1, 1); // cache: {1=1}
        lruCache.put(2, 2); // cache: {1=1, 2=2}
        System.out.println(lruCache.get(1)); // returns 1
        lruCache.put(3, 3); // evicts key 2, cache: {1=1, 3=3}
        System.out.println(lruCache.get(2)); // returns -1 (not found)
        lruCache.put(4, 4); // evicts key 1, cache: {3=3, 4=4}
        System.out.println(lruCache.get(1)); // returns -1 (not found)
        System.out.println(lruCache.get(3)); // returns 3
        System.out.println(lruCache.get(4)); // returns 4
    }
}
