package sensor;

import interfaces.Subject;

/**
 * Created by chouaib on 17/01/17.
 */
public interface ISensor extends Subject {
    int getValue();

    void tick();
}
