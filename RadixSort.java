import java.util.Arrays;

public class RadixSort extends Sort {
    
    public RadixSort(DoublyLinkedList list) {
        super(list);
    }

    // A utility function to get maximum value in arr[]
    private Float getMax() {
        DoublyLink current = list.getFirst();
        Float mx = (Float) current.getWine().getValueToCompare();

        while (current != null) {
            if ((Float) current.getWine().getValueToCompare() > mx) {
                mx = (Float) current.getWine().getValueToCompare();
            }
            current = current.getNext();
        }

        return mx;
    }

    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    public void countSort(int exp) throws Exception {
        Wine[] output = new Wine[list.getSize()]; // output list
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        DoublyLink current = list.getFirst();
        int counter = 0;
        while (current != null) {
            while (current != null) {
                if (current.getWine() == null) {
                    throw new Exception("Void Wine");
                }
                count[(int) (((Float) current.getWine().getValueToCompare() / exp) % 10)]++;
                counter++;
                current = current.getNext();
            }
        }

        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        // Build the output array
        current = list.getLast();
        while (current != null) {
            int index = (int) (((Float) current.getWine().getValueToCompare() / exp) % 10);
            int position = count[index];
            output[position - 1] = current.getWine();
            count[index]--;
            current = current.getPrevious();
        }

        // Copy the output list to current list, so that the list now
        // contains sorted elements according to current digit
        current = list.getFirst();
        i = 0;
        while (current != null) {
            current.setWine(output[i]);
            // System.out.println("Current get wine: " + current.getWine());
            // System.out.println("Output[i]: " + output[i]);
            current = current.getNext();
            i++;
        }
    }


    public void countSortDesc(int exp) throws Exception {
        Wine[] output = new Wine[list.getSize()]; // output list
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);
    
        // Store count of occurrences in count[]
        DoublyLink current = list.getFirst();
        int counter = 0;
        while (current != null) {
            while (current != null) {
                if (current.getWine() == null) {
                    throw new Exception("Void Wine");
                }
                count[(int) (((Float) current.getWine().getValueToCompare() / exp) % 10)]++;
                counter++;
                current = current.getNext();
            }
        }
    
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
    
        // Build the output array
        current = list.getLast();
        while (current != null) {
            int index = (int) (((Float) current.getWine().getValueToCompare() / exp) % 10);
            int position = count[index];
            output[position - 1] = current.getWine();
            count[index]--;
            current = current.getPrevious();
        }
    
        // Copy the output list to current list, so that the list now
        // contains sorted elements according to current digit
        current = list.getFirst();
        i = 0;
        while (current != null) {
            current.setWine(output[i]);
            current = current.getNext();
            i++;
        }
    }
    
    // The main function to that sorts list of size n using Radix Sort
   

    // The main function to that sorts list of size n using Radix Sort
    public void sortRadix() throws Exception {
        // Find the maximum number to know number of digits
        multiplicar();
        float max = getMax();
        
        // Do counting sort for every digit. Note that
        // instead of passing digit number, exp is passed.
        // exp is 10^i where i is current digit number
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countSort(exp);
        }
        dividir();
    }

    public void multiplicar(){
        DoublyLink current = list.getFirst();
        while(current != null){
            current.getWine().modifyValueToCompare((Float)current.getWine().getValueToCompare() * 1000);
            current = current.getNext();
        }
    } 

    public void dividir(){
        DoublyLink current = list.getFirst();
        while(current != null){
            current.getWine().modifyValueToCompare((Float)current.getWine().getValueToCompare() / 1000);
            current = current.getNext();
        }
    } 


    @Override
    public void sortAsc() {
        try {
            sortRadix();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void sortDesc() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'sortDesc'");
    }

}
