/**
 * 
 * Clase MergeSort que extiende de la clase abstracta Sort.
 * 
 * Ordena una lista en orden ascendente o descendente usando el algoritmo Merge
 * Sort.
 */
public class MergeSort extends Sort {

    /**
     * 
     * Constructor de la clase MergeSort.
     * 
     * @param list Lista a ordenar.
     */
    public MergeSort(DoublyLinkedList list) {
        super(list);
    }

    /**
     * 
     * Ordena la lista en orden ascendente.
     */
    public void sortAsc() {
        mergeSort();
    }

    /**
     * 
     * Ordena la lista en orden descendente.
     */
    public void sortDesc() {
        mergeSortDesc();
    }

    /**
     * 
     * Método privado que ordena la lista en orden ascendente usando el algoritmo
     * Merge Sort.
     */
    private void mergeSort() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursive(this.list.getFirst()));
        }
        this.numberOfComparisons++;
    }

    private DoublyLink mergeSortRecursive(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            this.numberOfComparisons++;
            return head;
        }
        this.numberOfComparisons++;

        DoublyLink middle = getMiddle(head);
        DoublyLink nextToMiddle = middle.getNext();
        middle.setNext(null);

        DoublyLink left = mergeSortRecursive(head);
        DoublyLink right = mergeSortRecursive(nextToMiddle);

        return merge(left, right);
    }

    private DoublyLink merge(DoublyLink left, DoublyLink right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        this.numberOfComparisons++;
        this.numberOfComparisons++;

        if ((float) left.getWine().getValueToCompare() < (float) right.getWine().getValueToCompare()) {
            this.numberOfComparisons++;
            left.setNext(merge(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            numberOfSwaps++;
            this.numberOfComparisons++;
            this.numberOfComparisons++;
            right.setNext(merge(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
    }

    private DoublyLink getMiddle(DoublyLink head) {
        if (head == null) {
            this.numberOfComparisons++;
            return null;
        }
        this.numberOfComparisons++;

        DoublyLink next = head;
        DoublyLink current = head.getNext();

        while (current != null) {
            this.numberOfComparisons++;
            current = current.getNext();
            if (current != null) {
                next = next.getNext();
                current = current.getNext();
            }
        }
        return next;
    }

    /**
     * Ordena la lista doblemente enlazada actual en orden descendente utilizando el
     * algoritmo Merge Sort.
     * Si la lista está vacía, no hace nada.
     * El número de comparaciones realizadas durante la ordenación se almacena en la
     * variable numberOfComparisons.
     * Si durante la ordenación se realizan intercambios de elementos, se incrementa
     * la variable numberOfSwaps.
     */
    public void mergeSortDesc() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursiveDesc(this.list.getFirst()));
        }
        this.numberOfComparisons++;
    }

    /**
     * Función auxiliar que realiza la ordenación recursiva de la lista doblemente
     * enlazada actual en orden descendente
     * utilizando el algoritmo Merge Sort. Devuelve la cabeza de la lista ordenada.
     * 
     * @param head la cabeza de la lista a ordenar
     * @return la cabeza de la lista ordenada
     */
    private DoublyLink mergeSortRecursiveDesc(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            this.numberOfComparisons++;
            return head;
        }
        this.numberOfComparisons++;
        DoublyLink middle = getMiddle(head);
        DoublyLink nextToMiddle = middle.getNext();
        middle.setNext(null);
        DoublyLink left = mergeSortRecursiveDesc(head);
        DoublyLink right = mergeSortRecursiveDesc(nextToMiddle);

        return mergeDesc(left, right);
    }

    /**
     * Función auxiliar que fusiona dos listas doblemente enlazadas ordenadas en
     * orden descendente en una sola lista
     * doblemente enlazada ordenada en orden descendente. Devuelve la cabeza de la
     * lista fusionada.
     * 
     * @param left  la cabeza de la lista doblemente enlazada izquierda a fusionar
     * @param right la cabeza de la lista doblemente enlazada derecha a fusionar
     * @return la cabeza de la lista fusionada
     */
    private DoublyLink mergeDesc(DoublyLink left, DoublyLink right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        this.numberOfComparisons++;
        this.numberOfComparisons++;
        if ((float) left.getWine().getValueToCompare() >= (float) right.getWine().getValueToCompare()) {
            this.numberOfComparisons++;
            numberOfSwaps++;
            left.setNext(mergeDesc(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            this.numberOfComparisons++;
            this.numberOfComparisons++;
            numberOfSwaps++;
            right.setNext(mergeDesc(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
    }

}
