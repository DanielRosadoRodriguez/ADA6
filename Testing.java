
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.sort("fixedAcidity", 2);
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
