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

    public void setDelay(int delay);

    public int getDelay();

    public List<Observer> getObservers();

}
