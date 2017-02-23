package core.canal;

import core.captor.ICaptor;

/**
 * Created by chouaib on 20/02/17.
 * proxy
 */


public interface ICanal extends ICaptor {

    Integer getValue();

    void update(ICaptor captor);

}
