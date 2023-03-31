/**
 * Segunda clase principal la cual facilita el proceso de pruebas ignorando el menú de opciones
 */
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.sort("fixedAcidity", 1);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
