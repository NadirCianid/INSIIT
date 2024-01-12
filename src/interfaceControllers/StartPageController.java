package interfaceControllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;

import static interfaceControllers.StartPoint.loadNewStage;

public class StartPageController {

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    void logIn(ActionEvent event) {
        //TODO: сохранить имя и номер телефона

        toMainPage(event);
    }

    @FXML
    void logInAsAdmin(ActionEvent event) {
        //TODO: вывести сообщение о том, как войти админу
        //TODO: сохранить инфу о том, что зашел админ

        toMainPage(event);
    }

    private void toMainPage(ActionEvent event) {
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//MainPage.fxml")));

        try {
            loadNewStage(event, fxmlLoader);
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        MainPageController mainPageController = fxmlLoader.getController();
        mainPageController.init();
    }

}
