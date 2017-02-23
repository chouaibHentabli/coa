package core.display;

import core.captor.IAsyncCaptor;
import core.util.Observer;
import core.util.Subject;
import main.Controller;


/**
 * Created by chouaib on 19/02/17.
 *
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


    public Void update(Subject subject) {
        return null;
    }

    @Override
    public Void update(IAsyncCaptor subject) {
        return null;
    }
}
