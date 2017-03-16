package core.display;

 import core.captor.IAsyncCaptor;
 import core.util.Observer;
import core.util.ValuesContainer;
import main.Controller;


/**
 * Created by chouaib on 19/02/17.
 * <p>
 * servant
 */
public class Display implements Observer<IAsyncCaptor> {

    private final Controller controller;
    protected String name;
    private Integer value = 0;
    private Double time = 0.0;
    private static int identifier = 0;

    public Display(Controller controller) {
        this.controller = controller;
        name = "Display_" + ++identifier;
    }

    public Void update(IAsyncCaptor captor) {
        try {
            ValuesContainer container = captor.getValues().get();
            String oldValue = String.valueOf(value);
            value = container.getValue();
            if (time <= container.getTime()) {
                time = container.getTime();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (controller != null) {
            controller.update(this);
        }
        System.out.println(this + " receive value=" + value + " with time=" + time);
        return null;
    }

    @Override
    public String toString() {
        return name;
    }

    /**
     * Returns the internal value of this screen
     *
     * @return
     */
    public Integer getValue() {
        return value;
    }

    /**
     * Returns the internal time related value of this screen
     *
     * @return
     */
    public Double getTime() {
        return time;
    }

}
