package core.canal;

import core.captor.ICaptor;
import core.display.Display;
import core.display.IDisplay;
import core.mi.MethodInvGetValue;
import core.mi.MethodInvUpdate;
import core.util.AbstractSubject;
import core.util.Observer;
import core.util.ValuesContainer;

import java.util.List;
import java.util.concurrent.*;


/**
 * Created by chouaib on 23/01/17.
 */
public class Canal extends AbstractSubject implements ICanal {

    protected String name;
    private ICaptor captor;
    private IDisplay display;
    private int delay = 0;
    private static int identifier = 0;
    private static ScheduledExecutorService executorServiceCaptor = Executors.newScheduledThreadPool(50);
    private static ScheduledExecutorService executorServiceDisplay = Executors.newScheduledThreadPool(50);

    /**
     * Constrcutor
     *
     * @param captor connected to canal
     */
    public Canal(ICaptor captor, IDisplay display) {
        name = "Canal_" + ++identifier;
        this.captor = captor;
        this.display = display;
        attach(this);
        System.out.println(this + ".captor = " + captor);
    }


    public String getName() {
        return name;
    }

    public ICaptor getCaptor() {
        return captor;
    }

    public IDisplay getDisplay() {
        return display;
    }

    public int getDelay() {
        return delay;
    }

    public static int getIdentifier() {
        return identifier;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCaptor(ICaptor captor) {
        this.captor = captor;
    }

    public void setDisplay(Display display) {
        this.display = display;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }

    @Override
    public List<Observer> getObservers() {
        return observers;
    }

    @Override
    public Future<ValuesContainer> getValue() {
        return executorServiceCaptor.schedule(new MethodInvGetValue(this.captor), this.delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void update(ICaptor subject) {
        executorServiceDisplay.submit(new MethodInvUpdate(this));
        //return future;
    }


    @Override
    public void tick() {
        captor.tick();
    }

    @Override
    public void attach(core.util.Observer o) {
        captor.attach(o);
    }

    @Override
    public void detach(core.util.Observer o) {
        captor.detach(o);
    }

    @Override
    public String toString() {
        return name;
    }


}
