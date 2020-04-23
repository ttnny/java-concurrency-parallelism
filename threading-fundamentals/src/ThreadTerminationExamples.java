import java.io.IOException;

public class ThreadTerminationExamples {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new WaitingForUserInput());
        thread1.setName("InputWaitingThread");
        thread1.setDaemon(true);
        thread1.start();

        Thread thread2 = new Thread(new SleepingThread());
        thread2.start();
        thread2.interrupt();
    }

    private static class WaitingForUserInput implements Runnable {
        @Override
        public void run() {
            try {
                while (true) {
                    char input = (char) System.in.read();
                    if (input == 'q') {
                        return;
                    }
                }
            } catch (IOException e) {
                System.out.println("An exception was caught: " + e);
            }
        }
    }

    private static class SleepingThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(1000000);
                } catch (InterruptedException e) {
                    return;
                }
            }
        }
    }
}
