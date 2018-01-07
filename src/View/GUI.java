package View;

import Controller.Controller;
import Model.ADT.Classes.MyList;
import Model.Statement.IStmt;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;

public class GUI implements Initializable {

    // Toy language requirements
    private final Controller ctrl;
    private final MyList<IStmt> statements;

    public GUI(Controller ctrl, MyList<IStmt> statements) {
        this.ctrl = ctrl;
        this.statements = statements;
    }

    // Control GUI
    private void displayStatements() {

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
