package captor;

import util.Subject;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 19/02/17.
 */
public interface IAsyncCaptor extends Subject {

    public Future<Integer> getValue();
}
