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

public class CityController {

    private MyConnection connection;
    private ObservableList<City> list;
    private Main main;

    @FXML
    private TableView<City> table;
    @FXML
    private TableColumn<City, Integer> idColumn;
    @FXML
    private TableColumn<City, String> nameColumn;
    @FXML
    private TableColumn<City, String> countyCodeColumn;
    @FXML
    private TableColumn<City, String> districtColumn;
    @FXML
    private TableColumn<City, String> populationColumn;
    @FXML
    private TextField ID;
    @FXML
    private TextField idname;
    @FXML
    private TextField idCountryCode;
    @FXML
    private TextField idDistrict;
    @FXML
    private TextField idPopulation;

    @FXML
    public void initialize() {
        connection = Main.connection;
        list = connection.getAllCity();
        idColumn.setCellValueFactory(cellData -> cellData.getValue().IdProperty().asObject());
        nameColumn.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        countyCodeColumn.setCellValueFactory(cellData -> cellData.getValue().countryCodeProperty());
        districtColumn.setCellValueFactory(cellData -> cellData.getValue().districtProperty());
        populationColumn.setCellValueFactory(cellData -> cellData.getValue().populationProperty());
        table.setItems(list);
    }

    public void setMain(Main main) {
        this.main = main;
    }
}

