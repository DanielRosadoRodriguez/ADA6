import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class DAOMetrics {
    private ArrayList<Metric> metrics;

    public DAOMetrics(ArrayList<Metric> metrics) {
        this.metrics = metrics;
    }

    public void writeCSV() throws IOException{
        // Crear archivo CSV para escritura
        FileWriter csvWriter = new FileWriter("metrics.csv");

        String[] headers = { "algorithm", "time", "comparisons", "swaps" };

        csvWriter.write(String.join(",", headers) + "\n");

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

    public ArrayList<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(ArrayList<Metric> metrics) {
        this.metrics = metrics;
    }

}
