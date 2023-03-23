
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.SetColumnToCompare("color");
            list.sort();
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
