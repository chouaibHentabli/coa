package core.util;

import core.captor.ICaptor;

/**
 * Created by chouaib on 27/02/17.
 */
public interface ObservateurDeCapteur extends Observer<ICaptor> {

    void update(ICaptor subject);
}
