package core.canal;

import core.captor.ICaptor;
import core.display.Display;
import core.display.IDisplay;
import core.mi.MethodInvGetValue;
import core.util.AbstractSubject;
import core.util.ValuesContainer;

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
    private static ScheduledExecutorService executorService = Executors.newScheduledThreadPool(100);

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
    public Future<ValuesContainer> getValue() {
        return executorService.schedule(new MethodInvGetValue(this.captor), this.delay, TimeUnit.MILLISECONDS);
    }

    @Override
    public void update(ICaptor subject) {
        observers.forEach(observer -> observer.update(this));
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


    /*public Future update() {
        final IaCpteurAsynchrone fakeCap = this;

        FutureTask<Boolean> future = new FutureTask<Boolean>(new Callable<Boolean>() {
            public Boolean call() throws Exception {
                for (ObserveurDeCap observeur : observeurDeCaps) {
                    observeur.update((CapteurAsynchrone) fakeCap);
                }

                return true;
            }
        });
        scheduler.submit(future);
        return future;
    }*/


}
