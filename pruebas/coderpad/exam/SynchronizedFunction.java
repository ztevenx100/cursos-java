package pruebas.coderpad.exam;

public class SynchronizedFunction  {
    private static int count = 0;

    /**
     * Increments count in a thread-safe manner.
     * @return the updated count
     */
    public static synchronized int increment() {
        count = count + 1;
        return count;
    }
}

class Counter {
    private static int count = 0;
    private static final Object lock = new Object();

    /**
     * Increments count in a thread-safe manner.
     * @return the updated count
     */
    public static int increment() {
        synchronized (lock) {
            count = count + 1;
            return count;
        }
    }
}