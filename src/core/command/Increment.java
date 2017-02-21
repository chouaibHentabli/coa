package core.command;

import core.captor.ICaptor;
import core.difussionStrategy.IDiffusionStrategy;

/**
 * Created by chouaib on 21/02/17.
 */
public class Increment implements Command {

    ICaptor captor;

    @Override
    public void execute() {
        captor.tick();
    }
}
