/**
 * Clase principal, inicializa el programa y el menú de opciones
 */
public class SortingApp {
    /**
     * 
     * Método principal de la clase Testing2 que crea instancias de Menu y DAO para
     * leer una lista de vinos
     * desde un archivo csv y utiliza la función sort() de DoublyLinkedList
     * para ordenarla según la columna seleccionada y la dirección de ordenación
     * especificada por el usuario.
     * 
     * @param args los argumentos de la línea de comandos los cuales no se utilizan en este método.
     */

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
