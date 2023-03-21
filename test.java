public class test {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.add(9);
        list.add(0);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(5);
        System.out.println("Unsorted:");
        list.printList();
        list.simpleSort();
        System.out.println("Sorted:");
        list.printList();   
    }
}
