public class DoublyLinkedList {

    private DoublyLink first;
    private DoublyLink last;
    private int size;

    public DoublyLinkedList() {
        first = null;
        last = null;
        size = 0;
    }

    public void sort() {
        try {

            long tiempo = getTiempoDeEjecucion(() -> {
                quickSort();
            });
            System.out.println("Tiempo de ejecucion quicksort: " + tiempo + "ms");
            new DAO().writeCSV(this, "quicksort.csv");

            clear();
            tiempo = getTiempoDeEjecucion(() -> {
                mergeSort();
            });
            System.out.println("Tiempo de ejecucion mergesort: " + tiempo + "ms");
            new DAO().writeCSV(this, "mergesort.csv");

            tiempo = getTiempoDeEjecucion(() -> {
                quickSort();
            });
            System.out.println("Tiempo de ejecucion quicksort: " + tiempo + "ms");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getTiempoDeEjecucion(Runnable runnable) {
        long tiempoInicio = System.currentTimeMillis();
        runnable.run();
        long tiempoFinal = System.currentTimeMillis();
        return tiempoFinal - tiempoInicio;
    }

    //BINARY INSERTION SORT

    public int binarySearch(Wine item, int low, int high){
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((Float)item.getValueToCompare() == (Float)get(mid).getValueToCompare())
                return mid + 1;
            else if ((Float)item.getValueToCompare() > (Float)get(mid).getValueToCompare())
                low = mid + 1;
            else
                high = mid - 1;
        }
        return low;
    }

    public void binaryInsertionSort(int n) throws Exception {
        int i, loc = 0, j;
        Wine selected;
    
        for (i = 1; i < n; ++i) {
            j = i - 1;
            selected = get(i);
            
    
            // encuentra la posicion donde debe ser insertado el elemento
            loc = binarySearch(selected, 0, j);
    
            // Hace un corrimiento a la derecha de los datos
            while (j >= loc) {
                updateNodeWithPosition(j+1, get(j));
                j--;
            }
            updateNodeWithPosition(j+1, selected);
        }
    }

    //QUICKSORT
    public void quickSort() {
        quickSortRecursive(first, last);
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
                swap(i, j);
            }
        }
        i = (i == null) ? left : i.getNext();
        swap(i, right);
        return i;
    }

    //MERGE SORT

    public void mergeSort() {
        if (first != null) {
            first = mergeSortRecursive(first);
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

    public void SetColumnToCompare(String columnToCompare) {
        DoublyLink current = first;
        while (current != null) {
            current.getWine().setValueToCompare(columnToCompare);
            current = current.getNext();
        }
    }

    public void simpleSortFloat() {
        DoublyLink current = first;
        while (current != null) {
            DoublyLink next = current.getNext();
            while (next != null) {
                if ((float) current.getWine().getValueToCompare() > (float) next.getWine().getValueToCompare()) {
                    swap(current, next);
                }
                next = next.getNext();
            }
            current = current.getNext();
        }
    }

    public void swap(DoublyLink current, DoublyLink next) {
        Wine temp = current.getWine();
        current.setWine(next.getWine());
        next.setWine(temp);
    }

    /**
     * imprime el contenido de la lista
     * 
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

    public boolean isEmpty() {
        return first == null;
    }

    // public void printAlcohol() {
    //     DoublyLink current = first;
    //     while (current != null) {
    //         System.out.println(current.getWine().getAlcohol());
    //         current = current.getNext();
    //     }
    // }

    public DoublyLink getFirst() {
        return first;
    }

    public int getSize() {
        return size;
    }
    public void clear() {
        first = null;
        last = null;
        size = 0;
    }

    public Wine get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        DoublyLink current = first;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getWine();
    }

    public void updateNodeWithPosition(int nodePosition, Wine newValue) throws Exception {
        DoublyLink current = first;
        if (isEmpty())
            throw new Exception("La lista está vacía");
        try {
            for (int i = 0; i < nodePosition; i++) {
                if (current == null) {
                    throw new Exception("La posición no existe en la lista");
                }
                current = current.getNext();
            }
            current.setWine(newValue);
        } catch (NullPointerException e) {
            throw new Exception("La posición no existe en la lista");
        }
    }
    
}
