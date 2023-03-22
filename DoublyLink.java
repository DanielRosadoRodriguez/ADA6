public class DoublyLink{
    private Wine data;
    private Object valueToCompare;
    private DoublyLink next;
    private DoublyLink previous;

    public DoublyLink(Wine d) {
        this.data = d;
    }

    public void setValueToCompare(String colName){
        this.valueToCompare = data.getValueToCompare(colName);
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
    public Object getValueToCompare() {
        return valueToCompare;
    }
    public void setValueToCompare(Object valueToCompare) {
        this.valueToCompare = valueToCompare;
    }

}
