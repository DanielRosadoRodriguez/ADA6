import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAO {
    public void read() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList();
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataset\\Wine_Quality_Data.csv"));
            String line;
            line = br.readLine(); // Reads the first line (headers row)
            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
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
    }
}