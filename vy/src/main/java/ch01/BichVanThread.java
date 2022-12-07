package ch01;

public class BichVanThread {

    public static void main(String[] args) {
        boolean isDaemon = args.length != 0;

        Runnable runnable = () -> {
            Thread thd = Thread.currentThread();
            while (true) {
                System.out.printf("%s is %salive and in %s state%n", thd.getName(), thd.isAlive() ? "" : "not ", thd.getState());
            }
        };

        Thread threadA = new Thread(runnable, "threadA_2022");
        if (isDaemon) {
            threadA.setDaemon(true);
        }
        System.out.printf("%s is %salive and in %s state%n", threadA.getName(), threadA.isAlive() ? "" : "not ", threadA.getState());

        Thread threadB = new Thread(runnable);
        threadB.setName("threadB_2022");
        if (isDaemon) {
            threadB.setDaemon(true);
        }
        System.out.printf("%s is %salive and in %s state%n", threadB.getName(), threadB.isAlive() ? "" : "not ", threadB.getState());
        threadA.start();
        threadB.start();

        try {
            Thread.sleep(2000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        threadA.interrupt(); // Not effective.
        threadB.interrupt(); // Not effective.

    }

}
