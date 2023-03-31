public abstract class Sort {
    protected DoublyLinkedList list;
    protected int numberOfSwaps = 0;
    protected int numberOfComparisons = 0;
    protected long time = 0;

    public Sort(DoublyLinkedList list) {
        this.list = list;
    }

    protected void swap(DoublyLink a, DoublyLink b) {
        Wine temp = a.getWine();
        a.setWine(b.getWine());
        b.setWine(temp);
        numberOfSwaps++;
    }

    public DoublyLinkedList sort(int direction) {
        if(direction == 1){
            this.time = calcularTiempoDeEjecucion(() -> {
                sortAsc();
            });
        }else{
            System.out.println("Sort Desc");
            this.time = calcularTiempoDeEjecucion(() -> {
                sortDesc();
            });
        }
        return this.list;
    }

    public abstract void sortAsc();
    public abstract void sortDesc();
    
    public long calcularTiempoDeEjecucion(Runnable runnable) {
        long tiempoInicio = System.currentTimeMillis();
        runnable.run();
        long tiempoFinal = System.currentTimeMillis();
        return tiempoFinal - tiempoInicio;
    }
    public long getTime() {
        return time;
    }

    public int getSwaps() {
        return numberOfSwaps;
    }
    public int getComparisons() {
        return numberOfComparisons;
    }

}
