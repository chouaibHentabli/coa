package main;

import core.canal.Canal;
import core.canal.ICanal;
import core.captor.AbstractCaptor;
import core.captor.Captor;
import core.captor.CaptorScheduler;
import core.captor.ICaptor;
import core.difussionStrategy.DiffusionType;
import core.display.Display;
import core.display.IDisplay;
import core.util.Scheduler;
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
    TextField canalDelayA;
    @FXML
    TextField canalDelayB;
    @FXML
    TextField canalDelayC;
    @FXML
    TextField canalDelayD;
    @FXML
    TextField canalDelayE;

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

    CaptorScheduler captorScheduler = new CaptorScheduler(1, 1500, 1);

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
        canalA.setDelay(Integer.parseInt(canalDelayA.getText()));
        canalA.attach(displayA);

        // Second canal
        canalB = new Canal(captor, displayB);
        canalB.setDelay(Integer.parseInt(canalDelayB.getText()));
        canalB.attach(displayB);

        // Third canal
        canalC = new Canal(captor, displayC);
        canalC.setDelay(Integer.parseInt(canalDelayC.getText()));
        canalC.attach(displayC);

        // Fourth canal
        canalD = new Canal(captor, displayD);
        canalD.setDelay(Integer.parseInt(canalDelayD.getText()));
        canalD.attach(displayD);

        // Fifth canal
        canalE = new Canal(captor, displayE);
        canalE.setDelay(Integer.parseInt(canalDelayE.getText()));
        canalE.attach(displayE);

        canalDelayA.textProperty().addListener((observable, oldValue, newValue) -> canalA.setDelay(Integer.parseInt(newValue)));
        canalDelayB.textProperty().addListener((observable, oldValue, newValue) -> canalB.setDelay(Integer.parseInt(newValue)));
        canalDelayC.textProperty().addListener((observable, oldValue, newValue) -> canalC.setDelay(Integer.parseInt(newValue)));
        canalDelayD.textProperty().addListener((observable, oldValue, newValue) -> canalD.setDelay(Integer.parseInt(newValue)));
        canalDelayE.textProperty().addListener((observable, oldValue, newValue) -> canalE.setDelay(Integer.parseInt(newValue)));
        delay.textProperty().addListener((observable, oldValue, newValue) -> reinitCaptor());

        reinitCaptor();
    }


    private void reinitCaptor() {
        captorScheduler.purge();
        captorScheduler.incrementWithStepByPeriod(captor, Integer.parseInt(delay.getText()), TimeUnit.MILLISECONDS);
    }

    public void update(IDisplay display) {
        String value = String.valueOf(display.getValue());
        String time = "";
        if (display.getTime() != 0) {
            time = formatDate(display.getTime().longValue());
        }
        if (valueA != null && timeA != null) {
            if (display.equals(displayA)) {
                valueA.setText(value);
                timeA.setText(time);
            }
        }
        if (valueB != null && timeB != null) {
            if (display.equals(displayB)) {
                valueB.setText(value);
                timeB.setText(time);
            }
        }
        if (valueC != null && timeC != null) {
            if (display.equals(displayC)) {
                valueC.setText(value);
                timeC.setText(time);
            }
        }
        if (valueD != null && timeD != null) {
            if (display.equals(displayD)) {
                valueD.setText(value);
                timeD.setText(time);
            }
        }
        if (valueE != null && timeE != null) {
            if (display.equals(displayE)) {
                valueE.setText(value);
                timeE.setText(time);
            }
        }
    }

    public void update(ICaptor captor) {
        if (valueCaptor != null && timeCaptor != null) {
            valueCaptor.setText(String.valueOf(captor.getValue().getValue()));
            String time = "";
            if (captor.getValue().getTime() != 0 && captor.getValue().getTime() > 500) {
                time = formatDate(captor.getValue().getTime().longValue());
            } else {
                time = "1000";
            }
            timeCaptor.setText(time);
        }
    }


    private String formatDate(long value) {
        return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}