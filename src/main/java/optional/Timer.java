package optional;

public class Timer {
    private long startTime;
    public void startTimer() {
        startTime = System.nanoTime();
    }

    public void stopTimer() {
        long endTime = System.nanoTime();
        long executionTime = endTime - startTime;
        System.out.println("Execution time: " + executionTime + " ns");
    }
}