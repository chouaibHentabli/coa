package core.util;

import core.command.Command;
import core.mi.IMethodInvocation;
import core.mi.MethodInvUpdate;

import java.util.Timer;
import java.util.concurrent.*;

/**
 * Created by chouaib on 20/02/17.
 */
public class Scheduler extends ScheduledThreadPoolExecutor {


    private Timer timer;

    private ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
    private BlockingQueue queue = new LinkedBlockingQueue<>();

    public Scheduler(int corePoolSize) {
        super(corePoolSize);
    }


    public void inQueue(IMethodInvocation mi) {
        queue.add(mi);
    }


    public void activerPeriodiquement(IMethodInvocation mi) {
        PeriodicTask task = new PeriodicTask(null);
        Future future = executorService.schedule(mi, 1000, TimeUnit.MILLISECONDS);
        if (future.isDone())
            queue.add(future);
    }


    public void desactiver() {
        timer.cancel();
        timer.purge();
    }
}

