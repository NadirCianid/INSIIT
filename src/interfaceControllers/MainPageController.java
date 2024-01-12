package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

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

    }

    @FXML
    void seeMoreAboutProduct(ActionEvent event) {

    }

}
