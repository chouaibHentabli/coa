package core.canal;

import core.captor.ICaptor;
import core.difussionStrategy.IDiffusionStrategy;
import core.display.Display;

import java.util.Observable;
import java.util.Observer;


/**
 * Created by chouaib on 23/01/17.
 */
public class Canal implements ICanal, Observer {


    protected String name;
    private ICaptor captor;
    private Display dispaly;
    private int delay = 0;
    private static int identifier = 0;


    /**
     * Constrcutor
     *
     * @param captor connected to
     */
    public Canal(ICaptor captor, Display display) {
        name = "Canal_" + ++identifier;
        attach(this);
        this.captor = captor;
        System.out.println(this + ".captor = " + captor);
    }


    public String getName() {
        return name;
    }

    public ICaptor getCaptor() {
        return captor;
    }

    public Display getDispaly() {
        return dispaly;
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

    public void setDispaly(Display dispaly) {
        this.dispaly = dispaly;
    }

    public void setDelay(int delay) {
        this.delay = delay;
    }
 

    @Override
    public IDiffusionStrategy getDiffusionStrategy() {
        return null;
    }

    @Override
    public void attach(Observer o) {
        captor.attach(o);
    }

    @Override
    public void detach(Observer o) {
        captor.detach(o);
    }

    @Override
    public Integer getValue() {
        return captor.getValue();
    }

    @Override
    public void tick() {
        captor.tick();
    }


    @Override
    public void update(ICaptor captor) {

    }

    @Override
    public void update(Observable o, Object arg) {

    }


}
