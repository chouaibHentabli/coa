package core.util;

/**
 * Created by chouaib on 22/02/17.
 */
public class Material {
    private static Material instance = null;
    private static Scheduler scheduler;
    private static IHorloge horloge;


    public static Material getInstance() {
        if (instance == null) {
            horloge = new Horloge();
            scheduler = new Scheduler(100);
            //create instance
            instance = new Material();
            instance.setHorloge(horloge);
            instance.setScheduler(scheduler);
        }
        return instance;
    }


    public static void setScheduler(Scheduler scheduler) {
        Material.scheduler = scheduler;
    }

    public static void setHorloge(IHorloge horloge) {
        Material.horloge = horloge;
    }

    public static Scheduler getScheduler() {

        return scheduler;
    }

    public static IHorloge getHorloge() {
        return horloge;
    }
}
