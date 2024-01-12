package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class NewReviewPageController {

    @FXML
    private Label clientNameLabel;

    @FXML
    private ChoiceBox<?> clientRatingCB;

    @FXML
    private Label clientRatingLabel;

    @FXML
    private Label priceLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private TextArea reviewTextArea;

    @FXML
    private CheckBox verificationCB;

    @FXML
    void publishReview(ActionEvent event) {

    }

    @FXML
    void verifyReview(ActionEvent event) {

    }

}
