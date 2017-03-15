package core.difussionStrategy;

import core.captor.ICaptor;
import core.util.Observer;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by chouaib on 23/01/17.
 */
public class SeqDiffusion extends AbstractDiffusion {

    private static BlockingQueue queue = new LinkedBlockingQueue<>();
    private static ThreadPoolExecutor executorService = new ThreadPoolExecutor(10, 1000, 30, TimeUnit.SECONDS, queue);

    public SeqDiffusion(DiffusionType type) {
        super(type);
    }


    @Override
    public void execute() {
        if (queue.isEmpty()) {
            executorService.submit(() -> observers.forEach(observer -> observer.update(captor)));
        }
    }
}
