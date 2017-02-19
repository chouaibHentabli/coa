package interfaces;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 19/02/17.
 */
public interface AsynCaptor extends Subject {

    public Future<Integer> getValue();
}
