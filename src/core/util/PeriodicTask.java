package core.util;

import core.command.Command;

import java.util.TimerTask;

/**
 * Created by chouaib on 21/02/17.
 */
public class PeriodicTask extends TimerTask {

    private Command cmd;


    public PeriodicTask(Command cmd) {
        this.cmd = cmd;
    }

    @Override
    public void run() {
        cmd.execute();
    }
}
