public class LinkedList {
    private Node head;
    private Node tail;

    public LinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void add(int n) {
        Node newNode = new Node(n);
        if (this.head == null) {
            this.head = newNode;
            this.tail = newNode;
        } else {
            this.tail.setNext(newNode);
            newNode.setPrev(this.tail);
            this.tail = newNode;
        }
    }

    public void simpleSort(){
        Node current = this.head;
        while (current != null) {
            Node min = current;
            Node temp = current.getNext();
            while (temp != null) {
                if (temp.getData() < min.getData()) {
                    min = temp;
                }
                temp = temp.getNext();
            }
            swap(current, min);
            current = current.getNext();
        }
    }
    public void swap(Node a, Node b){
        int temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }

    public void printList(){
        Node current = this.head;
        while (current != null) {
            System.out.println(current.getData());
            current = current.getNext();
        }
    }
}
