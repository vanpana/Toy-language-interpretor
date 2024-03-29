package View;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GUIStarter extends Application {
    // Init GUI
    public static Stage stage;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("toy-gui.fxml"));
        primaryStage.setTitle("Toy language");
        primaryStage.setScene(new Scene(root));
        primaryStage.setResizable(false);
        //TODO: Set your icon
        // primaryStage.getIcons().add(new Image(new File("src/Box13.jpg").toURI().toString()));
        primaryStage.show();

        this.stage = primaryStage;
    }

    public static void runApp() {
        launch();
    }
}
