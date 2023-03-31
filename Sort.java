/**
 * Clase abstracta que define el comportamiento de los algoritmos de
 * ordenamiento.
 * 
 * Esta clase contiene los métodos y propiedades comunes a todos los algoritmos
 * de ordenamiento,
 * como la lista a ordenar, el número de intercambios y comparaciones realizados
 * y el tiempo
 * de ejecución de la ordenación. También define los métodos abstractos
 * sortAsc() y sortDesc()
 * que deberán ser implementados por las subclases de acuerdo a su algoritmo de
 * ordenamiento.
 */
public abstract class Sort {

    /**
     * La lista de elementos a ordenar.
     */
    protected DoublyLinkedList list;

    /**
     * El número de intercambios realizados durante la ordenación.
     */
    protected int numberOfSwaps = 0;

    /**
     * El número de comparaciones realizadas durante la ordenación.
     */
    protected int numberOfComparisons = 0;

    /**
     * El tiempo de ejecución de la ordenación en milisegundos.
     */
    protected long time = 0;

    /**
     * Constructor que recibe la lista a ordenar.
     * 
     * @param list La lista de elementos a ordenar.
     */
    public Sort(DoublyLinkedList list) {
        this.list = list;
    }

    /**
     * Intercambia los elementos de dos nodos de la lista.
     * 
     * @param a El primer nodo a intercambiar.
     * @param b El segundo nodo a intercambiar.
     */
    protected void swap(DoublyLink a, DoublyLink b) {
        Wine temp = a.getWine();
        a.setWine(b.getWine());
        b.setWine(temp);
        numberOfSwaps++;
    }

    /**
     * Ordena la lista en el sentido ascendente o descendente, dependiendo del valor
     * del parámetro direction.
     * 
     * @param direction El sentido de la ordenación. Si es 1, se ordena en sentido
     *                  ascendente,
     *                  de lo contrario, se ordena en sentido descendente.
     * @return La lista ordenada.
     */
    public DoublyLinkedList sort(int direction) {
        if (direction == 1) {
            this.time = calcularTiempoDeEjecucion(() -> {
                sortAsc();
            });
        } else {
            this.time = calcularTiempoDeEjecucion(() -> {
                sortDesc();
            });
        }
        return this.list;
    }

    /**
     * Ordena la lista en sentido ascendente.
     */
    public abstract void sortAsc();

    /**
     * Ordena la lista en sentido descendente.
     */
    public abstract void sortDesc();

    /**
     * Calcula el tiempo de ejecución de un método.
     * 
     * @param runnable La interfaz funcional Runnable que representa el método a
     *                 medir.
     * @return El tiempo de ejecución en milisegundos.
     */
    public long calcularTiempoDeEjecucion(Runnable runnable) {
        long tiempoInicio = System.currentTimeMillis();
        runnable.run();
        long tiempoFinal = System.currentTimeMillis();
        return tiempoFinal - tiempoInicio;
    }

    /**
     * Obtiene el tiempo de ejecución de la última ordenación realizada.
     * 
     * @return El tiempo de ejecución en milisegundos.
     */
    public long getTime() {
        return time;
    }

    /**
     * Obtiene el número de intercambios realizados durante el proceso de
     * ordenamiento.
     *
     * @return número de intercambios realizados durante el proceso de ordenamiento
     */
    public int getSwaps() {
        return numberOfSwaps;
    }

    /**
     * Obtiene el número de comparaciones realizadas durante el proceso de
     * ordenamiento.
     *
     * @return número de comparaciones realizadas durante el proceso de ordenamiento
     */
    public int getComparisons() {
        return numberOfComparisons;
    }

}
