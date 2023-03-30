
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.SetColumnToCompare("fixedAcidity");
            list.sort(0);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
