/**
 * Clase que implementa el algoritmo de ordenamiento QuickSort para ordenar una
 * lista de vinos.
 */
public class QuickSort extends Sort {

    /**
     * Constructor de la clase.
     * 
     * @param list La lista de vinos a ordenar.
     */
    public QuickSort(DoublyLinkedList list) {
        super(list);
    }

    /**
     * Ordena la lista en orden ascendente utilizando el algoritmo QuickSort.
     */
    public void sortAsc() {
        quickSort();
    }

    /**
     * Ordena la lista en orden descendente utilizando el algoritmo QuickSort.
     */
    public void sortDesc() {
        quickSortDesc();
    }

    /**
     * Método privado que llama al método quickSortRecursive con los parámetros
     * iniciales.
     */
    private void quickSort() {
        quickSortRecursive(this.list.getFirst(), this.list.getLast());
    }

    /**
     * Método privado que ordena la lista de manera recursiva utilizando el
     * algoritmo QuickSort.
     * 
     * @param left  El primer elemento de la lista o sublista a ordenar.
     * @param right El último elemento de la lista o sublista a ordenar.
     */
    private void quickSortRecursive(DoublyLink left, DoublyLink right) {
        // Caso base: la lista o sublista tiene menos de dos elementos.
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            this.numberOfComparisons++;
            return;
        }
        this.numberOfComparisons++;

        // Seleccionamos el pivote y lo ubicamos en su posición final.
        DoublyLink pivot = partition(left, right);

        // Ordenamos las sublistas izquierda y derecha recursivamente.
        quickSortRecursive(left, pivot.getPrevious());
        quickSortRecursive(pivot.getNext(), right);
    }

    /**
     * Método privado que particiona la lista o sublista en dos, utilizando un
     * pivote.
     * 
     * @param left  El primer elemento de la lista o sublista a particionar.
     * @param right El último elemento de la lista o sublista a particionar.
     * @return El elemento pivote, ubicado en su posición final.
     */
    private DoublyLink partition(DoublyLink left, DoublyLink right) {
        // Seleccionamos el pivote (el último elemento de la sublista) y el índice i.
        DoublyLink pivot = right;
        DoublyLink i = left.getPrevious();

        // Recorremos la sublista desde el primer elemento hasta el penúltimo.
        for (DoublyLink j = left; j != right; j = j.getNext()) {
            // Si el valor del elemento j es menor al valor del pivote, lo movemos a la
            // izquierda.
            if ((float) j.getWine().getValueToCompare() < (float) pivot.getWine().getValueToCompare()) {
                i = (i == null) ? left : i.getNext();
                this.numberOfComparisons++;
                this.swap(i, j);
            }
            this.numberOfComparisons++;
        }

        // Ubicamos el pivote en su posición final.
        i = (i == null) ? left : i.getNext();
        this.numberOfComparisons++;
        this.swap(i, right);
        return i;
    }

    /**
     * Método privado que ordena la lista en orden descendente utilizando el
     * algoritmo QuickSort.
     */
    private void quickSortDesc() {
        quickSortRecursiveDesc(this.list.getFirst(), this.list.getLast());

    }

    /**
     * 
     * Método privado que realiza la ordenación rápida de una lista doblemente
     * enlazada en orden descendente de manera recursiva.
     * 
     * @param left  El primer nodo de la lista.
     * 
     * @param right El último nodo de la lista.
     */
    private void quickSortRecursiveDesc(DoublyLink left, DoublyLink right) {
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            this.numberOfComparisons++;
            return;
        }
        this.numberOfComparisons++;

        DoublyLink pivot = partitionDesc(left, right);
        quickSortRecursiveDesc(left, pivot.getPrevious());
        quickSortRecursiveDesc(pivot.getNext(), right);
    }

    /**
     * 
     * Método privado que divide una lista doblemente enlazada en dos partes
     * utilizando un pivote y los reordena en orden descendente.
     * @param left  El primer nodo de la lista.
     * @param right El último nodo de la lista.
     * @return El pivote utilizado para la división de la lista.
     */
    private DoublyLink partitionDesc(DoublyLink left, DoublyLink right) {
        DoublyLink pivot = right;
        DoublyLink i = left.getPrevious();
        for (DoublyLink j = left; j != right; j = j.getNext()) {
            if ((float) j.getWine().getValueToCompare() > (float) pivot.getWine().getValueToCompare()) {
                i = (i == null) ? left : i.getNext();
                this.numberOfComparisons++;
                this.swap(i, j);
            }
            this.numberOfComparisons++;
        }
        i = (i == null) ? left : i.getNext();
        this.numberOfComparisons++;
        this.swap(i, right);
        return i;
    }
}
