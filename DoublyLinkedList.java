import java.io.IOException;
import java.util.ArrayList;

public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;
    private DoublyLinkedList quickSorted;
    private DoublyLinkedList mergeSorted;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void sort(String col, int order) {
        QuickSort quickSort = new QuickSort(buildList(col));
        this.quickSorted = quickSort.sort(order);
        Metric m1 = new Metric("Quick Sort", quickSort.getTime(), quickSort.getComparisons(),
                quickSort.getSwaps());

        MergeSort mergeSort = new MergeSort(buildList(col));
        this.mergeSorted = mergeSort.sort(order);
        Metric m2 = new Metric("Merge Sort", mergeSort.getTime(), mergeSort.getComparisons(),
                mergeSort.getSwaps());

        askToPrintCSV();
        printMetrics(m1, m2);

    }

    public DoublyLinkedList buildList(String col) {
        DoublyLinkedList list = new DoublyLinkedList();
        DAO dao = new DAO();
        try {
            list = dao.read();
            list.SetColumnToCompare(col);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public void printMetrics(Metric m1, Metric m2) {
        ArrayList<Metric> metrics = new ArrayList<>();
        metrics.add(m1);
        metrics.add(m2);
        DAOMetrics daoMetrics = new DAOMetrics(metrics);
        try {
            daoMetrics.writeCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void askToPrintCSV() {
        printCsv(this.quickSorted, "quickSorted.csv");
        printCsv(this.mergeSorted, "mergeSorted.csv");
    }

    public void printCsv(DoublyLinkedList list, String filename) {
        DAO dao = new DAO();
        try {
            dao.writeCSV(list, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
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
