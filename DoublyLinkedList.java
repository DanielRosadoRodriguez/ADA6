import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que implementa una lista doblemente enlazada
 */
public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;
    private DoublyLinkedList quickSorted;
    private DoublyLinkedList mergeSorted;
    private DoublyLinkedList binaryInsertionSorted;
    private DoublyLinkedList radixSorted;

    /**
     * Constructor de la clase
     */
    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 
     * Este método ordena una lista de objetos en función de una columna específica
     * usando cuatro algoritmos de ordenación diferentes:
     * 
     * QuickSort, MergeSort, BinaryInsertionSort y RadixSort.
     * 
     * @param col   el nombre de la columna por la cual se ordenará la lista.
     * 
     * @param order el orden de clasificación (1 para ascendente, 2 para
     *              descendente).
     */
    public void sort(String col, int order) {
        QuickSort quickSort = new QuickSort(buildList(col));
        this.quickSorted = quickSort.sort(order);
        Metric m1 = new Metric("Quick Sort", quickSort.getTime(), quickSort.getComparisons(),
                quickSort.getSwaps());

        MergeSort mergeSort = new MergeSort(buildList(col));
        this.mergeSorted = mergeSort.sort(order);
        Metric m2 = new Metric("Merge Sort", mergeSort.getTime(), mergeSort.getComparisons(),
                mergeSort.getSwaps());

        BinaryInsertionSort binaryInsertionSort = new BinaryInsertionSort(buildList(col));
        this.binaryInsertionSorted = binaryInsertionSort.sort(order);
        Metric m3 = new Metric("Binary Insertion Sort", binaryInsertionSort.getTime(),
                binaryInsertionSort.getComparisons(), binaryInsertionSort.getSwaps());
        RadixSort radixSort = new RadixSort(buildList(col));
        this.radixSorted = radixSort.sort(order);
        Metric m4 = new Metric("Radix Sort", radixSort.getTime(), radixSort.getComparisons(),
                radixSort.getSwaps());

        askToPrintCSV();
        printMetrics(m1, m2, m3, m4);

    }

    /**
     * 
     * Este método construye una lista doblemente enlazada a partir de un archivo de
     * datos proporcionado por un objeto DAO.
     * Luego, establece la columna por la cual se compararán los elementos de la
     * lista.
     * 
     * @param col el nombre de la columna por la cual se compararán los elementos de
     *            la lista.
     * @return la lista doblemente enlazada construida a partir del archivo de
     *         datos.
     */
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

    /**
     * Este método imprime las métricas de tiempo, comparaciones y swaps para cada
     * uno de los cuatro algoritmos de ordenación utilizados.
     * Las métricas se almacenan en un objeto Metric y se escriben en un archivo CSV
     * utilizando un objeto DAOMetrics.
     * 
     * @param m1 el objeto Metric para QuickSort.
     * @param m2 el objeto Metric para MergeSort.
     * @param m3 el objeto Metric para BinaryInsertionSort.
     * @param m4 el objeto Metric para RadixSort.
     * 
     */
    public void printMetrics(Metric m1, Metric m2, Metric m3, Metric m4) {
        ArrayList<Metric> metrics = new ArrayList<>();
        metrics.add(m1);
        metrics.add(m2);
        metrics.add(m3);
        metrics.add(m4);
        DAOMetrics daoMetrics = new DAOMetrics(metrics);
        try {
            daoMetrics.writeCSV();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    /**
     * 
     * Este método llama al método printCsv para imprimir cada una de las cuatro
     * listas ordenadas en archivos CSV separados.
     */
    public void askToPrintCSV() {
        printCsv(this.quickSorted, "quickSorted.csv");
        printCsv(this.mergeSorted, "mergeSorted.csv");
        printCsv(this.binaryInsertionSorted, "binaryInsertionSorted.csv");
        printCsv(this.radixSorted, "radixSorted.csv");
    }

    /**
     * 
     * Este método escribe una lista doblemente enlazada en un archivo CSV
     * utilizando un objeto DAO.
     * 
     * @param list     la lista doblemente enlazada que se escribirá en el archivo
     *                 CSV.
     * @param filename el nombre del archivo CSV en el que se escribirá la lista.
     */
    public void printCsv(DoublyLinkedList list, String filename) {
        DAO dao = new DAO();
        try {
            dao.writeCSV(list, filename);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Este método agrega un objeto Wine a la lista doblemente enlazada.
     * 
     * @param wine el objeto Wine que se agregará a la lista.
     */
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

    /**
     * 
     * Este método establece la columna que se utilizará para comparar los objetos
     * Wine en la lista doblemente enlazada.
     * 
     * @param columnToCompare el nombre de la columna que se utilizará para comparar
     *                        los objetos Wine.
     */
    public void SetColumnToCompare(String columnToCompare) {
        DoublyLink current = first;
        while (current != null) {
            current.getWine().setValueToCompare(columnToCompare);
            current = current.getNext();
        }
    }

    /**
     * imprime el contenido de la lista this
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

    /**
     * imprime el contenido de la lista que se pasa como parámetro
     * 
     * @param list la lista que se imprimirá
     */
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

    /**
     * Este método indica si la lista está vacía
     * 
     * @return
     */
    public boolean isEmpty() {
        return first == null;
    }

    /**
     * Este método borra el contenido de la lista this
     */
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    /**
     * 
     * Este método devuelve el objeto Wine en el índice especificado de la lista
     * doblemente enlazada.
     * 
     * @param index el índice del objeto Wine que se desea obtener.
     * @return el objeto Wine en el índice especificado.
     */
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

    /**
     * 
     * Este método actualiza el objeto Wine en la posición especificada de la lista
     * doblemente enlazada.
     * 
     * @param nodePosition la posición del objeto Wine que se desea actualizar.
     * @param newValue     el nuevo valor del objeto Wine.
     * @throws Exception si la lista está vacía o la posición especificada no existe
     *                   en la lista.
     */
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

    /**
     * Develve el primer elemento de la lista
     * @return el primer elemento de la lista
     */
    public DoublyLink getFirst() {
        return first;
    }

    /**
     * Establece el primer elemento de la lista
     * @param first el primer elemento de la lista
     */
    public void setFirst(DoublyLink first) {
        this.first = first;
    }

    /**
     * Devuelve el último elemento de la lista
     * @return el último elemento de la lista
     */
    public DoublyLink getLast() {
        return last;
    }

    /**
     * Establece el último elemento de la lista
     * @param last el último elemento de la lista
     */
    public void setLast(DoublyLink last) {
        this.last = last;
    }

    /**
     * Devuelve el tamaño de la lista
     * @return el tamaño de la lista
     */
    public int getSize() {
        return size;
    }

    /**
     * Establece el tamaño de la lista
     * @param size el tamaño de la lista
     */
    public void setSize(int size) {
        this.size = size;
    }

}
