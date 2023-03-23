public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }


    public void add(Wine wine) {
        DoublyLink newLink = new DoublyLink(wine);
        if (isEmpty()) {
            first = newLink;
        } else {
            last.setNext(newLink);
            newLink.setPrevious(last);
        }
        last = newLink;
        size++;
    }
    /**
     * imprime el contenido de la lista
     */
    public void displayList() {
        DoublyLink current = first;
        if (isEmpty()) {
            System.out.println("la lista está vacía");
        }
        System.out.print("first->");
        while (current != null) {
            System.out.print(current.getWine().getValueToCompare() + "->");
            current = current.getNext();
        }
        System.out.println("last");
    }

    public DoublyLink getFirst(){
        return this.first;
    }

    public boolean isEmpty() {
        return first == null;
    }

    public int getSize() {
        return size;
    }
    public void setColumnToCompare(String colToCompare){
        while(first != null){
            first.getWine().setValueToCompare(colToCompare);
            first = first.getNext();
        }
    }

 
}
