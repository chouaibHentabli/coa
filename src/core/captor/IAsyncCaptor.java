package core.captor;

import core.util.Subject;
import core.util.ValuesContainer;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 19/02/17.
 * <p>
 * Service
 */
public interface IAsyncCaptor extends Subject {

    public Future<ValuesContainer> getValue();

    //Future<FutureEpoque> getValueEpoque();

    /**
     * Send a request for value updates to each observers
     */
    void tick();
}
