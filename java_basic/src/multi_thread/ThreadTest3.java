package multi_thread;

import java.util.concurrent.Callable;

public class ThreadTest3 implements Runnable{
    int i=20;
    @Override
    public void run() {

        while (i>0){
            synchronized (this){
                i--;
                System.out.println(Thread.currentThread()+"第"+i+"个");
            }
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            //System.out.println(Thread.currentThread()+"第"+i+"个");

        }
    }

    public static void main(String[] args) {
        ThreadTest3 target1 = new ThreadTest3();
        Thread thread1 = new Thread(target1);
        Thread thread2 = new Thread(target1);
        thread1.start();
        thread2.start();

    }
}
class ThreadTest4 implements Callable {

    @Override
    public Object call() throws Exception {
        return null;
    }
}