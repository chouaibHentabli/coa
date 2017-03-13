package core.canal;

import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;
import core.display.Display;
import core.display.IDisplay;
import core.util.Subject;

import java.util.Observer;
import java.util.concurrent.Future;


/**
 * Created by chouaib on 23/01/17.
 */
public class Canal implements ICanal {

    protected String name;
    private ICaptor captor;
    private IDisplay display;
    private int delay = 0;
    private static int identifier = 0;


    /**
     * Constrcutor
     *
     * @param captor connected to canal
     */
    public Canal(ICaptor captor, IDisplay display) {
        name = "Canal_" + ++identifier;
        //attach(this);
        this.captor = captor;
        this.display = display;
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
    public Future<Integer> getValue() {
        return null;
    }

    @Override
    public void tick() {
        captor.tick();
    }


    @Override
    public void update(Subject captor) {

    }

    @Override
    public void update(ICaptor subject) {

    }

    @Override
    public void attach(core.util.Observer o) {
        captor.attach(o);
    }

    @Override
    public void detach(core.util.Observer o) {
        captor.detach(o);
    }
}
