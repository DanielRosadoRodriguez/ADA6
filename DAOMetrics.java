import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Clase que representa un DAO (Data Access Object) para métricas.
 * Permite escribir las métricas en un archivo CSV y obtenerlas.
 */
public class DAOMetrics {
    private ArrayList<Metric> metrics;

    /**
     * Constructor de la clase DAOMetrics.
     * @param metrics Lista de métricas a almacenar.
     */
    public DAOMetrics(ArrayList<Metric> metrics) {
        this.metrics = metrics;
    }

    /**
     * Método que permite escribir las métricas almacenadas en un archivo CSV.
     * @throws IOException Si ocurre un error al escribir el archivo.
     */
    public void writeCSV() throws IOException{
        // Crear archivo CSV para escritura
        FileWriter csvWriter = new FileWriter("metrics.csv");

        String[] headers = { "algorithm", "time", "comparisons", "swaps" };

        csvWriter.write(String.join(",", headers) + "\n");

        // Escribir cada métrica en el archivo CSV
        for (Metric metric : metrics) {
            csvWriter.write(metric.getAlgorithmName());
            csvWriter.append(",");
            csvWriter.write(Long.toString(metric.getTime()));
            csvWriter.append(",");
            csvWriter.write(Long.toString(metric.getComparisons()));
            csvWriter.append(",");
            csvWriter.write(Long.toString(metric.getSwaps()));
            csvWriter.append("\n");
        }

        // Cerrar archivo CSV
        csvWriter.close();

    }

    /**
     * Método que permite obtener la lista de métricas almacenadas.
     * @return Lista de métricas almacenadas.
     */
    public ArrayList<Metric> getMetrics() {
        return metrics;
    }

    /**
     * Método que permite establecer la lista de métricas almacenadas.
     * @param metrics Nueva lista de métricas a almacenar.
     */
    public void setMetrics(ArrayList<Metric> metrics) {
        this.metrics = metrics;
    }

}
