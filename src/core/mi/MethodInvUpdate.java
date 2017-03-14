package core.mi;

import core.canal.ICanal;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chouaib on 20/02/17.
 */
public class MethodInvUpdate implements IMethodInvocation {
    private ICanal canal;
    private static BlockingQueue queue = new LinkedBlockingQueue<>();

    @Override
    public Object call() throws Exception {
        return null; //canal.update(null);
    }

    @Override
    public ICanal getCanal() {
        return this.canal;
    }

    @Override
    public void setCanal(ICanal canal) {
        this.canal = canal;
    }
}
