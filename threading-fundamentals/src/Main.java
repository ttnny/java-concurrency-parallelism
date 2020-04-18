public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(() -> {
            // Code that will run in a new thread
            System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName() + ", " + Thread.currentThread().getPriority());
        });

        thread.setName("Earth Thread");
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();

        System.out.println(Thread.currentThread().getId() + ", " + Thread.currentThread().getName() + ", " + Thread.currentThread().getPriority());

        Thread.sleep(3000);
    }
}
