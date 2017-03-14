package core.util;

import core.command.Command;
import core.mi.IMethodInvocation;
import core.mi.MethodInvUpdate;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.*;

/**
 * Created by chouaib on 20/02/17.
 */
public class Scheduler {

    private Timer timer;


    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }
   /* private Timer timer;

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
    }*/



    public void activerPeriodiquement(Command cmd, long periodEnSecondes) {
        this.timer = new Timer();
        PeriodicTask task = new PeriodicTask(cmd);
        timer.schedule(task, 0, periodEnSecondes);
    }


    public void incrementWithStepByPeriod(CaptorImpl captor, long period, TimeUnit unit) {
        TimerTask task = new TimerTask() {
            public void run() {
                double time = 0;
                if (captor.getDiffusionStrategy().getDiffusionType() == DiffusionType.EPOC) {
                    time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                }
                // Increament value in N by 1 and time by 0.01
                int newValue = captor.getValues().getValue() + step;
                if (newValue >= max) {
                    newValue = min;
                }
                captor.setValues(
                        new CaptorValuesContainer(newValue, time)
                );
                captor.tick();
            }
        };
        timer.schedule(task, unit.toMillis(period), unit.toMillis(period));
    }


    public void desactiver() {
        timer.cancel();
        timer.purge();
    }

}

