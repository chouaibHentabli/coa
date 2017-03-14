package core.command;

import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import core.difussionStrategy.IDiffusionStrategy;

import java.time.LocalDateTime;
import java.time.ZoneOffset;

/**
 * Created by chouaib on 21/02/17.
 */
public class Increment implements Command {

    ICaptor captor;

    public Increment(ICaptor captor) {
        this.captor = captor;
    }

    @Override
    public void execute() {
        double time = 0;
        if (captor.getDiffuseStrategy() == DiffusionType.ATOMIC) {
            time = LocalDateTime.now().toEpochSecond(ZoneOffset.UTC);
        }
        // Increament value in N by 1 and time by 0.01
        //captor.setDiffuseStrategy(captor.getValue() + 1);
        //);
        captor.tick();
    }
}
