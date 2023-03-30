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
        DoublyLink result = null;

        if (left == null) {
            result = right;
            this.numberOfComparisons++;
        } else if (right == null) {
            result = left;
            this.numberOfComparisons++;
            this.numberOfComparisons++;
        } else {
            if ((float) left.getWine().getValueToCompare() < (float) right.getWine().getValueToCompare()) {
                result = left;
                result.setNext(merge(left.getNext(), right));
            } else {
                result = right;
                result.setNext(merge(left, right.getNext()));
  
            }
                this.numberOfComparisons++;
                this.numberOfComparisons++;
                this.numberOfComparisons++;

            result.getNext().setPrevious(result);
            result.setPrevious(null);

            if (left != null && right != null) {
                this.swap(left, right);
            }
            this.numberOfComparisons++;
        }

        return result;
    }

    private DoublyLink getMiddle(DoublyLink head) {
        if (head == null) {
            return null;
        }
            this.numberOfComparisons++;

        DoublyLink slow = head;
        DoublyLink fast = head.getNext();

        while (fast != null) {
            fast = fast.getNext();
            if (fast != null) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
                this.numberOfComparisons++;
        }

        return slow;
    }

    public void mergeSortDesc() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursiveDesc(this.list.getFirst()));
        }
            this.numberOfComparisons++;
    }
    public DoublyLink mergeSortRecursiveDesc(DoublyLink head) {
        if (head == null || head.getNext() == null) {
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
        DoublyLink result = null;

        if (left == null) {
            result = right;
            this.numberOfComparisons++;
        } else if (right == null) {
            result = left;
            this.numberOfComparisons++;
            this.numberOfComparisons++;
        } else {
            if ((float) left.getWine().getValueToCompare() > (float) right.getWine().getValueToCompare()) {
                result = left;
                result.setNext(mergeDesc(left.getNext(), right));
            } else {
                result = right;
                result.setNext(mergeDesc(left, right.getNext()));
            }
            this.numberOfComparisons++;
            this.numberOfComparisons++;
            this.numberOfComparisons++;

            result.getNext().setPrevious(result);
            result.setPrevious(null);

            if (left != null && right != null) {
                this.swap(left, right);
            }
            this.numberOfComparisons++;
        }

        return result;
    }

}
