package ch01;

public class ThreadDemo {

    public static void main(String[] args) {

        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String threadName = Thread.currentThread().getName();
                int counter = 0;
                while (!Thread.interrupted()) {
                    System.out.println(threadName + ": " + counter++);
                }
            }
        };

//        Runnable runnable = () -> {
//            String threadName = Thread.currentThread().getName();
//            int counter = 0;
//            while (!Thread.interrupted()) {
//                System.out.println(threadName + ": " + counter++);
//            }
//        };

        Thread threadA = new Thread(runnable);
        Thread threadB = new Thread(runnable);

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException ie) {

        }

        threadA.interrupt();
        threadB.interrupt();
    }

}
