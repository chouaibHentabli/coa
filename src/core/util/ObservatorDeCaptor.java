package core.util;

import core.captor.ICaptor;


/**
 * Created by chouaib on 16/03/17.
 */
public interface ObservatorDeCaptor extends Observer<ICaptor> {

    public Void update(ICaptor subject);
}
