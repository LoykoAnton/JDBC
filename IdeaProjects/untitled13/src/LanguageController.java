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
    private TableColumn<Language, Integer> percantageColumn;
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
        percantageColumn.setCellValueFactory(cellData -> cellData.getValue().percantageProperty().asObject());
        table.setItems(list);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

