public class Testing2 {
    public static void main(String[] args) {
        boolean shouldContinue = true;
        Menu menu = new Menu();
        DAO dao = new DAO();
        DoublyLinkedList list = new DoublyLinkedList();

        try {
            list = dao.read();
            dao.read();
        } catch (Exception e) {
            e.printStackTrace();
        }

        while (shouldContinue) {
            String col = menu.pickColumn();
            int dir = menu.pickDirection();
            list.SetColumnToCompare(col);
            list.sort(dir);
            shouldContinue = menu.shouldContinue();
        }

    }
}
