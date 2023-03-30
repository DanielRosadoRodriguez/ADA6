public class BinaryInsertionSort extends Sort{

    public BinaryInsertionSort(DoublyLinkedList list) {
        super(list);
    }

    public DoublyLinkedList sort(){
        this.time = calcularTiempoDeEjecucion(() -> {
            try {
                binaryInsertionSort(list.getSize());
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
        return this.list;
    }

    public int binarySearch(Wine item, int low, int high) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if ((Float) item.getValueToCompare() == (Float) list.get(mid).getValueToCompare())
                return mid + 1;
            else if ((Float) item.getValueToCompare() > (Float) list.get(mid).getValueToCompare())
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
            selected = list.get(i);
            loc = binarySearch(selected, 0, j);
            while (j >= loc) {
                list.updateNodeWithPosition(j + 1, list.get(j));
                j--;
            }
            list.updateNodeWithPosition(j + 1, selected);
        }
    }
    

}
