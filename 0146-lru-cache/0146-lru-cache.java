class LRUCache {
    class Node {
        Integer key;
        Integer value;
        Node next;
        Node prev;

        Node(Integer key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private final Map<Integer, Node> cache;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new HashMap<>();
        this.head = new Node(null, null); 
        this.tail = new Node(null, null); 
        head.next = tail;
        tail.prev = head;
    }
    
    public Integer get(int key) {
        Node node = cache.get(key);
        
        if (node == null) return -1;

        moveToHead(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);

        if (node == null) {
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            addToFront(newNode);

            if (cache.size() > capacity) {
                Node toRemove = tail.prev;
                removeNode(toRemove);
                cache.remove(toRemove.key);
            }
        } else {
            node.value = value;
            moveToHead(node);
        }
    }

    private void addToFront(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void moveToHead(Node node) {
        removeNode(node);
        addToFront(node);
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */