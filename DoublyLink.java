/**
 * La clase DoublyLink representa un nodo de una lista doblemente enlazada.
 * Cada nodo contiene una referencia al objeto Wine y a los nodos anterior y siguiente.
 */
public class DoublyLink  {
    
    /**
     * El objeto Wine almacenado en el nodo.
     */
    private Wine data;
    
    /**
     * La referencia al siguiente nodo.
     */
    private DoublyLink next;
    
    /**
     * La referencia al nodo anterior.
     */
    private DoublyLink previous;

    /**
     * Constructor que crea un nodo y lo inicializa con el objeto Wine especificado.
     *
     * @param d el objeto Wine que se va a almacenar en el nodo.
     */
    public DoublyLink(Wine d) {
        this.data = d;
    }
 
    /**
     * Obtiene el objeto Wine almacenado en el nodo.
     *
     * @return el objeto Wine almacenado en el nodo.
     */
    public Wine getWine(){
        return data;
    }
    
    /**
     * Establece el objeto Wine almacenado en el nodo.
     *
     * @param d el objeto Wine que se va a almacenar en el nodo.
     */
    public void setWine(Wine d){
        this.data = d;
    }
    
    /**
     * Obtiene la referencia al siguiente nodo.
     *
     * @return la referencia al siguiente nodo.
     */
    public DoublyLink getNext() {
        return next;
    }
    
    /**
     * Establece la referencia al siguiente nodo.
     *
     * @param next la referencia al siguiente nodo.
     */
    public void setNext(DoublyLink next) {
        this.next = next;
    }
    
    /**
     * Obtiene la referencia al nodo anterior.
     *
     * @return la referencia al nodo anterior.
     */
    public DoublyLink getPrevious() {
        return previous;
    }
    
    /**
     * Establece la referencia al nodo anterior.
     *
     * @param previous la referencia al nodo anterior.
     */
    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }

}
