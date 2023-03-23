
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.bubbleSort();
            list.displayList();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
    
}
