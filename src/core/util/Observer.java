package core.util;

/**
 * Created by chouaib on 23/01/17.
 * <p>
 * Service
 */

public interface Observer<T> {

    /**
     * Retreive an update from an observable
     *
     * @param subject
     */
    Void update(T subject);
}