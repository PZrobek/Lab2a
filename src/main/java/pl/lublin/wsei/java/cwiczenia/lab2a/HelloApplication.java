package pl.lublin.wsei.java.cwiczenia.lab2a;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("gusInfoGraphic.fxml"));
        Parent root = loader.load();

        Controller controller = loader.getController();
        controller.setHostServices(this.getHostServices());
        controller.setStage(stage);

        Scene scene = new Scene(root, 800, 700);
        stage.setTitle("gusInfoGraphic - interfejs graficzny");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}