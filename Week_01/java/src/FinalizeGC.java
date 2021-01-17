public class FinalizeGC {
    volatile static FinalizeGC instance = null;

    @Override
    protected void finalize() throws Throwable {
        super.finalize();
        System.out.println(Thread.currentThread().getName() + ": finalize method executed!" + (this == null));
        instance = this;

        System.out.println("----------------");
        instance.isAlive();
        System.out.println("----------------");
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName());
        instance = new FinalizeGC();
        instance = null;
        System.gc();
//        Thread.sleep(1000);
        if (instance == null) {
            System.out.println("i am dead!");
        } else {
            instance.isAlive();
        }

        instance = null;
        System.gc();
//        Thread.sleep(1000);
        if (instance == null) {
            System.out.println("i am dead!");
        } else {
            instance.isAlive();
        }

//        Thread.sleep(3000);
    }

    private void isAlive() {
        System.out.println("i am still alive!");
    }
}
