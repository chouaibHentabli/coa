package core.captor;

import core.difussionStrategy.DiffusionType;
import core.util.CaptorValuesContainer;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Created by chouaib on 15/03/17.
 */
public class CaptorScheduler {
    private Timer timer = new Timer();
    private int max;
    private int min;
    private int step;

    /**
     * Define the processor
     *
     * @param min
     * @param max
     * @param step
     */
    public CaptorScheduler(int min, int max, int step) {
        this.min = min;
        this.max = max;
        this.step = step;
    }

    /**
     * Increment the captor by step
     *
     * @param captor
     * @param period
     * @param unit
     */
    public void incrementWithStepByPeriod(ICaptor captor, long period, TimeUnit unit) {
        TimerTask task = new TimerTask() {
            public void run() {
                double time = 0;
                //System.err.println(captor.getDiffuseStrategy());
                if (captor.getDiffuseStrategy().getDiffusionType() == DiffusionType.EPOC) {
                    time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                }

                int newValue = captor.getValue().getValue() + step;
                if (newValue >= max) {
                    newValue = min;
                }
                System.err.println(newValue);
                captor.setValue(new CaptorValuesContainer(newValue, time));
                captor.tick();
            }
        };
        timer.schedule(task, unit.toMillis(period), unit.toMillis(period));
    }

    /**
     * Randomly change the captor value
     *
     * @param captor
     * @param period
     * @param unit
     */
    public void randomIncrementByPeriod(ICaptor captor, long period, TimeUnit unit) {
        TimerTask task = new TimerTask() {
            public void run() {
                double time = 0;
                if (captor.getDiffuseStrategy().getDiffusionType() == DiffusionType.EPOC) {
                    time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                }

                captor.setValue(
                        new CaptorValuesContainer((int) (Math.random() * (max - min) + min), time)
                );
                captor.tick();
            }
        };
        timer.schedule(task, unit.toMillis(period), unit.toMillis(period));
    }

    /**
     * Reinit the timer
     */
    public void purge() {
        timer.purge();
        timer.cancel();
        timer = new Timer();
    }
}

