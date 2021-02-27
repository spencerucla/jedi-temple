class LRUCache {
    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }

    private Map<Integer, Node> map;
    private Node head;
    private int cap;

    public LRUCache(int capacity) {
        map = new HashMap<>();
        head = null;
        cap = capacity;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node != null) {
            // bring to front of queue
            remove(node);
            enqueue(node);
            return node.val;
        }
        return -1;
    }

    public void put(int key, int val) {
        Node node = map.get(key);
        if (node != null) {
            // bring to front of queue
            remove(node);
            enqueue(node);
            node.val = val;
        } else {
            if (map.size() >= cap) {
                // evict LRU
                Node last = head.prev;
                map.remove(last.key);
                remove(last);
            }
            // put new node in map/queue
            node = new Node(key, val);
            map.put(key, node);
            enqueue(node);
        }
    }

    private void remove(Node node) {
        if (node.next == node) {
            // queue size=1
            head = null;
        } else {
            // queue size>1
            // remove node from middle of queue
            node.prev.next = node.next;
            node.next.prev = node.prev;
            // if node was first readjust head
            if (node == head) {
                head = head.next;
            }
        }
    }

    private void enqueue(Node node) {
        if (head == null) {
            head = node;
            node.prev = node;
            node.next = node;
        } else {
            // insert to front of queue
            node.next = head;
            node.prev = head.prev;
            head.prev.next = node;
            head.prev = node;
            head = node;
        }
    }
}
