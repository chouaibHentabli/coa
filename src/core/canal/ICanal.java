package core.canal;

import core.captor.ICaptor;
import core.util.ObservateurDeCapteur;

/**
 * Created by chouaib on 20/02/17.
 * proxy
 */


public interface ICanal extends ObservateurDeCapteur, ICaptor {

    Integer getValue();

}
