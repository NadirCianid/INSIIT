package interfaceControllers;

import backend.Product;
import backend.ProductsBase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.IOException;
import java.util.Objects;

import static interfaceControllers.StartPoint.loadNewStage;

public class MainPageController {

    @FXML
    private ComboBox<String> categoryCB;

    @FXML
    private TableColumn<Product, String> nameTC;

    @FXML
    private TableColumn<Product, String> categoryTC;

    @FXML
    private TableColumn<Product, Integer> priceTC;

    @FXML
    private TableView<Product> productsTV;

    @FXML
    private TableColumn<Product, Integer> ratingTC;

    @FXML
    private TextField searchTF;

    @FXML
    private TableColumn<Product, String> shortDescTC;

    @FXML
    void filterByCategory(ActionEvent event) {
        fillProductsTableView(categoryCB.getValue(), "");
    }

    @FXML
    void filterByName(ActionEvent event) {
        fillProductsTableView(categoryCB.getValue(), searchTF.getText());
    }

    @FXML
    void newProductReview(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//NewReviewPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        selectProduct();

        NewReviewPageController newReviewPageController = fxmlLoader.getController();
        newReviewPageController.init();
    }

    @FXML
    void toProductPage(ActionEvent event) {
        selectProduct();
        StartPoint.goToProductPage(event);
    }

    private void selectProduct() {
        ProductsBase.selectedProduct = productsTV.getSelectionModel().getSelectedItem();
    }

    public void init() {
        categoryCB.setItems(ProductsBase.getCategories());
        fillProductsTableView("Все", "");
        categoryCB.setValue("Все");
    }

    private void fillProductsTableView(String categoryToBeDisplayed, String nameToBeDisplayed) {
        productsTV.getItems().clear();

        //Настройка соответствия столбцов и полей хранимой сущности.
        //Таблица будет хранить товары (объекты Product).
        nameTC.setCellValueFactory(new PropertyValueFactory<>("name"));
        categoryTC.setCellValueFactory(new PropertyValueFactory<>("category"));
        shortDescTC.setCellValueFactory(new PropertyValueFactory<>("shortDescription"));
        ratingTC.setCellValueFactory(new PropertyValueFactory<>("rating"));
        priceTC.setCellValueFactory(new PropertyValueFactory<>("price"));

        if(categoryToBeDisplayed == null) {
            productsTV.setItems(ProductsBase.getProducts());
            return;
        }

        productsTV.setItems(ProductsBase.filter(categoryToBeDisplayed, nameToBeDisplayed));
    }
}
