class DLL {
    public static class Node {
        Node next;
        Node prev;
        public int key;
        public int val;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    Node head;
    Node tail;
    int size=0;

    DLL() {
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node addFirst(int key, int val) {
        return addFirst(new Node(key, val));
    }
    public Node addFirst(Node node) {
        node.prev = head;
        node.next = head.next;

        head.next.prev = node;
        head.next = node;
        size++;

        return node;
    }

    public Node getLast() {
        return tail.prev;
    }
}
