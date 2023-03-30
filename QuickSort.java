public class QuickSort extends Sort {

    public QuickSort(DoublyLinkedList list) {
        super(list);
    }

    public DoublyLinkedList sort() {
        this.time = calcularTiempoDeEjecucion(() -> {
            quickSortRecursive(this.list.getFirst(), this.list.getLast());
        });
        return this.list;
    }

    private void quickSortRecursive(DoublyLink left, DoublyLink right) {
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            return;
        }

        DoublyLink pivot = partition(left, right);
        quickSortRecursive(left, pivot.getPrevious());
        quickSortRecursive(pivot.getNext(), right);
    }

    private DoublyLink partition(DoublyLink left, DoublyLink right) {
        DoublyLink pivot = right;
        DoublyLink i = left.getPrevious();
        for (DoublyLink j = left; j != right; j = j.getNext()) {
            if ((float) j.getWine().getValueToCompare() < (float) pivot.getWine().getValueToCompare()) {
                i = (i == null) ? left : i.getNext();
                this.swap(i, j);
            }
        }
        i = (i == null) ? left : i.getNext();
        this.swap(i, right);
        return i;
    }
}
