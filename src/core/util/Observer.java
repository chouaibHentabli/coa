package core.util;

/**
 * Created by chouaib on 23/01/17.
 *
 * Service
 */

public interface Observer<T> {

    /**
     * Retreive an update from an observable
     *
     * @param subject
     */
    void update(T subject);
}