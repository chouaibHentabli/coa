package core.captor;

import core.canal.ICanal;
import core.difussionStrategy.*;
import core.util.AbstractSubject;
import core.util.ValuesContainer;
import main.Controller;

import java.util.AbstractCollection;
import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

/**
 * Created by chouaib on 20/02/17.
 * <p>
 * servant
 */
public class Captor extends AbstractCaptor {

    private List<ICanal> canals = new ArrayList<ICanal>();
    private Controller controller;

    public Captor(Controller controller) {
        this.controller = controller;
    }


    public DiffusionType getDiffuseStrategy() {
        return null;
    }


    @Override
    public ValuesContainer getValue() {
        return value;
    }

    @Override
    public ValuesContainer setValue(ValuesContainer value) {
        return value = value;
    }

    public void setDiffuseStrategy(DiffusionType type) {
        switch (type) {
            case ATOMIC:
                diffuseStrategy = new AtomicDiffusion(DiffusionType.ATOMIC);
                break;
            case EPOC:
                diffuseStrategy = new EpocDiffusion(DiffusionType.EPOC);
                break;
            case SEQUENTIAL:
                diffuseStrategy = new SeqDiffusion(DiffusionType.SEQUENTIAL);
                break;
        }
        diffuseStrategy.configure(this, observers);
    }

    @Override
    public void tick() {
        diffuseStrategy.execute();
        if (controller != null) {
            controller.update(this);
        }
        System.out.println("Tick with " + getDiffuseStrategy() + "with value " + value);
    }


}
