package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Objects;

import static interfaceControllers.StartPoint.loadNewStage;

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
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//ProductPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        ProductPageController productPageController = fxmlLoader.getController();
        productPageController.init();
    }

    public void init() {
    }
}
