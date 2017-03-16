package core.difussionStrategy;


/**
 * Created by chouaib on 15/03/17.
 */
public class AtomicDiffusionStrategy extends AbstractIDiffusionStrategy {

    public AtomicDiffusionStrategy(DiffusionType type) {
        super(type);
    }

    /**
     * Atomic distribution.
     * <p>
     * No data can be lost.
     */
    public void execute() {
        clients.forEach(observer -> observer.update(captor));
    }
}
