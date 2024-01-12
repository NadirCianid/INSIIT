package interfaceControllers;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;


public class StartPoint extends Application {


    @Override
    public void start(Stage stage) throws Exception {
        //Получение FXMLLoader объекта  для перехода к новой сцене и доступа к котроллеру этой сцены
        FXMLLoader fxmlLoader = new FXMLLoader(Objects.requireNonNull(getClass().getResource("..//fxmls//StartPage.fxml")));

        prepareNewStage(stage, fxmlLoader);

        StartPageController startPageController = fxmlLoader.getController();
        startPageController.init();

        environmentInit();
    }

    private void environmentInit() {

    }

    private static void prepareNewStage(Stage stage, FXMLLoader fxmlLoader) throws IOException {
        Parent root = fxmlLoader.load();
        stage.setScene(new Scene(root));
        stage.show();
    }

    public static void loadNewStage(ActionEvent event, FXMLLoader fxmlLoader) throws IOException {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        prepareNewStage(stage, fxmlLoader);
    }

    public static void openSecondWindow(String messageText, String messageTitle) {
        FXMLLoader loader = new FXMLLoader(StartPoint.class.getResource("..//fxmls//messagePage.fxml"));
        Parent root = null;
        try {
            root = loader.load();
        } catch (IOException e) {
            System.out.println("Ошибка загрузки FXMLLoader");
        }

        Stage secondStage = new Stage();
        secondStage.setTitle("Second Window");
        secondStage.setScene(new Scene(root));

        // Получение контроллера второго окна
        // MessagePageController controller = loader.getController();


        secondStage.show();
    }
}