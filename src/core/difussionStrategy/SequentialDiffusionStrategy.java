package core.difussionStrategy;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;


/**
 * Created by chouaib on 15/03/17.
 */
public class SequentialDiffusionStrategy extends AbstractIDiffusionStrategy {

    private static BlockingQueue queue = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 1000, 30, TimeUnit.SECONDS, queue);

    public SequentialDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    /**
     * Sequential calls
     * <p>
     * All calls are processed once. Loosing next calls if not finished
     * <p>
     * Data can be lost.
     */
    public void execute() {
        if (queue.isEmpty()) {
            executorService.submit(() -> clients.forEach(observer -> observer.update(captor)));
        }
    }
}
