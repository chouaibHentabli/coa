package core.mi;

import core.canal.ICanal;
import core.captor.ICaptor;
import core.display.IDisplay;
import core.util.ValuesContainer;

import java.util.Calendar;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chouaib on 20/02/17.
 */
public class MethodInvUpdate implements Callable {

    private ICanal canal;
    private static BlockingQueue queue = new LinkedBlockingQueue<>();


    public MethodInvUpdate(ICanal canal) {
        this.canal = canal;
    }

    @Override
    public Object call() throws Exception {
        canal.getObservers().forEach(observer -> observer.update(this));
        return true;
    }
}
