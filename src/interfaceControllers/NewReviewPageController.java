package interfaceControllers;

import backend.Product;
import backend.ProductsBase;
import backend.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.io.IOException;
import java.util.Objects;

import static backend.ProductsBase.selectedProduct;
import static interfaceControllers.StartPoint.goToProductPage;
import static interfaceControllers.StartPoint.loadNewStage;

public class NewReviewPageController {
    private Review newReview;

    @FXML
    private Label clientNameLabel;

    @FXML
    private ChoiceBox<Integer> clientRatingCB;

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
        try {
            newReview.setRating(clientRatingCB.getValue());
            newReview.setAuthorName(clientNameLabel.getText());
            newReview.setText(reviewTextArea.getText());
        } catch (Exception e) {
            StartPoint.openSecondWindow("Произошла ошибка. Проверьте введены ли все параметры отызыва.", "Что-то пошло не так");
            return;
        }

        selectedProduct.addReview(newReview);

        goToProductPage(event);
    }

    @FXML
    void verifyReview(ActionEvent event) {
        newReview.verify(verificationCB.isSelected());
    }

    public void init() {
        newReview = new Review();

        productNameLabel.setText(selectedProduct.getName());
        ratingLabel.setText("Рейтинг: " + selectedProduct.getRating() + ", Отзывов: "  + selectedProduct.getReviewList().size() + ".");
        priceLabel.setText("Цена - " + selectedProduct.getPrice() + " денег");
        clientNameLabel.setText(StartPoint.user.getName());

        clientRatingCB.getItems().add(1);
        clientRatingCB.getItems().add(2);
        clientRatingCB.getItems().add(3);
        clientRatingCB.getItems().add(4);
        clientRatingCB.getItems().add(5);


        if(StartPoint.user.isAdmin()) {
            verificationCB.setDisable(false);
        }
    }
}
