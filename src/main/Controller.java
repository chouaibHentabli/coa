package main;

import core.canal.Canal;
import core.canal.ICanal;
import core.captor.AbstractCaptor;
import core.captor.Captor;
import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import core.display.Display;
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
import java.util.Observer;
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


    ICanal canalA;
    ICanal canalB;
    ICanal canalC;
    ICanal canalD;
    ICanal canalE;

    Display displayA = new Display(this);
    Display displayB = new Display(this);
    Display displayC = new Display(this);
    Display displayD = new Display(this);
    Display displayE = new Display(this);
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
        canalA = new Canal(captor, displayA);
        canalA.setDelay(Integer.parseInt(channelDelayA.getText()));
        canalA.attach(displayA);

        // Second canal
        canalB = new Canal(captor, displayB);
        canalB.setDelay(Integer.parseInt(channelDelayB.getText()));
        canalB.attach(displayB);

        // Third canal
        canalC = new Canal(captor, displayC);
        canalC.setDelay(Integer.parseInt(channelDelayC.getText()));
        canalC.attach(displayC);

        // Fourth canal
        canalD = new Canal(captor, displayD);
        canalD.setDelay(Integer.parseInt(channelDelayD.getText()));
        canalD.attach(displayD);

        // Fifth canal
        canalE = new Canal(captor, displayE);
        canalE.setDelay(Integer.parseInt(channelDelayE.getText()));
        canalE.attach(displayE);

        channelDelayA.textProperty().addListener((observable, oldValue, newValue) -> canalA.setDelay(Integer.parseInt(newValue)));
        channelDelayB.textProperty().addListener((observable, oldValue, newValue) -> canalB.setDelay(Integer.parseInt(newValue)));
        channelDelayC.textProperty().addListener((observable, oldValue, newValue) -> canalC.setDelay(Integer.parseInt(newValue)));
        channelDelayD.textProperty().addListener((observable, oldValue, newValue) -> canalD.setDelay(Integer.parseInt(newValue)));
        channelDelayE.textProperty().addListener((observable, oldValue, newValue) -> canalE.setDelay(Integer.parseInt(newValue)));
        delay.textProperty().addListener((observable, oldValue, newValue) -> reinitCaptor());

        reinitCaptor();
    }


    private void reinitCaptor() {

    }

    private String formatDate(long value) {
        return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}