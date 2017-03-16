package core.captor;

 import core.canal.Canal;
 import core.difussionStrategy.*;
  import main.Controller;

 import java.util.ArrayList;
 import java.util.List;


/**
 * Created by chouaib on 20/02/17.
 * <p>
 * servant
 */
public class Captor extends AbstractCaptor {

    private List<Canal> canals = new ArrayList<Canal>();
    private Controller controller;

    public Captor(Controller controller) {
        System.out.println(this + " initialized");
        this.controller = controller;
    }


    public void setDiffuseStrategy(DiffusionType type) {
        switch (type) {
            case ATOMIC:
                diffuseStrategy = new AtomicDiffusion(DiffusionType.ATOMIC);
                break;
            case EPOC:
                diffuseStrategy = new EpocDiffusion(DiffusionType.EPOC);
                break;
            case SEQUENTIAL:
                diffuseStrategy = new SeqDiffusion(DiffusionType.SEQUENTIAL);
                break;
        }
        diffuseStrategy.configure(this, observers);
    }


    @Override
    public void tick() {
        diffuseStrategy.execute();
        if (controller != null) {
            controller.update(this);
        }
        System.out.println("Tick with " + diffuseStrategy.getDiffusionType() + "with value " + value);
    }
}
