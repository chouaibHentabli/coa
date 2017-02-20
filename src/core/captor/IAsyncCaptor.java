package core.captor;

import core.util.Subject;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 19/02/17.
 */
public interface IAsyncCaptor extends Subject {

    public Future<Integer> getValue();

    /**
     * Send a request for value updates to each observers
     */
    void tick();
}
