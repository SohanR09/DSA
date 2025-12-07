public class Solution {
    private Map<Integer, Node> cache;
    private int capacity;
    private Node head;
    private Node tail;

    public class Node {
        int key;
        int data;
        Node prev;
        Node next;

        public Node(int data, int key) {
            this.key = key;
            this.data = data;
            this.prev = null; // Initially, no previous node
            this.next = null; // Initially, no next node
        }
    }

    
    public Solution(int capacity) {
        this.cache = new HashMap<>();
        this.capacity = capacity;
        this.head = null;
        this.tail = null;
    }
    
    public int get(int key) {
       if(cache.containsKey(key)){
           Node node = cache.get(key);
           deleteFromDLL(node);
           addToDLL(node);

           return node.data;
       } 
       return -1;
    }
    
    public void set(int key, int value) {
        if(cache.containsKey(key)){
            Node node = cache.get(key);
            node.data = value;
            deleteFromDLL(node);
            addToDLL(node);
        }else{
            if(cache.size() == capacity){
                Node temp = head;
                deleteFromDLL(head);
                cache.remove(temp.key);
            }
            Node node = new Node(value, key);
            addToDLL(node);
            cache.put(key, node);
        }
    }

    private void deleteFromDLL(Node x){
        if (x == head && x == tail) {
            // Only one node in the list
            head = tail = null;
        }else if (x == head) {
            // Deleting the head
            head = head.next;
            head.prev = null;
        }else if (x == tail) {
            // Deleting the tail
            tail = tail.prev;
            tail.next = null;
        } else {
            // Deleting a node in the middle
            x.prev.next = x.next;
            x.next.prev = x.prev;
        }
        // Clear the pointers of the deleted node
        x.prev = null;
        x.next = null;
    }
    private void addToDLL(Node x){
        if(head == null && tail == null){
            head = tail = x;
        }else {
            tail.next = x;
            x.prev = tail;
            tail = x;
        }
        x.next = null;
    }
}
