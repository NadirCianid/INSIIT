package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

import static interfaceControllers.StartPoint.loadNewStage;

public class ReviewPageController {

    @FXML
    private Label clientNameLabel;

    @FXML
    private Label clientRatingLabel;

    @FXML
    private Button nextReviewButton;

    @FXML
    private Button previousReview;

    @FXML
    private Label priceLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Text reviewText;

    @FXML
    private CheckBox verificationCB;

    @FXML
    void backToProduct(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//ProductPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        ProductPageController productPageController = fxmlLoader.getController();
        productPageController.init();
    }

    @FXML
    void toNextReview(ActionEvent event) {
        move(event, true);
    }

    @FXML
    void toPreviousReview(ActionEvent event) {
        move(event, false);
    }

    private void move(ActionEvent event, Boolean forward) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//ReviewPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        ReviewPageController reviewPageController = fxmlLoader.getController();
        reviewPageController.init(forward); //forward - определяет вперед или назад двигаться по списку отзывов
    }

    @FXML
    void verifyReview(ActionEvent event) {

    }

    public void init(Boolean forward) {
    }
}
