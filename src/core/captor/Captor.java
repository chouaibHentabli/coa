package core.captor;

import core.difussionStrategy.*;
import main.Controller;


/**
 * Created by chouaib on 20/02/17.
 * <p>
 * servant
 */
public class Captor extends AbstractCaptor {
    private final Controller controller;

    private IDiffusionStrategy diffuseStrategy;

    public Captor(Controller controller) {
        System.out.println(this + " initialized");
        this.controller = controller;
    }

    public void setDiffuseStrategy(DiffusionType type) {
        switch (type) {
            case ATOMIC:
                this.diffuseStrategy = new AtomicDiffusion(DiffusionType.ATOMIC);
                break;
            case EPOC:
                this.diffuseStrategy = new EpocDiffusion(DiffusionType.EPOC);
                break;
            case SEQUENTIAL:
                this.diffuseStrategy = new SeqDiffusion(DiffusionType.SEQUENTIAL);
                break;
        }
        diffuseStrategy.configure(this, observers);
    }

    public IDiffusionStrategy getDiffusionStrategy() {
        return this.diffuseStrategy;
    }

    @Override
    public void tick() {
        diffuseStrategy.execute();
        if (controller != null) {
            controller.update(this);
        }
        System.out.println("Tick with " + getDiffusionStrategy() + "with value " + value);
    }
}
