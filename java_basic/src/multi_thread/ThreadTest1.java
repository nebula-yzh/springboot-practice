package multi_thread;

public class ThreadTest1 implements Runnable{
    public ThreadTest1() {
        super();
    }

    @Override
    public void run() {
        int i=100;
       // synchronized (this){
            while (i>0){
                i--;
                System.out.println(Thread.currentThread()+"第一个");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"第二个");

            }
        //}

    }

    public static void main(String[] args) {
        ThreadTest1 target1 = new ThreadTest1();
        Thread thread1 = new Thread(target1);
        ThreadTest2 target2 = new ThreadTest2();
        Thread thread2 = new Thread(target2);
        thread1.start();
        thread2.start();
    }
}
class ThreadTest2 implements Runnable{
    public ThreadTest2() {
        super();
    }

    @Override
    public void run() {
        int k=50;
        //synchronized (this){
            while (k>0){
                k--;
                System.out.println(Thread.currentThread()+"第3个");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread()+"第4个");

            }
       // }

    }
}
