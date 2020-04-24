import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class JoiningThreads {
    public static void main(String[] args) {
        List<Long> inputNumbers = Arrays.asList(0L, 3456L, 23456L, 4005L, 5790L, 89L, 2020L, 6996L);
        // Calculate 0!, 3456!, 23456!, 4005!, 5790!, 89!, 2020!, 6996!


    }

    public static class FactorialThread extends Thread {
        private long inputNumber;
        private BigInteger result = BigInteger.ZERO;
        private boolean isFinished = false;

        public FactorialThread(long inputNumber) {
            this.inputNumber = inputNumber;
        }

        @Override
        public void run() {
            super.run();
        }
    }
}
