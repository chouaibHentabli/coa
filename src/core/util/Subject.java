package core.util;



/**
 * Created by chouaib on 17/01/17.
 */
public interface Subject {

    void attach(Observer o);

    void detach(Observer o);

}
