package core.canal;

import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.AbstractSubject;
import core.util.ObservatorDeCaptor;
import core.util.ValuesContainer;

import java.util.concurrent.*;


/**
 * Created by chouaib on 23/01/17.
 */
public class Canal extends AbstractSubject implements ObservatorDeCaptor, IAsyncCaptor {

    protected String name;
    private ICaptor captor;
    private int delay = 0;
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);
    private static int identifier = 0;


    public Canal(ICaptor captor) {
        name = "Canal_" + ++identifier;
        captor.attach(this);
        this.captor = captor;
        System.out.println(this + ".captor = " + captor);
    }

    @Override
    public Future<ValuesContainer> getValues() {
        Callable<ValuesContainer> methodRequest = () -> captor.getValues();
        return executorService.schedule(methodRequest, delay, TimeUnit.MILLISECONDS);
    }


    public int getDelay() {
        return delay;
    }


    public void tick() {
        captor.tick();
    }

    /**
     * Configure the transmission delay in milliseconds
     */
    public void setDelay(int delay) {
        this.delay = delay;
        System.out.println(this + ".delay = " + delay);
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Void update(ICaptor subject) {
        observers.forEach(observer -> observer.update(this));
        return null;
    }
}
