
public class Testing {
    public static void main(String[] args) {
        DAO dao = new DAO();
        try {
            DoublyLinkedList list = dao.read();
            list.SetColumnToCompare("fixedAcidity");
            // list.displayList();
            // list.sort();
            // list = dao.read();
            // list.displayList();
            list.binaryInsertionSort(list.getSize());
            list.displayList();


        
        } catch (Exception e) {
            e.printStackTrace();
        }  
    }
    
}
