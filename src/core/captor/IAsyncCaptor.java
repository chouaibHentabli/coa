package core.captor;


import core.util.Subject;
import core.util.ValuesContainer;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 20/02/17.
 */

public interface IAsyncCaptor extends Subject {

    /**
     * Return the value contained in this capteur
     *
     * @return
     */
    Future<ValuesContainer> getValues();

    /**
     * Send a request for value updates to each observers
     */
    void tick();
}
