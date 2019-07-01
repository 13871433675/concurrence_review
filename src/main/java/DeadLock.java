public class DeadLock {
    private static String A = "A";
    private static String B = "B";
    public static void main(String[] args) {
        new DeadLock().deadLock();
    }
    private void deadLock() {
        Thread t1 = new Thread(new Runnable() {
            public void run() {
                synchronized (A) {
                    try {
                        System.out.println("A1");
                        Thread.currentThread().sleep(0);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    System.out.println("A2");
                    synchronized (B) {
                        System.out.println("1");
                    }
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            public void run() {
                synchronized (B) {
                    System.out.println("B");
                    synchronized (A) {
                        System.out.println("2");
                    }
                }
            }
        });
        t1.start();
        t2.start();
    }
}
