package core.canal;

import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.ObservatorDeCaptor;
import core.util.Observer;
import core.util.ValuesContainer;

import java.util.List;
import java.util.concurrent.Future;

/**
 * Created by chouaib on 20/02/17.
 * proxy
 */


public interface ICanal extends ObservatorDeCaptor, IAsyncCaptor {

    void setDelay(int delay);

    int getDelay();

    List<Observer> getObservers();

    @Override
    default void attach(Observer o) {

    }

    @Override
    default void detach(Observer o) {

    }

    @Override
    default Void update(ICaptor subject) {
        return null;
    }

    @Override
    default Future<ValuesContainer> getValue() {
        return null;
    }

    @Override
    default void tick() {

    }
}
