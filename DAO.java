import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class DAO {
    public void read() throws Exception {
        DoublyLinkedList list = new DoublyLinkedList<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader("dataset\\Wine_Quality_Data.csv"));
            String line;
            line = br.readLine(); // Reads the first line (headers row)
            String[] headers = line.split(","); // Stores the name of all headers so that we can create our object

            while ((line = br.readLine()) != null) {
                String[] datos = line.split(",");
                Movie movie = new Movie(datos);
                DoublyLink node = new DoublyLink(movie);
                list.add(movie);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}