package main;

import core.captor.AbstractCaptor;
import core.captor.Captor;
import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.net.URL;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;


public class Controller implements Initializable {
    @FXML
    TextField valueCaptor;
    @FXML
    Text valueA;
    @FXML
    Text valueB;
    @FXML
    Text valueC;
    @FXML
    Text valueD;
    @FXML
    Text valueE;

    @FXML
    Text timeCaptor;
    @FXML
    Text timeA;
    @FXML
    Text timeB;
    @FXML
    Text timeC;
    @FXML
    Text timeD;
    @FXML
    Text timeE;
    @FXML
    TextField channelDelayA;
    @FXML
    TextField channelDelayB;
    @FXML
    TextField channelDelayC;
    @FXML
    TextField channelDelayD;
    @FXML
    TextField channelDelayE;

    @FXML
    RadioButton atomic;
    @FXML
    RadioButton sequential;
    @FXML
    RadioButton epoc;

    @FXML
    TextField delay;


    AbstractCaptor captor;

    public Controller() {
        captor = new Captor(this);
    }

    @FXML
    public void setAtomicDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.ATOMIC);
        reinitCaptor();
    }

    @FXML
    public void setSequentialDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.SEQUENTIAL);
        reinitCaptor();
    }

    @FXML
    public void setEpocDiffusion(Event event) {
        captor.setDiffuseStrategy(DiffusionType.EPOC);
        reinitCaptor();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        // Define the strategy and launch the captor processor
        captor.setDiffuseStrategy(DiffusionType.ATOMIC);

        // First canal
        channelA = new Channel(captor);
        channelA.setDelay(Integer.parseInt(channelDelayA.getText()));
        channelA.attach(displayA);

        // Second canal
        channelB = new Channel(captor);
        channelB.setDelay(Integer.parseInt(channelDelayB.getText()));
        channelB.attach(displayB);

        // Third canal
        channelC = new Channel(captor);
        channelC.setDelay(Integer.parseInt(channelDelayC.getText()));
        channelC.attach(displayC);

        // Fourth canal
        channelD = new Channel(captor);
        channelD.setDelay(Integer.parseInt(channelDelayD.getText()));
        channelD.attach(displayD);

        // Fifth canal
        channelE = new Channel(captor);
        channelE.setDelay(Integer.parseInt(channelDelayE.getText()));
        channelE.attach(displayE);

        channelDelayA.textProperty().addListener((observable, oldValue, newValue) -> channelA.setDelay(Integer.parseInt(newValue)));
        channelDelayB.textProperty().addListener((observable, oldValue, newValue) -> channelB.setDelay(Integer.parseInt(newValue)));
        channelDelayC.textProperty().addListener((observable, oldValue, newValue) -> channelC.setDelay(Integer.parseInt(newValue)));
        channelDelayD.textProperty().addListener((observable, oldValue, newValue) -> channelD.setDelay(Integer.parseInt(newValue)));
        channelDelayE.textProperty().addListener((observable, oldValue, newValue) -> channelE.setDelay(Integer.parseInt(newValue)));
        delay.textProperty().addListener((observable, oldValue, newValue) -> reinitCaptor());

        reinitCaptor();
    }


    private void reinitCaptor() {

    }

    private String formatDate(long value) {
        return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}