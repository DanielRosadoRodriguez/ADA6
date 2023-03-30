public class Metric {
    private String algorithmName;
    private long time;
    private int comparisons;
    private int swaps;

    public Metric(String algorithmName, long time, int comparisons, int swaps) {
        this.algorithmName = algorithmName;
        this.time = time;
        this.comparisons = comparisons;
        this.swaps = swaps;
    }
    public String getAlgorithmName() {
        return algorithmName;
    }
    public void setAlgorithmName(String algorithmName) {
        this.algorithmName = algorithmName;
    }
    public long getTime() {
        return time;
    }
    public void setTime(long time) {
        this.time = time;
    }
    public int getComparisons() {
        return comparisons;
    }
    public void setComparisons(int comparisons) {
        this.comparisons = comparisons;
    }
    public int getSwaps() {
        return swaps;
    }
    public void setSwaps(int swaps) {
        this.swaps = swaps;
    }
    
}
