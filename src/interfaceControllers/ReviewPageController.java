package interfaceControllers;

import backend.Product;
import backend.ProductsBase;
import backend.Review;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

import static backend.ProductsBase.selectedProduct;
import static interfaceControllers.StartPoint.goToProductPage;
import static interfaceControllers.StartPoint.loadNewStage;

public class ReviewPageController {

    public static Review currentReview;

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
        goToProductPage(event);
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
        if(StartPoint.user.isAdmin()) {
            currentReview.verify(verificationCB.isSelected());
        }

    }

    public void init(Boolean forward) {
        int newReviewIndex = 0;
        int currentReviewIndex = currentReview.getIndex();



        if(selectedProduct.getReviewList().size() > currentReviewIndex + 1 && forward) {
            newReviewIndex = currentReviewIndex + 1;
        } else if(currentReviewIndex > 0 && !forward) {
            newReviewIndex = currentReviewIndex - 1;
        }

        try {
            currentReview = selectedProduct.getReviewList().get(newReviewIndex);
        } catch (IndexOutOfBoundsException e) {
            System.out.println("Движение дальше невозможно");
            return;
        }

        productNameLabel.setText(selectedProduct.getName());
        ratingLabel.setText("Рейтинг: " + selectedProduct.getRating() + ", Отзывов: "  + selectedProduct.getReviewList().size() + ".");
        priceLabel.setText("Цена - " + selectedProduct.getPrice() + " денег");
        reviewText.setText(currentReview.getText());
        clientNameLabel.setText(currentReview.getAuthorName());
        ratingLabel.setText(String.valueOf(currentReview.getRating()));
        verificationCB.setSelected(currentReview.isVerified());

        if(StartPoint.user.isAdmin()) {
            verificationCB.setDisable(false);
        }
    }
}
