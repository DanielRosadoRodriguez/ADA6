public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void sort() {
        QuickSort quickSort = new QuickSort(this);
        DoublyLinkedList quickSorted = quickSort.sort();
        System.out.println("Tiempo de ejecución: " + quickSort.getTime() + " ms");
        System.out.println("Número de swaps: " + quickSort.numberOfSwaps);
        
        MergeSort mergeSort = new MergeSort(this);
        DoublyLinkedList mergeSorted = mergeSort.sort();
        System.out.println("Tiempo de ejecución: " + mergeSort.getTime() + " ms");

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

    public void SetColumnToCompare(String columnToCompare) {
        DoublyLink current = first;
        while (current != null) {
            current.getWine().setValueToCompare(columnToCompare);
            current = current.getNext();
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
    public void displayList(DoublyLinkedList list) {
        DoublyLink current = list.first;
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

    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public Wine get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyLink current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getWine();
    }

    public void updateNodeWithPosition(int nodePosition, Wine newValue) throws Exception {
        DoublyLink current = first;
        if (isEmpty())
            throw new Exception("La lista está vacía");
        try {
            for (int i = 0; i < nodePosition; i++) {
                if (current == null) {
                    throw new Exception("La posición no existe en la lista");
                }
                current = current.getNext();
            }
            current.setWine(newValue);
        } catch (NullPointerException e) {
            throw new Exception("La posición no existe en la lista");
        }
    }

    public DoublyLink getFirst() {
        return first;
    }

    public void setFirst(DoublyLink first) {
        this.first = first;
    }

    public DoublyLink getLast() {
        return last;
    }

    public void setLast(DoublyLink last) {
        this.last = last;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

}
