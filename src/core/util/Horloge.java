package core.util;

import core.command.Command;


import java.util.Timer;

/**
 * Created by chouaib on 21/02/17.
 */
public class Horloge implements IHorloge {

    private Timer timer;


    public Timer getTimer() {
        return timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }


    @Override
    public void activerPeriodiquement(Command cmd, long periodEnSecondes) {
        this.timer = new Timer();
        PeriodicTask task = new PeriodicTask(cmd);
  
        timer.schedule(task, 0, periodEnSecondes);
    }

    @Override
    public void desactiver() {
        timer.cancel();
        timer.purge();
    }
}
