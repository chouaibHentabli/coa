package main;

import core.canal.Canal;
import core.captor.Captor;
import core.captor.CaptorScheduler;
import core.difussionStrategy.DiffusionType;
import core.display.Display;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;


import java.net.URL;

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


    Canal canalA;
    Canal canalB;
    Canal canalC;
    Canal canalD;
    Canal canalE;

    Display displayA = new Display(this);
    Display displayB = new Display(this);
    Display displayC = new Display(this);
    Display displayD = new Display(this);
    Display displayE = new Display(this);

    Captor captor = new Captor(this);
    CaptorScheduler captorScheduler = new CaptorScheduler(1, 1500, 1);

    public Controller() {

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

        captor.setDiffuseStrategy(DiffusionType.ATOMIC);

        canalA = new Canal(captor);
        canalA.setDelay(Integer.parseInt(canalDelayA.getText()));
        canalA.attach(displayA);

        canalB = new Canal(captor);
        canalB.setDelay(Integer.parseInt(canalDelayB.getText()));
        canalB.attach(displayB);

        canalC = new Canal(captor);
        canalC.setDelay(Integer.parseInt(canalDelayC.getText()));
        canalC.attach(displayC);

        canalD = new Canal(captor);
        canalD.setDelay(Integer.parseInt(canalDelayD.getText()));
        canalD.attach(displayD);

        canalE = new Canal(captor);
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

    public void update(Display display) {
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

    public void update(Captor captor) {
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