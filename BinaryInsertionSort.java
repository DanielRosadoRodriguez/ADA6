/**
 * Clase que implementa el algoritmo de ordenamiento por inserción binaria.
 * Extiende de la clase Sort.
 */
public class BinaryInsertionSort extends Sort {

    private int n;

    /**
     * Constructor de la clase.
     * 
     * @param list la lista a ordenar.
     */
    public BinaryInsertionSort(DoublyLinkedList list) {
        super(list);
        n = list.getSize();
    }

    /**
     * Realiza una búsqueda binaria para encontrar la posición donde insertar un
     * elemento en orden ascendente.
     * 
     * @param item el elemento a insertar.
     * @param low  el índice inferior del rango de búsqueda.
     * @param high el índice superior del rango de búsqueda.
     * @return la posición donde insertar el elemento.
     */
    public int binarySearch(Wine item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((Float) item.getValueToCompare() == (Float) list.get(mid).getValueToCompare()) {
                this.numberOfComparisons++;
                return mid + 1;
            } else if ((Float) item.getValueToCompare() > (Float) list.get(mid).getValueToCompare()) {
                this.numberOfComparisons += 2;
                low = mid + 1;
            } else {
                this.numberOfComparisons += 2;
                high = mid - 1;
            }

        }
        return low;
    }

    /**
     * Realiza una búsqueda binaria para encontrar la posición donde insertar un
     * elemento en orden descendente.
     * 
     * @param item el elemento a insertar.
     * @param low  el índice inferior del rango de búsqueda.
     * @param high el índice superior del rango de búsqueda.
     * @return la posición donde insertar el elemento.
     */
    public int binarySearchDesc(Wine item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((Float) item.getValueToCompare() == (Float) list.get(mid).getValueToCompare()) {
                this.numberOfComparisons++;
                return mid + 1;
            } else if ((Float) item.getValueToCompare() < (Float) list.get(mid).getValueToCompare()) { // cambiar el
                                                                                                       // orden de
                                                                                                       // comparación
                this.numberOfComparisons += 2;
                low = mid + 1;
            } else {
                this.numberOfComparisons += 2;
                high = mid - 1;
            }
        }
        return low;
    }

    /**
     * Ordena la lista en orden ascendente utilizando el algoritmo de inserción
     * binaria.
     */
    public void sortAsc() {
        try {
            int i, loc = 0, j;
            Wine selected;

            for (i = 1; i < n; ++i) {
                j = i - 1;
                selected = list.get(i);
                loc = binarySearch(selected, 0, j);
                while (j >= loc) {
                    list.updateNodeWithPosition(j + 1, list.get(j));
                    this.numberOfSwaps++;
                    j--;
                }
                list.updateNodeWithPosition(j + 1, selected);
                this.numberOfSwaps++;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * Ordena la lista en orden descendente utilizando el algoritmo de inserción
     * binaria.
     */
    public void sortDesc() {
        try {
            int i, loc = 0, j;
            Wine selected;

            for (i = 1; i < n; ++i) {
                j = i - 1;
                selected = list.get(i);
                loc = binarySearchDesc(selected, 0, j);
                while (j >= loc) {
                    list.updateNodeWithPosition(j + 1, list.get(j));
                    j--;
                }
                list.updateNodeWithPosition(j + 1, selected);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
