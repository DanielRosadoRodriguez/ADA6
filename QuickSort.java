public class QuickSort extends Sort {

    public QuickSort(DoublyLinkedList list) {
        super(list);
    }

    public void sortAsc() {
        quickSort();
    }

    public void sortDesc() {
        quickSortDesc();
    }

    public void quickSort() {
        quickSortRecursive(this.list.getFirst(), this.list.getLast());
    }

    private void quickSortRecursive(DoublyLink left, DoublyLink right) {
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            return;
        }
        this.numberOfComparisons++;
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
                this.numberOfComparisons++;
                this.swap(i, j);
            }
            this.numberOfComparisons++;
        }
        i = (i == null) ? left : i.getNext();
        this.numberOfComparisons++;
        this.swap(i, right);
        return i;
    }

    public void quickSortDesc() {
        quickSortRecursiveDesc(this.list.getFirst(), this.list.getLast());
    }

    private void quickSortRecursiveDesc(DoublyLink left, DoublyLink right) {
        if (left == null || right == null || left == right || left.getPrevious() == right) {
            return;
        }
        this.numberOfComparisons++;

        DoublyLink pivot = partitionDesc(left, right);
        quickSortRecursiveDesc(left, pivot.getPrevious());
        quickSortRecursiveDesc(pivot.getNext(), right);
    }

    private DoublyLink partitionDesc(DoublyLink left, DoublyLink right) {
        DoublyLink pivot = right;
        DoublyLink i = left.getPrevious();
        for (DoublyLink j = left; j != right; j = j.getNext()) {
            if ((float) j.getWine().getValueToCompare() > (float) pivot.getWine().getValueToCompare()) {
                i = (i == null) ? left : i.getNext();
                this.numberOfComparisons++;

                this.swap(i, j);
            }
            this.numberOfComparisons++;
        }
        i = (i == null) ? left : i.getNext();
        this.numberOfComparisons++;
        this.swap(i, right);
        return i;
    }

}
