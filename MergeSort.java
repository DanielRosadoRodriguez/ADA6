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
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }

        if ((float) left.getWine().getValueToCompare() < (float) right.getWine().getValueToCompare()) {
            left.setNext(merge(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            right.setNext(merge(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
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
    
    private DoublyLink mergeSortRecursiveDesc(DoublyLink head) {
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
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
    
        if ((float) left.getWine().getValueToCompare() >= (float) right.getWine().getValueToCompare()) {
            left.setNext(mergeDesc(left.getNext(), right));
            left.getNext().setPrevious(left);
            left.setPrevious(null);
            return left;
        } else {
            right.setNext(mergeDesc(left, right.getNext()));
            right.getNext().setPrevious(right);
            right.setPrevious(null);
            return right;
        }
    }
    
}
