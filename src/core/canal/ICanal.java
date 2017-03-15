package core.canal;

import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.ObservateurDeCapteur;
import core.util.Observer;

import java.util.List;

/**
 * Created by chouaib on 20/02/17.
 * proxy
 */


public interface ICanal extends ObservateurDeCapteur, IAsyncCaptor {

    void setDelay(int delay);

    int getDelay();

    List<Observer> getObservers();

}
