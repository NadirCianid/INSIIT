package interfaceControllers;

import backend.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import static interfaceControllers.StartPoint.loadNewStage;
import static interfaceControllers.StartPoint.user;

public class StartPageController {

    @FXML
    private CheckBox logInAsAdminCheckBox;

    @FXML
    private TextField nameTextField;

    @FXML
    private TextField phoneTextField;

    @FXML
    void logIn(ActionEvent event) {
        String userName = nameTextField.getText();
        String userPhoneNumber = phoneTextField.getText();

        if(!isSurnameValid(userName)) {
            StartPoint.openSecondWindow("Вы ввели некорректное имя", "Ошибка ввода имени");
            clearFields();
            return;
        }

        if(!isPhoneNumberValid(userPhoneNumber)) {
            StartPoint.openSecondWindow("Вы ввели некорректный номер телефона", "Ошибка ввода номера телефона");
            clearFields();
            return;
        }

        if(User.isUserAdmin(userName, userPhoneNumber)) {
            user = new User(userName, userPhoneNumber, true);
        } else {
            user = new User(userName, userPhoneNumber, false);
        }

        System.out.println(user);

        toMainPage(event);
    }


    @FXML
    void logInAsAdmin(ActionEvent event) {
        StartPoint.openSecondWindow("Для того, чтобы войти, как администратор, " +
                "\nвам необходимо ввести ваше имя и номер телефона, сохраненное в базе.", "Вход в роли администратора");
    }

    private void clearFields() {
        nameTextField.clear();
        phoneTextField.clear();
        logInAsAdminCheckBox.setSelected(false);
    }

    // Метод для проверки имени входа
    public static boolean isSurnameValid(String surname) {
        // Регулярное выражение для фамилии на русском языке
        String regex = "^[А-ЯЁа-яё\\- ]+$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(surname);

        return matcher.matches();
    }

    // Метод для проверки номера телефона
    public static boolean isPhoneNumberValid(String phoneNumber) {
        // Регулярное выражение для номера телефона: 10 цифр, первая - 7
        String regex = "^7\\d{10}$";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(phoneNumber);

        return matcher.matches();
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
