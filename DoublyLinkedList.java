public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void add(Wine wine) {
        DoublyLink newLink = new DoublyLink(wine);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
        size++;
    }

    public void SetColumnToCompare(String columnToCompare){
        DoublyLink current = first;
        while (current != null) {
            current.getWine().setValueToCompare(columnToCompare);
            current = current.getNext();
        }
    }

    public void simpleSortFloat() {
        DoublyLink current = first;
        while (current != null) {
            DoublyLink next = current.getNext();
            while (next != null) {
                if ((float) current.getWine().getValueToCompare() > (float)next.getWine().getValueToCompare()) {
                    swap(current, next);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }

    public void swap(DoublyLink current, DoublyLink next) {
        Wine temp = current.getWine();
        current.setWine(next.getWine());
        next.setWine(temp);
    }

    /**
     * imprime el contenido de la lista
     * 
     */
    public void displayList() {
        DoublyLink current = first;
        if (isEmpty()) {
            System.out.println("la lista está vacía");
        }
        System.out.print("first->");
        while (current != null) {
            System.out.print(current.getWine().getValueToCompare() + "->");
            current = current.getNext();
        }
        System.out.println("last");
    }

    public boolean isEmpty() {
        return first == null;
    }

    public void printAlcohol() {
        DoublyLink current = first;
        while (current != null) {
            System.out.println(current.getWine().getAlcohol());
            current = current.getNext();
        }
    }

    public DoublyLink getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }
}
