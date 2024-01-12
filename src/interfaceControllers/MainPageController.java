package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

import static interfaceControllers.StartPoint.loadNewStage;

public class MainPageController {

    @FXML
    private ComboBox<?> categoryCB;

    @FXML
    private TableColumn<?, ?> nameTC;

    @FXML
    private TableColumn<?, ?> priceTC;

    @FXML
    private TableView<?> productsTV;

    @FXML
    private TableColumn<?, ?> ratingTC;

    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<?, ?> shortDescTC;

    @FXML
    void filterByCategory(ActionEvent event) {

    }

    @FXML
    void filterByName(ActionEvent event) {

    }

    @FXML
    void newProductReview(ActionEvent event) {
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
    void toProductPage(ActionEvent event) {
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
