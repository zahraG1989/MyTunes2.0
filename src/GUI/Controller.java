package GUI;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.awt.event.ActionEvent;

public class Controller {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() {
        welcomeText.setText("Welcome to MyTunes Application!");
    }

   }
