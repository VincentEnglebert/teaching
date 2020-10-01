package sample;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.effect.Glow;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.transform.Rotate;

import java.util.Observable;
import java.util.Observer;

/**
 * @author Vincent Englebert
 * Manages the Model and the Rendering scene.
 */
public class Controller implements Observer {
    @FXML
    private Text output;

    @FXML
    private Button enter;

    private boolean enterIsUpper = true;
    private boolean start = true;
    private ModelCalculator model;

    public Controller() {
        model = new ModelCalculator();
        model.addObserver(this);
    }

    /**
     * Triggered by the widgets
     *
     * @param event
     */
    @FXML
    private void processNumpad(ActionEvent event) {
        assert event != null;

        if (start) {
            output.setText("0");
            //output.getTransforms().add(new Rotate(20));
            start = false;
/*            enter.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent ae) {
                    model.enter();
                    enter.setText(enterIsUpper? "enter" : "ENTER");
                    enterIsUpper=!enterIsUpper;
                }
            });
 */
            enter.setOnAction(ae -> {
                        model.enter();
                        enter.setText(enterIsUpper ? "enter" : "ENTER");
                        enterIsUpper = !enterIsUpper;
                    }
            );
        }

        String value = ((Button) event.getSource()).getText();
        assert value != null;
        assert model != null;

        System.out.println("(" + value + ")");
        if ("0123456789".contains(value)) {
            assert value.length() == 1 : "value should be ONE digit";
            model.key(Integer.parseInt(value));
        } else if ("+".equals(value)) {
            model.plus();
        } else if ("-".equals(value)) {
            model.minus();
        } else if ("*".equals(value)) {
            model.times();
        } else if ("/".equals(value)) {
            model.divide();
        } else if ("Enter".equalsIgnoreCase(value)) {
            model.enter();
        } else if (".".equals(value)) {
            model.point();
        } else {
            assert false : "Unknown Button's value (" + value + ") !";
        }
    }


    /**
     * Update the display everytime a modification is observed on the model.
     * @param o not used
     * @param arg not used
     *
     */
    @Override
    public void update(Observable o, Object arg) {
        output.setText(model.getDisplay());
    }
}
