public class Testing2 {
    public static void main(String[] args) {
        Menu menu = new Menu();
        DAO dao = new DAO();
        DoublyLinkedList list = new DoublyLinkedList();

        try {
            list = dao.read();
            dao.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

            String col = menu.pickColumn();
            int dir = menu.pickDirection();
            list.sort(col, dir);

    }
}
