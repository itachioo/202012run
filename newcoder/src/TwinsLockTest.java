import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

class TwinsLock implements Lock {
    private final Sync sync = new Sync(2);
    private static final class Sync extends AbstractQueuedSynchronizer {
        Sync(int count) {
            if(count <= 0) {
                throw new IllegalArgumentException("count must large than zero");
            }
            setState(count);
        }
        public int tryAcquireShared(int reducedCount) {
            for(;;) {
                int current = getState();
                int newCount = current - reducedCount;
                if(newCount<0 || compareAndSetState(current, newCount)) {
                    return newCount;
                }
            }
        }
        public boolean tryReleaseShared(int returnCount) {
            for (;;) {
                int current = getState();
                int newCount = current + returnCount;
                if(compareAndSetState(current, newCount)) {
                    return true;
                }
            }
        }

    }
    @Override
    public void lock() {
        sync.acquireShared(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {

    }

    @Override
    public boolean tryLock() {
        return false;
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.releaseShared(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}

public class TwinsLockTest {
    public static void main(String [] args) {
        final Lock lock = new TwinsLock();
        class Worker extends Thread {
            public void run() {
                while(true) {
                    lock.lock();
                    try {
                        System.out.println("11111");
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName());
                        System.out.println("00000");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        System.out.println("22222");
                        lock.unlock();
                    }
                }
            }
        }
        for (int i=0;i<10;i++) {
            Worker w = new Worker();
            w.setDaemon(true);
            w.start();
            System.out.println(i);
        }
//        for(int i=0; i<10;i++) {
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//            System.out.println();
//        }

    }
}
