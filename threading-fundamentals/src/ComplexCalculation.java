import java.math.BigInteger;

public class ComplexCalculation {
    public BigInteger calculateResult(BigInteger base1, BigInteger power1, BigInteger base2, BigInteger power2) {
        PowerCalculatingThread result1 = new PowerCalculatingThread(base1, power1);
        PowerCalculatingThread result2 = new PowerCalculatingThread(base2, power2);

        result1.start();
        result2.start();

        try {
            result1.join();
            result2.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return result1.getResult().add(result2.getResult());
    }

    private static class PowerCalculatingThread extends Thread {
        private BigInteger result = BigInteger.ONE;
        private BigInteger base;
        private BigInteger power;

        public PowerCalculatingThread(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }

        @Override
        public void run() {
            result = BigInteger.ONE;

            for (BigInteger i = BigInteger.ZERO; i.compareTo(power) != 0; i = i.add(BigInteger.ONE)) {
                result = result.multiply(base);
            }
        }

        public BigInteger getResult() {
            return result;
        }
    }
}