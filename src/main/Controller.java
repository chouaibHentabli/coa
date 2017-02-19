package main;

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


    public Controller() {
    }

    @FXML
    public void setAtomicDiffusion(Event event) {

    }

    @FXML
    public void setSequentialDiffusion(Event event) {

    }

    @FXML
    public void setEpocDiffusion() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }

    private void reinitCaptor() {

    }

    public void update() {

    }


    private String formatDate(long value) {
        return LocalDateTime.ofEpochSecond(value, 0, ZoneOffset.UTC).format(DateTimeFormatter.ISO_DATE_TIME);
    }
}