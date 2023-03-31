import java.util.Arrays;

/**
 * Clase que implementa el algoritmo de ordenamiento RadixSort. Extiende la
 * clase Sort.
 */

public class RadixSort extends Sort {

    /**
     * 
     * Constructor de la clase RadixSort. Recibe como parámetro una lista doblemente
     * enlazada.
     * 
     * @param list La lista doblemente enlazada que se va a ordenar.
     */
    public RadixSort(DoublyLinkedList list) {
        super(list);
    }

    /**
     * 
     * Función privada que obtiene el valor máximo de la lista.
     * 
     * @return El valor máximo de la lista.
     */
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

    /**
     * 
     * Función que realiza el counting sort de la lista de acuerdo al dígito
     * representado por exp.
     * 
     * @param exp El dígito que se va a utilizar para realizar el counting sort.
     * 
     * @throws Exception Si se intenta ordenar una lista vacía o nula.
     */
    public void countSort(int exp) throws Exception {
        Wine[] output = new Wine[list.getSize()]; // output list
        int i;
        int[] count = new int[10];
        Arrays.fill(count, 0);

        // Store count of occurrences in count[]
        DoublyLink current = list.getFirst();

        while (current != null) {
            while (current != null) {
                if (current.getWine() == null) {
                    throw new Exception("Void Wine");
                }
                count[(int) (((Float) current.getWine().getValueToCompare() / exp) % 10)]++;
                current = current.getNext();
            }
        }

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];

        current = list.getLast();
        while (current != null) {
            int index = (int) (((Float) current.getWine().getValueToCompare() / exp) % 10);
            int position = count[index];
            this.numberOfSwaps++;
            output[position - 1] = current.getWine();
            count[index]--;
            current = current.getPrevious();
        }

        current = list.getFirst();
        i = 0;
        while (current != null) {
            current.setWine(output[i]);
            current = current.getNext();
            i++;
        }
    }

    /**
     * 
     * Función ultra especial para ordenar la lista de manera descendente
     */
    public void reverseList() {
        if (list.getFirst() == null) {
            return;
        }

        DoublyLink current = list.getFirst();
        DoublyLink temp = null;

        while (current != null) {
            temp = current.getPrevious();
            current.setPrevious(current.getNext());
            current.setNext(temp);
            current = current.getPrevious();
        }

        temp = list.getFirst();
        list.setFirst(list.getLast());
        list.setLast(temp);
    }

    /**
     * Funcion principal que ordena la lista usando Radix, primero para poder
     * ordenar decimales
     * debe multiplicar cada elemento * 1000 para evitar errores
     * una vez ordenada la lista, regresa los números a su estado original
     * 
     * @throws Exception
     */
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
        while (current != null) {
            current.getWine().modifyValueToCompare((Float) current.getWine().getValueToCompare() * 1000);
            current = current.getNext();
        }
    }

    public void dividir(){
        DoublyLink current = list.getFirst();
        while (current != null) {
            current.getWine().modifyValueToCompare((Float) current.getWine().getValueToCompare() / 1000);
            current = current.getNext();
        }
    }

    /**
     * 
     * Manda a ordenar la lista de vinos de forma ascendente utilizando Radix Sort.
     */
    @Override
    public void sortAsc() {
        try {
            sortRadix();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 
     * Manda a ordenar la lista de vinos de forma descendente utilizando Radix Sort.
     */
    @Override
    public void sortDesc() {
        try {
            sortRadix();
            reverseList();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
