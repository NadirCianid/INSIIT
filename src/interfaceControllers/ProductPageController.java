package interfaceControllers;

import backend.Product;
import backend.ProductsBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.Objects;

import static backend.ProductsBase.selectedProduct;
import static interfaceControllers.StartPoint.loadNewStage;

public class ProductPageController {

    @FXML
    private Text descriptionText;

    @FXML
    private Label priceLabel;

    @FXML
    private Label productNameLabel;

    @FXML
    private Label ratingLabel;

    @FXML
    private Text specificationsText;

    @FXML
    void newReview(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//NewReviewPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        NewReviewPageController newReviewPageController = fxmlLoader.getController();
        newReviewPageController.init();
    }

    @FXML
    void openReviewPage(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//ReviewPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        if(selectedProduct.getReviewList().size() == 0) {
            StartPoint.openSecondWindow("У данного продукта еще нет отзывов", "Увы");
            return;
        }

        ReviewPageController.currentReview = selectedProduct.getReviewList().get(0);

        ReviewPageController reviewPageController = fxmlLoader.getController();
        reviewPageController.init(true);
    }

    @FXML
    void toMainPage(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//MainPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.init();
    }

    public void init() {
        productNameLabel.setText(selectedProduct.getName());
        ratingLabel.setText("Рейтинг: " + selectedProduct.getRating() + ", Отзывов: "  + selectedProduct.getReviewList().size() + ".");
        priceLabel.setText("Цена - " + selectedProduct.getPrice() + " денег");
        specificationsText.setText(selectedProduct.getSpecifications());
        descriptionText.setText(selectedProduct.getDescription());
    }
}
