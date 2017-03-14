package core.mi;

import core.display.IDisplay;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

/**
 * Created by chouaib on 20/02/17.
 */
public class MethodInvUpdate implements IMethodInvocation {

    private IDisplay display;
    private static BlockingQueue queue = new LinkedBlockingQueue<>();


    public MethodInvUpdate(IDisplay display) {
        this.display = display;
    }

    @Override
    public Object call() throws Exception {
        //////////
        display.update(null);
        return true;
    }
}
