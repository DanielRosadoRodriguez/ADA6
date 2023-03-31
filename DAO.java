import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Clase DAO
 */
public class DAO {
    public DoublyLinkedList read() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList();
        try {

            BufferedReader br = new BufferedReader(new FileReader("dataset\\Wine_Quality_Data_1000.csv"));
            String line;
            line = br.readLine(); // Reads the first line (headers row)
            String[] datos = line.split(",");
            while ((line = br.readLine()) != null) {
                datos = line.split(",");
                float fixedAcidity = Float.parseFloat(datos[0]);
                float volatileAcidity = Float.parseFloat(datos[1]);
                float citricAcid = Float.parseFloat(datos[2]);
                float residualSugar = Float.parseFloat(datos[3]);
                float chlorides = Float.parseFloat(datos[4]);
                float freeSulfurDioxide = Float.parseFloat(datos[5]);
                float totalSulfurDioxide = Float.parseFloat(datos[6]);
                float density = Float.parseFloat(datos[7]);
                float pH = Float.parseFloat(datos[8]);
                float sulphates = Float.parseFloat(datos[9]);
                float alcohol = Float.parseFloat(datos[10]);
                float quality = Float.parseFloat(datos[11]);
                String color = datos[12];
                Wine wine = new Wine(fixedAcidity, volatileAcidity, citricAcid, residualSugar, chlorides,
                        freeSulfurDioxide, totalSulfurDioxide, density, pH, sulphates, alcohol, quality, color);

                list.add(wine);
            }
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    public void writeCSV(DoublyLinkedList list, String fileName) throws IOException {
        // Crear archivo CSV para escritura
        FileWriter csvWriter = new FileWriter("sorted/"+fileName);

        // Escribir encabezado de columnas

        String[] headers = { "Fixed Acidity", "Volatile Acidity", "Citric Acid", "Residual Sugar", "Chlorides",
                "Free Sulfur Dioxide", "Total Sulfur Dioxide", "Density", "pH", "Sulphates", "Alcohol", "Quality",
                "Color" };
        csvWriter.write(String.join(",", headers) + "\n");

        // Escribir datos de cada fila

        DoublyLink current = list.getFirst();
        while (current != null) {
            csvWriter.write(Float.toString(current.getWine().getFixedAcidity()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getVolatileAcidity()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getCitricAcid()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getResidualSugar()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getChlorides()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getFreeSulfurDioxide()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getTotalSulfurDioxide()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getDensity()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getpH()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getSulphates()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getAlcohol()));
            csvWriter.append(",");

            csvWriter.write(Float.toString(current.getWine().getQuality()));
            csvWriter.append(",");

            csvWriter.write(current.getWine().getColor());
            csvWriter.append(",");

            csvWriter.append("\n");

            current = current.getNext();
        }

        // Cerrar archivo CSV
        csvWriter.close();
    }

}
