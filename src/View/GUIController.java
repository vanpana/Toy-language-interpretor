package View;

import Controller.Controller;
import Model.ADT.Classes.MyDictionary;
import Model.ADT.Interfaces.MyIDictionary;
import Model.Exceptions.ADTEmptyException;
import Model.Exceptions.ToyException;
import Model.PrgState;
import Repository.Repository;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.util.Callback;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GUIController implements Initializable {

    // Toy language requirements
    private final Controller ctrl;
    private final ArrayList<String> statements_list;
    private int currentStmt;

    public GUIController() {
        this.ctrl = new Controller(new Repository("log.txt"));
        this.statements_list = new ArrayList<String>();
        for (int i = 0; i < Main.getStatements().size(); i++)
            try {
                statements_list.add(Main.getStatements().get(i).toString());
            } catch (ADTEmptyException e) {
                // TODO: implement exception
                e.printStackTrace();
            }
    }

    // Control GUIController
    @FXML
    public HBox mainwindow;

    @FXML
    public ListView<String> statements;
    @FXML
    public Label noOfStatements;

    @FXML
    public TableView<Map.Entry<Integer,Integer>> heaptable;
    @FXML
    public TableColumn heaptable_address;

    @FXML
    public ListView<Integer> outlist;

    @FXML
    public Button onestep_button;

    private void reset() {
        onestep_button.setVisible(true);
        heaptable.getItems().remove(0, heaptable.getItems().size());
        outlist.getItems().remove(0, outlist.getItems().size());
    }

    private void setupStatementList() {
        statements.setItems(FXCollections.observableArrayList(statements_list));
        statements.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                currentStmt = statements.getSelectionModel().getSelectedIndices().get(0);
                reset();
                try {
                    ctrl.setMain(new PrgState(Main.getStatements().get(currentStmt)));
                    ctrl.setupExecutor();
                } catch (ADTEmptyException e) {
                    // TODO: Handle
                }
            }
        });
    }

    private void setupButton() {
        onestep_button.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                boolean response = false;
                try {
                    response = ctrl.oneStep();
                } catch (ToyException e) {
                    // TODO: handle exception
                }
                if (!response) onestep_button.setVisible(false);
                else refreshAll();
            }
        });
    }

    private void refreshAll() {
        refreshHeapTable();
        refreshOutlist();
    }

    private void refreshHeapTable() {
        // use fully detailed type for Map.Entry<String, String>
        TableColumn<Map.Entry<Integer, Integer>, String> column1 = new TableColumn<>("Key");
        column1.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String> p) {
                // this callback returns property for just one cell, you can't use a loop here
                // for first column we use key
                return new SimpleStringProperty(String.valueOf(p.getValue().getKey()));
            }
        });

        TableColumn<Map.Entry<Integer, Integer>, String> column2 = new TableColumn<>("Value");
        column2.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String>, ObservableValue<String>>() {

            @Override
            public ObservableValue<String> call(TableColumn.CellDataFeatures<Map.Entry<Integer, Integer>, String> p) {
                // for second column we use value
                return new SimpleStringProperty(String.valueOf(p.getValue().getValue()));
            }
        });

        ObservableList<Map.Entry<Integer, Integer>> items = FXCollections.observableArrayList(ctrl.getRepo().getPrgList().get(0).getHeap().getContent().entrySet());

        heaptable.setItems(items);
        heaptable.getColumns().setAll(column1, column2);

    }

    private void refreshOutlist() {
        //outlist.setItems(FXCollections.observableArrayList(ctrl.getLog()));
        List<Integer> out = new ArrayList<>();
        for (int i = 0; i < ctrl.getRepo().getPrgList().get(0).getOut().size(); i++)
            try {
                out.add(ctrl.getRepo().getPrgList().get(0).getOut().get(i));
            } catch (ADTEmptyException e) {
                // TODO: handle
            }
        outlist.setItems(FXCollections.observableList(out));
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        noOfStatements.setText("No of stmts: " + String.valueOf(statements_list.size()));
        setupStatementList();
        setupButton();
    }
}
