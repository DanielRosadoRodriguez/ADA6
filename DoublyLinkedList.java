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
    public void bubbleSort() {
        DoublyLink current = first;
        while (current != null) {
            DoublyLink next = current.getNext();
            while (next != null) {
                if (((Float)current.getWine().getValueToCompare()).compareTo((Float)next.getWine().getValueToCompare()) > 0) {
                    swap(current, next);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }



    public void swap(DoublyLink a, DoublyLink b) {
        if (a == b) {
            return;
        }
        DoublyLink temp = a.getPrevious();
        a.setPrevious(b.getPrevious());
        b.setPrevious(temp);
        temp = a.getNext();
        a.setNext(b.getNext());
        b.setNext(temp);
        if (a.getNext() != null) {
            a.getNext().setPrevious(a);
        } else {
            last = a;
        }
        if (b.getNext() != null) {
            b.getNext().setPrevious(b);
        } else {
            last = b;
        }
        if (b.getNext() != null) {
            b.getNext().setPrevious(b);
        } else {
            last = b;
        }
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

    public DoublyLink getFirst() {
        return this.first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }

    public void setColumnToCompare(String colToCompare) {
        while (first != null) {
            first.getWine().setValueToCompare(colToCompare);
            first = first.getNext();
        }
    }

    public void printAlcohol() {
        DoublyLink current = first;
        while (current != null) {
            System.out.println(current.getWine().getAlcohol());
            current = current.getNext();
        }
    }

}
