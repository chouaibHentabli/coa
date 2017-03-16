package core.display;

import com.sun.xml.internal.bind.v2.model.core.ID;
import core.canal.ICanal;
import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.Subject;
import core.util.ValuesContainer;
import main.Controller;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;


/**
 * Created by chouaib on 19/02/17.
 * <p>
 * servant
 */
public class Display implements IDisplay {

    protected String name;
    private Integer value = 0;
    private Double time = 0.0;
    //proxy
    private ICanal canal;
    private static int identifier = 0;
    private final Controller controller;


    public Display(Controller controller) {
        this.controller = controller;
        name = "Display_" + ++identifier;
    }


    public Double getTime() {
        return time;
    }

    public void setTime(Double time) {
        this.time = time;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getValue() {
        return value;
    }

    @Override
    public String toString() {
        return name;
    }

    @Override
    public Void update(IAsyncCaptor subject) {
        try {
            ValuesContainer container = canal.getValue().get();
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


}
