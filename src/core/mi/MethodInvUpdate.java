package core.mi;

import core.canal.ICanal;
import core.captor.IAsyncCaptor;
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


    public MethodInvUpdate(ICanal canal) {
        this.canal = canal;
    }

    @Override
    public Boolean call() throws Exception {
        canal.getObservers().forEach(observer -> observer.update(canal));
        return true;
    }
}
