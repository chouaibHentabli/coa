package core.mi;

import core.captor.ICaptor;
import core.util.ValuesContainer;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chouaib on 20/02/17.
 */
public class MethodInvGetValue implements Callable<ValuesContainer> {

    private ICaptor captor;
    private static BlockingQueue queue = new LinkedBlockingQueue<>();


    public MethodInvGetValue(ICaptor captor) {
        this.captor = captor;
    }

    @Override
    public ValuesContainer call() throws Exception {
        return this.captor.getValue();
    }
}
