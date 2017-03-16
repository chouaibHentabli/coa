package core.difussionStrategy;


/**
 * Created by chouaib on 23/01/17.
 */
public class AtomicDiffusion extends AbstractDiffusion {


    public AtomicDiffusion(DiffusionType type) {
        super(type);
    }

    /**
     * Atomic distribution.
     * <p>
     * No data can be lost.
     */
    public void execute() {
        observers.forEach(observer -> observer.update(captor));
    }

}
