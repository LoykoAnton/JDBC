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

public class CountryController {

    private MyConnection connection;
    private ObservableList<Country> list;
    private Main main;

    @FXML
    private TableView<Country> table;
    @FXML
    private TableColumn<Country, String> codeColumn;
    @FXML
    private TableColumn<Country, String> nameColumn;
    @FXML
    private TableColumn<Country, String> continentColumn;
    @FXML
    private TableColumn<Country, String> regionColumn;
    @FXML
    private TableColumn<Country, Integer> surfaceAreaColumn;
    @FXML
    private TableColumn<Country, Integer> indepYearColumn;
    @FXML
    private TableColumn<Country, Integer> populationColumn;
    @FXML
    private TableColumn<Country, Integer> gnpColumn;
    @FXML
    private TableColumn<Country, String> localNameColumn;
    @FXML
    private TableColumn<Country, Integer> capitalColumn;
    @FXML
    private TextField idCode;
    @FXML
    private TextField idContinent;
    @FXML
    private TextField idRegion;
    @FXML
    private TextField idSurfaceArea;
    @FXML
    private TextField idIndepYear;
    @FXML
    private TextField idPopulation;
    @FXML
    private TextField idgnp;
    @FXML
    private TextField idLocationName;
    @FXML
    private TextField idCapital;
    @FXML
    private TextField idName;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllCountry();
        codeColumn.setCellValueFactory(cellData -> cellData.getValue().codeProperty());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        continentColumn.setCellValueFactory(cellData -> cellData.getValue().continentProperty());
        surfaceAreaColumn.setCellValueFactory(cellData -> cellData.getValue().surfaceAreaProperty().asObject());
        indepYearColumn.setCellValueFactory(cellData -> cellData.getValue().indepYearProperty().asObject());
        gnpColumn.setCellValueFactory(cellData -> cellData.getValue().gnpProperty().asObject());
        localNameColumn.setCellValueFactory(cellData -> cellData.getValue().localNameProperty());
        capitalColumn.setCellValueFactory(cellData -> cellData.getValue().capitalProperty().asObject());
        regionColumn.setCellValueFactory(cellData -> cellData.getValue().regionProperty());
        populationColumn.setCellValueFactory(cellData -> cellData.getValue().populationProperty().asObject());
        table.setItems(list);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

