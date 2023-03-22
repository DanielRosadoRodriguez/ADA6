public class DoublyLinkedList<T> {

    private DoublyLink<T> first;
    private DoublyLink<T> last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * Inserta un nodo al final de la lista, recibe un valor genérico de tipo T
     * 
     * @param d
     */
    public void add(T d) {
        DoublyLink<T> newLink = new DoublyLink<T>(d);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
        size++;
    }

    /**
     * método que indica si la lista está vacía
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    public void simpleSort(){
        DoublyLink<T> current = first;
        while (current != null) {
            DoublyLink<T> min = current;
            DoublyLink<T> temp = current.getNext();
            while (temp != null) {
                if ((Integer) temp.getData() < (Integer) min.getData()) {
                    min = temp;
                }
                temp = temp.getNext();
            }
            swap(current, min);
            current = current.getNext();
        }

    }
    public void swap(DoublyLink<T> a, DoublyLink<T> b){
        T temp = a.getData();
        a.setData(b.getData());
        b.setData(temp);
    }
    /**
     * imprime el contenido de la lista
     */
    public void displayList() {
        DoublyLink<T> current = first;
        if (isEmpty()) {
            System.out.println("la lista está vacía");
        }
        System.out.print("first->");
        while (current != null) {
            System.out.print(current.getData() + "->");
            current = current.getNext();
        }
        System.out.println("last");
    }


 
}
