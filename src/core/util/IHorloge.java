package core.util;

import core.command.Command;

/**
 * Created by chouaib on 21/02/17.
 */
public interface IHorloge {

    //void activerApresDelai(Command cmd, long delaiEnSecondes);

    void activerPeriodiquement(Command cmd, long periodEnSecondes);

    void desactiver();

}
