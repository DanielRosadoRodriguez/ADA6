public class DoublyLink{
    private Wine data;
    private DoublyLink next;
    private DoublyLink previous;

    public DoublyLink(Wine d) {
        this.data = d;
    }

    public Wine getWine(){
        return data;
    }
    public void setWine(Wine d){
        this.data = d;
    }
    public DoublyLink getNext() {
        return next;
    }
    public void setNext(DoublyLink next) {
        this.next = next;
    }
    public DoublyLink getPrevious() {
        return previous;
    }
    public void setPrevious(DoublyLink previous) {
        this.previous = previous;
    }

}
