
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.displayList();
            list.simpleSortFloat();
            list.displayList();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    
}
