/**
 * Segunda clase principal la cual facilita el proceso de pruebas ignorando el
 * menú de opciones
 */
public class Testing {
    /**
     * 
     * Método principal de la clase Testing. Lee una lista de vinos desde un archivo
     * de texto y la ordena según la
     * columna "fixedAcidity" en orden ascendente.
     * 
     * @param args los argumentos de la línea de comandos los cuales no se utilizan
     *             en este método.
     * 
     */
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
