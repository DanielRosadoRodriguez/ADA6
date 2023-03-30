public class MergeSort extends Sort {

    public MergeSort(DoublyLinkedList list) {
        super(list);
    }

    public DoublyLinkedList sort() {
        this.time = calcularTiempoDeEjecucion(() -> {
            mergeSort();
        });
        return this.list;
    }
    public DoublyLinkedList sortDesc() {
        this.time = calcularTiempoDeEjecucion(() -> {
            mergeSortDesc();
        });
        return this.list;
    }

    public void mergeSort() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursive(this.list.getFirst()));
        }
    }

    private DoublyLink mergeSortRecursive(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

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
        } else if (right == null) {
            result = left;
        } else {
            if ((float) left.getWine().getValueToCompare() < (float) right.getWine().getValueToCompare()) {
                result = left;
                result.setNext(merge(left.getNext(), right));
            } else {
                result = right;
                result.setNext(merge(left, right.getNext()));
            }

            result.getNext().setPrevious(result);
            result.setPrevious(null);

            if (left != null && right != null) {
                this.swap(left, right);
            }
        }

        return result;
    }

    private DoublyLink getMiddle(DoublyLink head) {
        if (head == null) {
            return null;
        }

        DoublyLink slow = head;
        DoublyLink fast = head.getNext();

        while (fast != null) {
            fast = fast.getNext();
            if (fast != null) {
                slow = slow.getNext();
                fast = fast.getNext();
            }
        }

        return slow;
    }

    public void mergeSortDesc() {
        if (this.list.getFirst() != null) {
            this.list.setFirst(mergeSortRecursiveDesc(this.list.getFirst()));
        }
    }
    public DoublyLink mergeSortRecursiveDesc(DoublyLink head) {
        if (head == null || head.getNext() == null) {
            return head;
        }

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
        } else if (right == null) {
            result = left;
        } else {
            if ((float) left.getWine().getValueToCompare() > (float) right.getWine().getValueToCompare()) {
                result = left;
                result.setNext(mergeDesc(left.getNext(), right));
            } else {
                result = right;
                result.setNext(mergeDesc(left, right.getNext()));
            }

            result.getNext().setPrevious(result);
            result.setPrevious(null);

            if (left != null && right != null) {
                this.swap(left, right);
            }
        }

        return result;
    }

}
