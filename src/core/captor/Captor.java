package core.captor;

import core.difussionStrategy.*;
import core.util.AbstractSubject;

import java.util.AbstractCollection;
import java.util.Observer;

/**
 * Created by chouaib on 20/02/17.
 */
public class Captor extends AbstractCaptor {


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
        //diffuseStrategy.configure(this, observers);
    }

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

}
