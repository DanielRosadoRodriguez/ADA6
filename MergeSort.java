public class MergeSort extends Sort {

    public MergeSort(DoublyLinkedList list) {
        super(list);
    }

    public void sortAsc() {
        mergeSort();
    }

    public void sortDesc() {
        mergeSortDesc();
    }

    public void mergeSort() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursive(this.list.getFirst()));
        }
        this.numberOfComparisons++;
    }

    private DoublyLink mergeSortRecursive(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            this.numberOfComparisons++;
            return head;
        }
        this.numberOfComparisons++;

        DoublyLink middle = getMiddle(head);
        DoublyLink nextToMiddle = middle.getNext();
        middle.setNext(null);

        DoublyLink left = mergeSortRecursive(head);
        DoublyLink right = mergeSortRecursive(nextToMiddle);

        return merge(left, right);
    }

    private DoublyLink merge(DoublyLink left, DoublyLink right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        this.numberOfComparisons++;
        this.numberOfComparisons++;

        if ((float) left.getWine().getValueToCompare() < (float) right.getWine().getValueToCompare()) {
            this.numberOfComparisons++;
            numberOfSwaps++;
            left.setNext(merge(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            numberOfSwaps++;
            this.numberOfComparisons++;
            this.numberOfComparisons++;
            right.setNext(merge(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
    }

    private DoublyLink getMiddle(DoublyLink head) {
        if (head == null) {
            this.numberOfComparisons++;
            return null;
        }
        this.numberOfComparisons++;

        DoublyLink next = head;
        DoublyLink current = head.getNext();

        while (current != null) {
            this.numberOfComparisons++;
            current = current.getNext();
            if (current != null) {
                next = next.getNext();
                current = current.getNext();
            }
        }
        return next;
    }

    public void mergeSortDesc() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursiveDesc(this.list.getFirst()));
        }
        this.numberOfComparisons++;
    }

    private DoublyLink mergeSortRecursiveDesc(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            this.numberOfComparisons++;
            return head;
        }
        this.numberOfComparisons++;
        DoublyLink middle = getMiddle(head);
        DoublyLink nextToMiddle = middle.getNext();
        middle.setNext(null);
        DoublyLink left = mergeSortRecursiveDesc(head);
        DoublyLink right = mergeSortRecursiveDesc(nextToMiddle);

        return mergeDesc(left, right);
    }

    private DoublyLink mergeDesc(DoublyLink left, DoublyLink right) {
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        this.numberOfComparisons++;
        this.numberOfComparisons++;
        if ((float) left.getWine().getValueToCompare() >= (float) right.getWine().getValueToCompare()) {
            this.numberOfComparisons++;
            numberOfSwaps++;
            left.setNext(mergeDesc(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            this.numberOfComparisons++;
            this.numberOfComparisons++;
            numberOfSwaps++;
            right.setNext(mergeDesc(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
    }

}
