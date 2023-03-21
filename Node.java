public class Node {
    private int data;
    private Node prev;
    private Node next;

    public Node(int n) {
        this.data = n;
        this.prev = null;
        this.next = null;
    }

    public int getData() {
        return this.data;
    }
    public Node getPrev() {
        return this.prev;
    }
    public Node getNext() {
        return this.next;
    }

    public void setData(int n) {
        this.data = n;
    }
    public void setPrev(Node n) {
        this.prev = n;
    }
    public void setNext(Node n) {
        this.next = n;
    }
}
