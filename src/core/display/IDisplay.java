package core.display;

import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.Observer;
import core.util.Subject;

/**
 * Created by chouaib on 27/02/17.
 */
public interface IDisplay extends Observer<IAsyncCaptor> {

    public Double getTime();

    public Integer getValue();

}
