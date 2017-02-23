package core.captor;

import core.canal.ICanal;
import core.difussionStrategy.*;
import core.util.AbstractSubject;

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

    List<ICanal> canals = new ArrayList<ICanal>();

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
}
