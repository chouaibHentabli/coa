package core.captor;

import core.difussionStrategy.DiffusionType;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.TimeUnit;

/**
 * Allow to manage the value computation of a captor
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
    public void incrementWithStepByPeriod(Captor captor, long period, TimeUnit unit) {
        TimerTask task = new TimerTask() {
            public void run() {
                double time = 0;
                if (captor.getDiffusionStrategy().getDiffusionType() == DiffusionType.EPOC) {
                    time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                }

                int newValue = captor.getValues().getValue() + step;
                if (newValue >= max) {
                    newValue = min;
                }
                System.err.println(newValue);
                captor.setValues(
                        new CaptorValuesContainer(newValue, time)
                );
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
    public void randomIncrementByPeriod(Captor captor, long period, TimeUnit unit) {
        TimerTask task = new TimerTask() {
            public void run() {
                double time = 0;
                if (captor.getDiffusionStrategy().getDiffusionType() == DiffusionType.EPOC) {
                    time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
                }
                // Increament value in N by 1 and time by 0.01
                captor.setValues(
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