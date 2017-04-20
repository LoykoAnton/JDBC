import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {

    public static MyConnection connection;
    private Stage stage;
    private BorderPane root;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.stage = primaryStage;
        this.stage.setTitle("Base");
        initMain();
    }

    public void initMain() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("main.fxml"));
            root = loader.load();
            MainController controller = loader.getController();
            controller.setMain(this);
            Scene scene = new Scene(root);
            stage.setTitle("Main");
            stage.setScene(scene);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCity() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("tableCity.fxml"));
            root.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setCountry() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("tableCountry.fxml"));
            root.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void setLanguage() {
        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("tableLanguage.fxml"));
            root.setCenter(loader.load());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        connection = new MyConnection();
        connection.connect();
        launch();
    }
}