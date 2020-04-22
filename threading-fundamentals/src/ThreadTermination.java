import java.math.BigInteger;

public class ThreadTermination {
    public static void main(String[] args) {
        // Blocking Task
        Thread thread1 = new Thread(new BlockingTask());
        thread1.start();
        thread1.interrupt();

        // Long Computation Task
        Thread thread2 = new Thread(new LongComputationTask(new BigInteger("20"), new BigInteger("50")));
        thread2.start();
        thread2.interrupt();

        // A Daemon Thread
        Thread thread3 = new Thread(() -> {
        });
        thread3.setDaemon(true);
        thread3.start();
    }

    private static class BlockingTask implements Runnable {
        @Override
        public void run() {
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("Exiting blocking thread.");
            }
        }
    }

    private static class LongComputationTask implements Runnable {
        private final BigInteger base;
        private final BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            System.out.println(pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power) {
            BigInteger result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                if (Thread.currentThread().isInterrupted()) {
                    System.out.println("Prematurely interrupted computation.");
                    return BigInteger.ZERO;
                }
                result = result.multiply(base);
            }

            return result;
        }
    }
}
