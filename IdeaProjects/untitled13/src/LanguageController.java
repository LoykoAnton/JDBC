import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.EventListener;

public class LanguageController {

    private MyConnection connection;
    private ObservableList<Language> list;
    private Main main;
    @FXML
    private TableView<Language> table;
    @FXML
    private TableColumn<Language, String> countryCodeColumn;
    @FXML
    private TableColumn<Language, String> languageColumn;
    @FXML
    private TableColumn<Language, String> isOfficialColumn;
    @FXML
    private TableColumn<Language, Double> percentageColumn;
    @FXML
    private TextField idCountryCode;
    @FXML
    private TextField idLanguage;
    @FXML
    private TextField idIsOfficial;
    @FXML
    private TextField idPercentage;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllLanguage();
        countryCodeColumn.setCellValueFactory(cellData -> cellData.getValue().countryCodeProperty());
        languageColumn.setCellValueFactory(cellData -> cellData.getValue().languageProperty());
        isOfficialColumn.setCellValueFactory(cellData -> cellData.getValue().isOfficialProperty());
        percentageColumn.setCellValueFactory(cellData -> cellData.getValue().percentageProperty().asObject());
        table.setItems(list);
    }

    @FXML
    private void onDelete () {
        connection.deleteLanguage(table.getSelectionModel().getSelectedItem().countryCodeProperty().getValue(), table.getSelectionModel().getSelectedItem().languageProperty().getValue());
        initialize();
    }

    @FXML
    public void OnInsert () {
        connection.addLanguage(idCountryCode.getText(), idLanguage.getText(), idIsOfficial.getText(), Integer.parseInt(idPercentage.getText()));
        initialize();
    }

    public void setMain(Main main) {
        this.main = main;
    }
}