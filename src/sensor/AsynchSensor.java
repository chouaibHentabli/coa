package sensor;

import java.util.concurrent.Future;

/**
 * Created by chouaib on 17/01/17.
 */
public interface AsynchSensor {

    Future<Integer> getValue();


}
