package core.captor;


import core.util.Subject;
import core.util.ValuesContainer;


/**
 * Created by chouaib on 19/02/17.
 */
public interface ICaptor extends Subject {

    /**
     * Return the value contained in this capteur
     *
     * @return
     */
    ValuesContainer getValues();

    /**
     * Send a request for value updates to each observers
     */
    void tick();

    /**
     * Set the values of this captor
     *
     * @param valuesContainer
     */
    void setValues(ValuesContainer valuesContainer);
}
