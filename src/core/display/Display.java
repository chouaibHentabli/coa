package core.display;

import com.sun.xml.internal.bind.v2.model.core.ID;
import core.canal.ICanal;
import core.captor.IAsyncCaptor;
import core.captor.ICaptor;
import core.util.Subject;
import main.Controller;


/**
 * Created by chouaib on 19/02/17.
 * <p>
 * servant
 */
public class Display implements IDisplay {

    private final Controller controller;
    protected String name;
    private Integer value = 0;
    private Double time = 0.0;
    //lien proxy
    private ICanal canal;
    private static int identifier = 0;

    public Display(Controller controller) {
        this.controller = controller;
        name = "Display_" + ++identifier;
    }



    @Override
    public void update(ICaptor subject) {

    }
}
