package main;

import core.canal.Canal;
import core.captor.Captor;
import core.captor.CaptorScheduler;
import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import core.display.Display;


import java.util.concurrent.TimeUnit;


public class StandAloneLauncher {

    public static void main(String[] args) {
        // The capteur
        ICaptor captor = new Captor(null);
        captor.setDiffuseStrategy(DiffusionType.ATOMIC);
        CaptorScheduler sc = new CaptorScheduler(1, 1500, 1);
        sc.incrementWithStepByPeriod(captor, 200, TimeUnit.MILLISECONDS);

        // First canal

        Display display1 = new Display(null);
        Canal channel1 = new Canal(captor, display1);
        channel1.setDelay(150);
        channel1.attach(display1);

        // Second canal

        Display display2 = new Display(null);
        Canal channel2 = new Canal(captor, display2);
        channel2.setDelay(600);
        channel2.attach(display2);
    }
}
