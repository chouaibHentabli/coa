package core.mi;
import core.canal.ICanal;

import java.util.concurrent.Callable;

/**
 * Created by chouaib on 20/02/17.
 */
public interface IMethodInvocation extends Callable {

    ICanal getCanal();

    void setCanal(ICanal canal);
}
