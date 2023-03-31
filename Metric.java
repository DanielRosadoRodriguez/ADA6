/**
 * La clase Metric representa las métricas de un algoritmo de ordenamiento.
 */
public class Metric {
    private String algorithmName;
    private long time;
    private int comparisons;
    private int swaps;

    /**
     * Constructor de la clase Metric.
     * @param algorithmName El nombre del algoritmo.
     * @param time El tiempo de ejecución en milisegundos.
     * @param comparisons El número de comparaciones realizadas.
     * @param swaps El número de intercambios realizados.
     */
    public Metric(String algorithmName, long time, int comparisons, int swaps) {
        this.algorithmName = algorithmName;
        this.time = time;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }

    /**
     * Método para obtener el nombre del algoritmo.
     * @return El nombre del algoritmo.
     */
    public String getAlgorithmName() {
        return algorithmName;
    }

    /**
     * Método para establecer el nombre del algoritmo.
     * @param algorithmName El nombre del algoritmo.
     */
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }

    /**
     * Método para obtener el tiempo de ejecución en milisegundos.
     * @return El tiempo de ejecución en milisegundos.
     */
    public long getTime() {
        return time;
    }

    /**
     * Método para establecer el tiempo de ejecución en milisegundos.
     * @param time El tiempo de ejecución en milisegundos.
     */
    public void setTime(long time) {
        this.time = time;
    }

    /**
     * Método para obtener el número de comparaciones realizadas.
     * @return El número de comparaciones realizadas.
     */
    public int getComparisons() {
        return comparisons;
    }

    /**
     * Método para establecer el número de comparaciones realizadas.
     * @param comparisons El número de comparaciones realizadas.
     */
    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }

    /**
     * Método para obtener el número de intercambios realizados.
     * @return El número de intercambios realizados.
     */
    public int getSwaps() {
        return swaps;
    }

    /**
     * Método para establecer el número de intercambios realizados.
     * @param swaps El número de intercambios realizados.
     */
    public void setSwaps(int swaps) {
        this.swaps = swaps;
    } 
}
