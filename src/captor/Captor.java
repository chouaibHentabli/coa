package captor;

import java.util.Observer;
import java.util.concurrent.Future;

/**
 * Created by chouaib on 20/02/17.
 */
public class Captor implements IAsyncCaptor {

    @Override
    public void attach(Observer o) {

    }

    @Override
    public void detach(Observer o) {

    }

    @Override
    public Future<Integer> getValue() {
        return null;
    }
}
