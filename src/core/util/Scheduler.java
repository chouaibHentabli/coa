package core.util;

import java.util.concurrent.ScheduledThreadPoolExecutor;

/**
 * Created by chouaib on 20/02/17.
 */
public class Scheduler extends ScheduledThreadPoolExecutor {

    public Scheduler(int corePoolSize) {
        super(corePoolSize);
    }
}
