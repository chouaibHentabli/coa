package core.util;

import core.mi.IMethodInvocation;

import java.util.concurrent.*;

/**
 * Created by chouaib on 20/02/17.
 */
public class Scheduler extends ScheduledThreadPoolExecutor {

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
    private BlockingQueue queue = new LinkedBlockingQueue<>();

    public Scheduler(int corePoolSize) {
        super(corePoolSize);
    }


    public void inQueue(IMethodInvocation mi) {
        queue.add(mi);
    }
}

