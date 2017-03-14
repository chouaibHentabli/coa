package core.captor;

import core.util.Subject;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 19/02/17.
 * <p>
 * Service
 */
public interface IAsyncCaptor extends Subject {

    public Future<Integer> getValue();

    //Future<FutureEpoque> getValueEpoque();

    /**
     * Send a request for value updates to each observers
     */
    void tick();
}
